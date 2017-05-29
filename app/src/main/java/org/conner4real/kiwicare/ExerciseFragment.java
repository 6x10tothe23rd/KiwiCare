package org.conner4real.kiwicare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExerciseFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.plankCard) CardView plankCard;
    @BindView(R.id.pushupCard) CardView pushupCard;
    @BindView(R.id.situpCard) CardView situpCard;
    @BindView(R.id.runningCard) CardView runningCard;
    @BindView(R.id.lungeCard) CardView lungeCard;

    String plankURL = "https://en.wikipedia.org/wiki/Plank_(exercise)";
    ExerciseRatings plankRatings = new ExerciseRatings(0.5, 0.1, 1);
    String pushupURL = "https://greatist.com/fitness/how-do-perfect-push";
    ExerciseRatings pushupRatings = new ExerciseRatings(1, 0.1, 0.5);
    String situpURL = "http://www.military.com/military-fitness/fitness-test-prep/proper-technique-for-curl-ups";
    ExerciseRatings situpRatings = new ExerciseRatings(1, 0.1, 0.25);
    String runningURL = "http://www.fitnessmagazine.com/workout/running/running-101-a-beginners-guide/";
    ExerciseRatings runningRatings = new ExerciseRatings(0.1, 1, 0.75);
    String lungeURL = "";
    ExerciseRatings lungeRatings = new ExerciseRatings(0.5, 0.1, 0);

    public ExerciseFragment() {
        // Required empty public constructor
    }

    public static ExerciseFragment newInstance() {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    private void setRatings(ExerciseRatings ratings, View exerciseCard){
        View ratingsContainer = exerciseCard.findViewById(R.id.ratingContainer);

        ProgressBar ratingStrength = (ProgressBar) ratingsContainer.findViewById(R.id.ratingStrength);
        ProgressBar ratingCardio = (ProgressBar) ratingsContainer.findViewById(R.id.ratingCardio);
        ProgressBar ratingEndurance = (ProgressBar) ratingsContainer.findViewById(R.id.ratingEndurance);

        ratingStrength.setProgress((int) (ratings.get_strength() * 100));
        ratingCardio.setProgress((int) (ratings.get_cardio() * 100));
        ratingEndurance.setProgress((int) (ratings.get_endurance() * 100));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);

        ButterKnife.bind(this, view);

        View.OnClickListener clicker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "";

                if (v.equals(plankCard)){
                    url = plankURL;
                }
                else if (v.equals(pushupCard)){
                    url = pushupURL;
                }
                else if (v.equals(situpCard)){
                    url = situpURL;
                }
                else if (v.equals(runningCard)){
                    url = runningURL;
                }
                else if (v.equals(lungeCard)){
                    url = lungeURL;
                }
                else {
                    return;
                }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };

        plankCard.setOnClickListener(clicker);
        setRatings(plankRatings, plankCard);
        pushupCard.setOnClickListener(clicker);
        setRatings(pushupRatings, pushupCard);
        situpCard.setOnClickListener(clicker);
        setRatings(situpRatings, situpCard);
        runningCard.setOnClickListener(clicker);
        setRatings(runningRatings, runningCard);
        lungeCard.setOnClickListener(clicker);
        setRatings(lungeRatings, lungeCard);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
