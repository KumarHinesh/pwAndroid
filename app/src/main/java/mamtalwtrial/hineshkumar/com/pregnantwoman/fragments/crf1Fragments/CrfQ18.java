package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF1Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.databaseHelperClasses.DatabaseHelper;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FormCrf1DTO;

public class CrfQ18 extends Fragment {

    View view;

    TextView tv_q18, tv_q19;

    RadioGroup rg_q18, rg_q19;

    RadioButton rb_q18, rb_q19;

    EditText et_q18;

    Button btn_next;

    ScrollView scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_crf_q18, container, false);

        initializationViews(view);

        rg_q18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q18 = view.findViewById(rg_q18.getCheckedRadioButtonId());

                if (rb_q18.getTag().toString().equals("10"))
                    et_q18.setVisibility(View.VISIBLE);
                else
                    et_q18.setVisibility(View.GONE);

            }
        });

        rg_q19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q19 = view.findViewById(rg_q19.getCheckedRadioButtonId());

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {

                    DatabaseHelper db = new DatabaseHelper(getContext());
                    long id = db.updateQuestion(CRF1Activity.FORM_ID, new Gson().toJson(CRF1Activity.formCrf1DTO, FormCrf1DTO.class));
                    CRF1Activity.fragmentManager.beginTransaction().replace(R.id.crf1_frame, new Crf1Q20(), null).addToBackStack(null).commit();
                    Log.d("update question id n0 ", id + "");
                } else {
                    Toast.makeText(getContext(), "Please Enter All Fields", Toast.LENGTH_LONG).show();
                }

            }
        });


        // Inflate the layout for this fragment
        return view;
    }


    public void initializationViews(View view) {

        //RADIO GROUP INITIALIZATION
        rg_q18 = view.findViewById(R.id.rg_q18);
        rg_q19 = view.findViewById(R.id.rg_q19);

        //BUTTON INITIALIZATION
        btn_next = view.findViewById(R.id.btn_next);

        //SCROLL VIEW INITIALIZATION
        scrollView = view.findViewById(R.id.scrollView);

        //TEXTVIEW INITIALIZATION
        tv_q18 = view.findViewById(R.id.tv_q18);
        tv_q19 = view.findViewById(R.id.tv_q19);

        //EDIT TEXT INITIALIZATION
        et_q18 = view.findViewById(R.id.et_q18);
    }

    public boolean validation() {


        if (getEditText(rg_q18, rb_q18, et_q18, tv_q18, "10", "", "", "").equals("")) {
            return false;
        } else {
            CRF1Activity.formCrf1DTO.setQ18(getEditText(rg_q18, rb_q18, et_q18, tv_q18, "10", "", "", ""));
            et_q18.setError(null);
        }

        if (isRBCheckedThree(rg_q19, rb_q19, tv_q19).equals("")) {
            return false;
        } else {
            CRF1Activity.formCrf1DTO.setQ19(isRBCheckedThree(rg_q19, rb_q19, tv_q19));
        }

        return true;
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
                    return rb.getTag().toString() + ":" + editText.getText().toString();
                }
            } else {

                return rb.getTag().toString();
            }

        }
    }


}
