package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF2Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf3Fragments.crf3Fragments.crf3aFragments.Crf3aQ15Fragment;


public class Crf2Q42Fragment extends Fragment {

    EditText et_q45, et_q44;
    Button btn_next;
    RadioGroup rg_q42, rg_q43, rg_q44, rg_q45, rg_q46, rg_q47;
    TextView tv_q42, tv_q43, tv_q44, tv_q45, tv_q46, tv_q47;
    RadioButton rb_q42, rb_q43, rb_q44, rb_q45, rb_q46, rb_q47;
    ScrollView scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.crf2_q42, container, false);
        initializeViews(view);

        rg_q42.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q42 = (RadioButton) view.findViewById(rg_q42.getCheckedRadioButtonId());
            }
        });

        rg_q43.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q43 = (RadioButton) view.findViewById(rg_q43.getCheckedRadioButtonId());
            }
        });

        rg_q44.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q44 = (RadioButton) view.findViewById(rg_q44.getCheckedRadioButtonId());

                if (rb_q44.getTag().equals("1"))
                    et_q44.setVisibility(View.GONE);
                else
                    et_q44.setVisibility(View.VISIBLE);
            }
        });

        rg_q45.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q45 = (RadioButton) view.findViewById(rg_q45.getCheckedRadioButtonId());

                if (rb_q45.getTag().equals("1"))
                    et_q45.setVisibility(View.GONE);
                else
                    et_q45.setVisibility(View.VISIBLE);
            }
        });

        rg_q46.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q46 = (RadioButton) view.findViewById(rg_q46.getCheckedRadioButtonId());
            }
        });

        rg_q47.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q47 = (RadioButton) view.findViewById(rg_q47.getCheckedRadioButtonId());
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {
                    btn_next.setEnabled(false);
                    CRF2Activity.fragmentManager.beginTransaction().replace(R.id.crf2_frame, new Crf3aQ15Fragment(), null).addToBackStack(null).commit();


                }
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void initializeViews(View view) {

        btn_next = (Button) view.findViewById(R.id.btn_next);

        rg_q42 = (RadioGroup) view.findViewById(R.id.rg_q42);
        rg_q43 = (RadioGroup) view.findViewById(R.id.rg_q43);
        rg_q44 = (RadioGroup) view.findViewById(R.id.rg_q44);
        rg_q45 = (RadioGroup) view.findViewById(R.id.rg_q45);
        rg_q46 = (RadioGroup) view.findViewById(R.id.rg_q46);
        rg_q47 = (RadioGroup) view.findViewById(R.id.rg_q47);

        tv_q42 = (TextView) view.findViewById(R.id.tv_q42);
        tv_q43 = (TextView) view.findViewById(R.id.tv_q43);
        tv_q44 = (TextView) view.findViewById(R.id.tv_q44);
        tv_q45 = (TextView) view.findViewById(R.id.tv_q45);
        tv_q46 = (TextView) view.findViewById(R.id.tv_q46);
        tv_q47 = (TextView) view.findViewById(R.id.tv_q47);

        et_q45 = (EditText) view.findViewById(R.id.et_q45);
        et_q44 = (EditText) view.findViewById(R.id.et_q44);

        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
    }


    public boolean validation() {

        boolean validation = true;

        if (isRBCheckedThree(rg_q42, rb_q42, tv_q42).equals(""))
            validation = false;
        else
            //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

            if (isRBCheckedThree(rg_q43, rb_q43, tv_q43).equals(""))
                validation = false;
            else
                //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

                if (getEditText(rg_q44, rb_q44, et_q44, tv_q44, "2", null, null, null).equals(""))
                    validation = false;
                else
                    //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

                    if (getEditText(rg_q45, rb_q45, et_q45, tv_q45, "2", null, null, null).equals(""))
                        validation = false;
                    else
                        //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

                        if (isRBCheckedThree(rg_q46, rb_q46, tv_q46).equals(""))
                            validation = false;
                        else
                            //CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));

                            if (isRBCheckedThree(rg_q47, rb_q47, tv_q47).equals(""))
                                validation = false;
                            else
                                validation = true;//CRF1Activity.formCrf1DTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));


        return validation;
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
            tv.setError(null);
            return rb.getTag().toString();
        }
    }

    public String getEditText(RadioGroup rg, RadioButton rb, EditText editText, TextView tv, String id, String id2, String id3, String id4) {

        if (rg.getCheckedRadioButtonId() == -1) {
            setFocuseable(tv.getX(), tv.getY());
            tv.setError("Required");
            return "";
        } else {
            if (rb.getTag().toString().equals(id) || rb.getTag().toString().equals(id2) ||
                    rb.getTag().toString().equals(id3) || rb.getTag().toString().equals(id4)) {

                if (editText.getText().toString().equals("") || editText.getText().toString().isEmpty()) {
                    editText.setError("Enter Here");
                    setFocuseable(editText.getX(), editText.getY());
                    return "";
                } else {
                    return editText.getText().toString();
                }
            } else {

                return rb.getTag().toString();
            }

        }
    }


}
