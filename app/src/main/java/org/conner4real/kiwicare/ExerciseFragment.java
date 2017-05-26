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

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExerciseFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.plankCard) CardView plankCard;
    //@BindView(R.id.pushupCard) CardView pushupCard;
    //@BindView(R.id.situpCard) CardView situpCard;
    //@BindView(R.id.runningCard) CardView runningCard;

    String plankURL = "https://en.wikipedia.org/wiki/Plank_(exercise)";
    ExerciseRatings plankRatings = new ExerciseRatings(0.5, 0.1, 1);
    String pushupURL = "https://greatist.com/fitness/how-do-perfect-push";
    String situpURL = "http://www.military.com/military-fitness/fitness-test-prep/proper-technique-for-curl-ups";
    String runningURL = "http://www.fitnessmagazine.com/workout/running/running-101-a-beginners-guide/";

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

    private void setRatings(ExerciseRatings ratings, View RatingsContainer){
        //TODO: Actually do this, won't be that hard tbh
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
                /*else if (v.equals(pushupCard)){
                    url = pushupURL;
                }
                else if (v.equals(situpCard)){
                    url = situpURL;
                }
                else if (v.equals(runningCard)){
                    url = runningURL;
                }*/
                else {
                    return;
                }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };

        plankCard.setOnClickListener(clicker);
        setRatings(plankRatings, plankCard.findViewById(R.id.ratingContainer));
        //pushupCard.setOnClickListener(clicker);
        //situpCard.setOnClickListener(clicker);
        //runningCard.setOnClickListener(clicker);

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
