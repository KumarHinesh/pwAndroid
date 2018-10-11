package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf3Fragments.crf3Fragments.crf3bFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;

public class Crf3bPastPregnancy extends Fragment {

    TextView tv_heading, tv_q1, tv_q2, tv_q3, tv_q4, tv_q5, tv_q6, tv_q7, tv_q8;

    EditText et_q8;

    RadioGroup rg_q1, rg_q2, rg_q3, rg_q4, rg_q5, rg_q6, rg_q7, rg_q8;

    RadioButton rb_q1, rb_q2, rb_q3, rb_q4, rb_q5, rb_q6, rb_q7, rb_q8;

    Button btn_next;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_crf3b_past_pregnancy, container, false);
        initializeView(view);

        rg_q8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q8 = (RadioButton) view.findViewById(rg_q8.getCheckedRadioButtonId());

            }
        });


        // Inflate the layout for this fragment
        return view;
    }


    public void initializeView(View view){

        // INTIALIZE TEXT VIEW
          tv_heading = (TextView) view.findViewById(R.id.tv_heading);
          tv_q1 = (TextView) view.findViewById(R.id.tv_q1);
          tv_q2 = (TextView) view.findViewById(R.id.tv_q2);
          tv_q3 = (TextView) view.findViewById(R.id.tv_q3);
          tv_q4 = (TextView) view.findViewById(R.id.tv_q4);
          tv_q5 = (TextView) view.findViewById(R.id.tv_q5);
          tv_q6 = (TextView) view.findViewById(R.id.tv_q6);
          tv_q7 = (TextView) view.findViewById(R.id.tv_q7);
          tv_q8 = (TextView) view.findViewById(R.id.tv_q8);


        // INTIALIZE EDIT TEXT
           et_q8 = (EditText) view.findViewById(R.id.et_q8);

        // INTIALIZE RADIO GROUP
           rg_q1 = (RadioGroup) view.findViewById(R.id.rg_q1);
           rg_q2 = (RadioGroup) view.findViewById(R.id.rg_q2);
           rg_q3 = (RadioGroup) view.findViewById(R.id.rg_q3);
           rg_q4 = (RadioGroup) view.findViewById(R.id.rg_q4);
           rg_q5 = (RadioGroup) view.findViewById(R.id.rg_q5);
           rg_q6 = (RadioGroup) view.findViewById(R.id.rg_q6);
           rg_q7 = (RadioGroup) view.findViewById(R.id.rg_q7);
           rg_q8 = (RadioGroup) view.findViewById(R.id.rg_q8);

        // INTIALIZE BUTTON
           btn_next = (Button) view.findViewById(R.id.btn_next);

    }



}
