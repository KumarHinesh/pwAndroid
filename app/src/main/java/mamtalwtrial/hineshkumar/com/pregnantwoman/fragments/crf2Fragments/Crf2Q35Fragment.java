package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF2Activity;


public class Crf2Q35Fragment extends Fragment {

    Button btn_next;
    RadioGroup rg_q35, rg_q36, rg_q37, rg_q38, rg_q39, rg_q40;
    TextView tv_q35, tv_q36, tv_q37, tv_q38, tv_q39, tv_q40;
    RadioButton rb_q35, rb_q36, rb_q37, rb_q38, rb_q39, rb_q40;
    ScrollView scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_crf2_q35, container, false);
        initializeViews(view);

        rg_q35.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q35 = view.findViewById(rg_q35.getCheckedRadioButtonId());
            }
        });

        rg_q36.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q36 = view.findViewById(rg_q36.getCheckedRadioButtonId());
            }
        });

        rg_q37.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q37 = view.findViewById(rg_q37.getCheckedRadioButtonId());
            }
        });

        rg_q38.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q38 = view.findViewById(rg_q38.getCheckedRadioButtonId());
            }
        });

        rg_q39.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q39 = view.findViewById(rg_q39.getCheckedRadioButtonId());
            }
        });

        rg_q40.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q40 = view.findViewById(rg_q40.getCheckedRadioButtonId());
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {
                    btn_next.setEnabled(false);
                    CRF2Activity.fragmentManager.beginTransaction().replace(R.id.crf2_frame, new Crf2Q42Fragment(), null).addToBackStack(null).commit();

                }
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void initializeViews(View view) {

        btn_next = view.findViewById(R.id.btn_next);

        rg_q35 = view.findViewById(R.id.rg_q35);
        rg_q36 = view.findViewById(R.id.rg_q36);
        rg_q37 = view.findViewById(R.id.rg_q37);
        rg_q38 = view.findViewById(R.id.rg_q38);
        rg_q39 = view.findViewById(R.id.rg_q39);
        rg_q40 = view.findViewById(R.id.rg_q40);

        tv_q35 = view.findViewById(R.id.tv_q35);
        tv_q36 = view.findViewById(R.id.tv_q36);
        tv_q37 = view.findViewById(R.id.tv_q37);
        tv_q38 = view.findViewById(R.id.tv_q38);
        tv_q39 = view.findViewById(R.id.tv_q39);
        tv_q40 = view.findViewById(R.id.tv_q40);

        scrollView = view.findViewById(R.id.scrollView);
    }


    public boolean validation() {

        if (isRBCheckedThree(rg_q35, rb_q35, tv_q35).equals(""))
            return false;

        if (isRBCheckedThree(rg_q36, rb_q36, tv_q36).equals(""))
            return false;

        if (isRBCheckedThree(rg_q37, rb_q37, tv_q37).equals(""))
            return false;
        else
                    //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

            if (isRBCheckedThree(rg_q38, rb_q38, tv_q38).equals(""))
                return false;
            else
                        //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

                if (isRBCheckedThree(rg_q39, rb_q39, tv_q39).equals(""))
                    return false;

        return !isRBCheckedThree(rg_q40, rb_q40, tv_q40).equals("");
    }

    int x, y;

    public void setFocuseable(float x1, float y1) {

        x = (int) x1;
        y = (int) y1;

        scrollView.post(new Runnable() {
            public void run() {
                scrollView.scrollTo(x, y); // these are your x and y coordinates
            }
        });

    }

    public String isRBCheckedThree(RadioGroup rg, RadioButton rb, TextView tv) {

        if (rg.getCheckedRadioButtonId() == -1) {
            tv.setError("Required");
            setFocuseable(tv.getX(), tv.getY());
            return "";
        } else {
            return rb.getTag().toString();
        }
    }


}
