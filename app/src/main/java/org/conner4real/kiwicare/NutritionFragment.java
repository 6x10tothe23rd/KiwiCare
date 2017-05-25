package org.conner4real.kiwicare;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NutritionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    //TODO: Set recommended amounts in a smart way

    @BindView(R.id.nutritionLabelLink) TextView nutritionLabelLink;

    @BindView(R.id.addAmountCalcium) EditText addAmountCalcium;
    @BindView(R.id.addButtonCalcium) Button addButtonCalcium;
    @BindView(R.id.addTotalCalcium) TextView addTotalCalcium;
    private float calciumTotal = 0;
    private int calciumRecommended = 1300;

    @BindView(R.id.addAmountIron) EditText addAmountIron;
    @BindView(R.id.addButtonIron) Button addButtonIron;
    @BindView(R.id.addTotalIron) TextView addTotalIron;
    private float ironTotal = 0;
    private int ironRecommended = 11;

    @BindView(R.id.addAmountMagnesium) EditText addAmountMagnesium;
    @BindView(R.id.addButtonMagnesium) Button addButtonMagnesium;
    @BindView(R.id.addTotalMagnesium) TextView addTotalMagnesium;
    private float magnesiumTotal = 0;
    private int magnesiumRecommended = 410;

    @BindView(R.id.addAmountVitaminC) EditText addAmountVitaminC;
    @BindView(R.id.addButtonVitaminC) Button addButtonVitaminC;
    @BindView(R.id.addTotalVitaminC) TextView addTotalVitaminC;
    private float vitaminCTotal = 0;
    private int vitaminCRecommended = 75;

    @BindView(R.id.addAmountVitaminA) EditText addAmountVitaminA;
    @BindView(R.id.addButtonVitaminA) Button addButtonVitaminA;
    @BindView(R.id.addTotalVitaminA) TextView addTotalVitaminA;
    private float vitaminATotal = 0;
    private int vitaminARecommended = 75;

    public NutritionFragment() {
        // Required empty public constructor
    }

    public static NutritionFragment newInstance() {
        NutritionFragment fragment = new NutritionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);
        ButterKnife.bind(this, view);

        //TODO: Use actual math from https://www.ncbi.nlm.nih.gov/books/NBK56068/table/summarytables.t3/?report=objectonly

        String fdaLink = "https://www.fda.gov/food/ingredientspackaginglabeling/labelingnutrition/ucm274593.htm";

        nutritionLabelLink.setMovementMethod(LinkMovementMethod.getInstance());
        nutritionLabelLink.setText(Html.fromHtml("Here's the <a href=\"" + fdaLink + "\">official FDA guide</a> to reading nutrition labels on food."));

        addButtonCalcium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addedCalcium = Integer.parseInt(addAmountCalcium.getText().toString());
                calciumTotal += addedCalcium;

                float currentRatio = calciumTotal / calciumRecommended;

                if (currentRatio <= 0.25 || currentRatio >= 1.25){
                    addTotalCalcium.setTextColor(Color.RED);
                }
                else if (currentRatio <= 0.8 || currentRatio > 1){
                    addTotalCalcium.setTextColor(Color.YELLOW);
                }
                else {
                    addTotalCalcium.setTextColor(Color.GREEN);
                }

                addTotalCalcium.setText(calciumTotal + "/" + calciumRecommended + " mg");
            }
        });

        addButtonIron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addedIron = Integer.parseInt(addAmountIron.getText().toString());
                ironTotal += addedIron;

                float currentRatio = ironTotal / ironRecommended;

                if (currentRatio <= 0.25 || currentRatio >= 1.25){
                    addTotalIron.setTextColor(Color.RED);
                }
                else if (currentRatio <= 0.8 || currentRatio > 1){
                    addTotalIron.setTextColor(Color.YELLOW);
                }
                else {
                    addTotalIron.setTextColor(Color.GREEN);
                }

                addTotalIron.setText(ironTotal + "/" + ironRecommended + " mg");
            }
        });

        addButtonMagnesium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addedMagnesium = Integer.parseInt(addAmountMagnesium.getText().toString());
                magnesiumTotal += addedMagnesium;

                float currentRatio = magnesiumTotal / magnesiumRecommended;

                if (currentRatio <= 0.25 || currentRatio >= 1.25){
                    addTotalMagnesium.setTextColor(Color.RED);
                }
                else if (currentRatio <= 0.8 || currentRatio > 1){
                    addTotalMagnesium.setTextColor(Color.YELLOW);
                }
                else {
                    addTotalMagnesium.setTextColor(Color.GREEN);
                }

                addTotalMagnesium.setText(magnesiumTotal + "/" + magnesiumRecommended + " mg");
            }
        });

        addButtonVitaminC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addedVitaminC = Integer.parseInt(addAmountVitaminC.getText().toString());
                vitaminCTotal += addedVitaminC;

                float currentRatio = vitaminCTotal / vitaminCRecommended;

                if (currentRatio <= 0.25 || currentRatio >= 1.25){
                    addTotalVitaminC.setTextColor(Color.RED);
                }
                else if (currentRatio <= 0.8 || currentRatio > 1){
                    addTotalVitaminC.setTextColor(Color.YELLOW);
                }
                else {
                    addTotalVitaminC.setTextColor(Color.GREEN);
                }

                addTotalVitaminC.setText(vitaminCTotal + "/" + vitaminCRecommended + " mg");
            }
        });

        addButtonVitaminA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addedVitaminA = Integer.parseInt(addAmountVitaminA.getText().toString());
                vitaminATotal += addedVitaminA;

                float currentRatio = vitaminATotal / vitaminARecommended;

                if (currentRatio <= 0.25 || currentRatio >= 1.25){
                    addTotalVitaminA.setTextColor(Color.RED);
                }
                else if (currentRatio <= 0.8 || currentRatio > 1){
                    addTotalVitaminA.setTextColor(Color.YELLOW);
                }
                else {
                    addTotalVitaminA.setTextColor(Color.GREEN);
                }

                addTotalVitaminA.setText(vitaminATotal + "/" + vitaminARecommended + " μg");
            }
        });

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
