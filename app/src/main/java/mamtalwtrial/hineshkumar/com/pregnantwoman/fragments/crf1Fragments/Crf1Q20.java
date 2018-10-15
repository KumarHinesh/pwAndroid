package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF1Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF1DashboardActivity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.LoginActivity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.FoetusesContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.core.DatabaseHelper;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FoetusesDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.UltrasoundExaminationDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit.APIService;
import mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Crf1Q20 extends Fragment {

    RadioButton rb_q18, rb_q19, rb_q20, rb_q21, rb_q22, rb_q23, rb_q33, rb_q34;

    ScrollView scrollView;

    EditText et_q18, et_q24, et_q25, et_q26, et_q27, et_q28, et_q29, et_q30, et_q31, et_q32, et_q36, et_q37;

    Button btn_next;

    RadioGroup rg_q18, rg_q19, rg_q20, rg_q21, rg_q22, rg_q23, rg_q33, rg_q34;

    TextView tv_q18, tv_q19, tv_q20, tv_q21, tv_q22, tv_q23, tv_q33, tv_q34;

    CheckBox cb_q35_1, cb_q35_2, cb_q35_3, cb_q35_4, cb_q35_5, cb_q35_6, cb_q35_7, cb_q35_8, cb_q35_9, cb_q35_10, cb_q35_11;


    ProgressDialog progressDialog;
    UltrasoundExaminationDTO ultrasoundExaminationDTO;
    private static final String Tag = "getContext";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_crf1_q18, container, false);
        initializeViews(view, getContext());

        /* rg_q18.check(rg_q18.getChildAt(4).getId());*/

        rg_q20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q20 = view.findViewById(rg_q20.getCheckedRadioButtonId());
            }
        });

        rg_q21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q21 = view.findViewById(rg_q21.getCheckedRadioButtonId());
            }
        });

        rg_q22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q22 = view.findViewById(rg_q22.getCheckedRadioButtonId());
            }
        });

        rg_q23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q23 = view.findViewById(rg_q23.getCheckedRadioButtonId());
            }
        });

        rg_q33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q33 = view.findViewById(rg_q33.getCheckedRadioButtonId());
            }
        });

        rg_q34.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q34 = view.findViewById(rg_q34.getCheckedRadioButtonId());
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validation()) {

                    if ((Integer.parseInt(CRF1Activity.formCrf1DTO.getQ19()) == 2 || Integer.parseInt(CRF1Activity.formCrf1DTO.getQ19()) == 3)
                            && CRF1Activity.babyNo < Integer.parseInt(CRF1Activity.formCrf1DTO.getQ19())) {

                        CRF1Activity.babyNo++;

                        DatabaseHelper db = new DatabaseHelper(getContext());
                        FoetusesContract foetusesContract = new FoetusesContract();

                        foetusesContract.setCrf1(CRF1Activity.FORM_ID + "");
                        foetusesContract.setUUID(CRF1Activity.DEVICE_ID + ":" + CRF1Activity.FORM_ID);
                        String str = dataInJson();
                        foetusesContract.setsA1(str);
                        long id = db.addfoetuses(foetusesContract);

                        if (id != -1) {
                            db.updateFoetusesUID(CRF1Activity.DEVICE_ID + "_" + id, id);

                            Log.d("Add record succes", id + "");
                            CRF1Activity.fragmentManager.beginTransaction().replace(R.id.crf1_frame, new Crf1Q20(), null).addToBackStack(null).commit();
                        } else {
                            Log.d("form not saved", id + "");
                        }


                    } else {

                        DatabaseHelper db = new DatabaseHelper(getContext());

                        FoetusesContract foetusesContract = new FoetusesContract();

                        foetusesContract.setCrf1(CRF1Activity.FORM_ID + "");
                        foetusesContract.setUUID(CRF1Activity.FORM_UID);
                        String str = dataInJson();
                        foetusesContract.setsA1(str);
                        long id = db.addfoetuses(foetusesContract);

                        if (id != -1) {
                            id = db.updateFoetusesUID(CRF1Activity.DEVICE_ID + "_" + id, id);
                            startActivity(new Intent(getContext(), CRF1DashboardActivity.class));
                        } else {
                            Log.d("0000000111", id + "form foetuses not saved");
                        }

                        foetusesContract.setUID(CRF1Activity.DEVICE_ID + ":" + 1);

                        Log.d("Add record succes", id + "");

                    }

                } else {

                    Toast.makeText(getContext(), "Enter Complete Details", Toast.LENGTH_LONG).show();

                }
            }
        });


        return view;
    }

    public String checkEditTextField(EditText editText) {
        String data = "";
        if (!editText.getText().toString().equalsIgnoreCase(""))
            data = editText.getText().toString();
        else
            editText.setError("Please Enter");
        return data;
    }

    public boolean validation() {

        boolean validation = true;


       /* if (getEditText(rg_q18, rb_q18, et_q18, tv_q18, "10", "", "", "").equals("")) {
            return false;
        } else {
            CRF1Activity.formCrf1DTO.setQ18(getEditText(rg_q18, rb_q18, et_q18, tv_q18, "10", "", "", ""));
        }

        if (isRBCheckedThree(rg_q19, rb_q19, tv_q19).equals("")) {
            return false;
        } else {
            CRF1Activity.formCrf1DTO.setQ19(isRBCheckedThree(rg_q19, rb_q19, tv_q19));
        }*/

        if (isRBCheckedThree(rg_q20, rb_q20, tv_q20).equals("")) {
            return false;
        }

        if (isRBCheckedThree(rg_q21, rb_q21, tv_q21).equals("")) {
            return false;
        }

        if (isRBCheckedThree(rg_q22, rb_q22, tv_q22).equals("")) {
            return false;
        }

        if (isRBCheckedThree(rg_q23, rb_q23, tv_q23).equals("")) {
            return false;
        }

        if (checkEditTextField(et_q24).equals(""))
            return false;


        if (checkEditTextField(et_q25).equals(""))
            return false;


        if (checkEditTextField(et_q26).equals(""))
            return false;


        if (checkEditTextField(et_q27).equals(""))
            return false;


        if (checkEditTextField(et_q28).equals(""))
            return false;


        if (checkEditTextField(et_q29).equals(""))
            return false;

        if (checkEditTextField(et_q30).equals(""))
            return false;

        if (checkEditTextField(et_q31).equals(""))
            return false;

        if (checkEditTextField(et_q32).equals(""))
            return false;

        if (checkEditTextField(et_q36).equals(""))
            return false;

        if (checkEditTextField(et_q37).equals(""))
            return false;

        if (rg_q33.getCheckedRadioButtonId() == -1)
            return false;


        return validateCheckBox();
    }


    public void initializeViews(View view, Context context) {

        //initialiling  RADIO GROUPS
        rg_q18 = view.findViewById(R.id.rg_q18);
        rg_q19 = view.findViewById(R.id.rg_q19);
        rg_q20 = view.findViewById(R.id.rg_q20);
        rg_q21 = view.findViewById(R.id.rg_q21);
        rg_q22 = view.findViewById(R.id.rg_q22);
        rg_q23 = view.findViewById(R.id.rg_q23);
        rg_q33 = view.findViewById(R.id.rg_q33);
        rg_q34 = view.findViewById(R.id.rg_q34);


        //initialiling TEXT VIEW
        tv_q18 = view.findViewById(R.id.tv_q18);
        tv_q19 = view.findViewById(R.id.tv_q19);
        tv_q20 = view.findViewById(R.id.tv_q20);
        tv_q21 = view.findViewById(R.id.tv_q21);
        tv_q22 = view.findViewById(R.id.tv_q22);
        tv_q23 = view.findViewById(R.id.tv_q23);
        tv_q33 = view.findViewById(R.id.tv_q33);
        tv_q34 = view.findViewById(R.id.tv_q34);

        //initialiling EDIT TEXT
        et_q18 = view.findViewById(R.id.et_q18);
        et_q24 = view.findViewById(R.id.et_q24);
        et_q25 = view.findViewById(R.id.et_q25);
        et_q26 = view.findViewById(R.id.et_q26);
        et_q27 = view.findViewById(R.id.et_q27);
        et_q28 = view.findViewById(R.id.et_q28);
        et_q29 = view.findViewById(R.id.et_q29);
        et_q30 = view.findViewById(R.id.et_q30);
        et_q31 = view.findViewById(R.id.et_q31);
        et_q32 = view.findViewById(R.id.et_q32);
        et_q36 = view.findViewById(R.id.et_q36);
        et_q37 = view.findViewById(R.id.et_q37);


        //initialiling SCROLL VIEW
        scrollView = view.findViewById(R.id.scrollView);


        //initialiling BUTTON
        btn_next = view.findViewById(R.id.btn_next);


        //initialiling RELATIVE LAYOUT

        //initialiling ProgressDialog
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Wait..");
        progressDialog.setMessage("Send Form Crf-1");

        //initialiling CheckBox
        cb_q35_1 = view.findViewById(R.id.cb_q35_1);
        cb_q35_2 = view.findViewById(R.id.cb_q35_2);
        cb_q35_3 = view.findViewById(R.id.cb_q35_3);
        cb_q35_4 = view.findViewById(R.id.cb_q35_4);
        cb_q35_5 = view.findViewById(R.id.cb_q35_5);
        cb_q35_6 = view.findViewById(R.id.cb_q35_6);
        cb_q35_7 = view.findViewById(R.id.cb_q35_7);
        cb_q35_8 = view.findViewById(R.id.cb_q35_8);
        cb_q35_9 = view.findViewById(R.id.cb_q35_9);
        cb_q35_10 = view.findViewById(R.id.cb_q35_10);
        cb_q35_11 = view.findViewById(R.id.cb_q35_11);


        //ultrasoundExaminationDTO = new UltrasoundExaminationDTO();
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


    public void sendDataToServer() {

        APIService mAPIService = ApiUtils.getAPIService();
        progressDialog.show();
        mAPIService.sendCrf1(CRF1Activity.formCrf1DTO).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.code() == 200) {
                    progressDialog.dismiss();
                    // Toast.makeText(getContext(), response.message(),Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    getActivity().finish();

                } else {
                    //Toast.makeText(getContext(), response.message(),Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    getActivity().finish();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
                //Toast.makeText(getContext(), t.getMessage(),Toast.LENGTH_LONG).show();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

    }

    public String dataInJson() {

        String str = "";

        FoetusesDTO foetusesDTO = new FoetusesDTO();

        /*foetusesDTO.setForm_id(CRF1Activity.FORM_ID + "");*/
        foetusesDTO.setQ20(isRBCheckedThree(rg_q20, rb_q20, tv_q20));
        foetusesDTO.setQ21(isRBCheckedThree(rg_q21, rb_q21, tv_q21));
        foetusesDTO.setQ22(isRBCheckedThree(rg_q22, rb_q22, tv_q22));
        foetusesDTO.setQ23(isRBCheckedThree(rg_q23, rb_q23, tv_q23));
        foetusesDTO.setQ24(checkEditTextField(et_q24));
        foetusesDTO.setQ25(checkEditTextField(et_q25));
        foetusesDTO.setQ26(checkEditTextField(et_q26));
        foetusesDTO.setQ27(checkEditTextField(et_q27));
        foetusesDTO.setQ28(checkEditTextField(et_q28));
        foetusesDTO.setQ29(checkEditTextField(et_q29));
        foetusesDTO.setQ30(checkEditTextField(et_q30));
        foetusesDTO.setQ31(checkEditTextField(et_q31));
        foetusesDTO.setQ32(checkEditTextField(et_q32));
        foetusesDTO.setQ33(isRBCheckedThree(rg_q33, rb_q33, tv_q33));
        foetusesDTO.setQ34(isRBCheckedThree(rg_q34, rb_q34, tv_q34));

        if (cb_q35_1.isChecked())
            foetusesDTO.setQ35a("1");

        if (cb_q35_2.isChecked())
            foetusesDTO.setQ35b("2");

        if (cb_q35_3.isChecked())
            foetusesDTO.setQ35c("3");

        if (cb_q35_4.isChecked())
            foetusesDTO.setQ35d("4");

        if (cb_q35_5.isChecked())
            foetusesDTO.setQ35e("5");

        if (cb_q35_6.isChecked())
            foetusesDTO.setQ35f("6");

        if (cb_q35_7.isChecked())
            foetusesDTO.setQ35g("7");

        if (cb_q35_8.isChecked())
            foetusesDTO.setQ35h("8");

        if (cb_q35_9.isChecked())
            foetusesDTO.setQ35i("9");

        if (cb_q35_10.isChecked())
            foetusesDTO.setQ35j("10");

        if (cb_q35_11.isChecked())
            foetusesDTO.setQ35k("11");

        foetusesDTO.setQ36(checkEditTextField(et_q36));
        foetusesDTO.setQ37(checkEditTextField(et_q37));

        str = new Gson().toJson(foetusesDTO, FoetusesDTO.class);

        return str;
    }

    public boolean validateCheckBox() {

        if (cb_q35_1.isChecked())
            return true;
        else
            cb_q35_1.setError("Select One");


        if (cb_q35_2.isChecked())
            return true;
        else
            cb_q35_2.setError("Select One");


        if (cb_q35_3.isChecked())
            return true;
        else
            cb_q35_3.setError("Select One");


        if (cb_q35_4.isChecked())
            return true;
        else
            cb_q35_4.setError("Select One");


        if (cb_q35_5.isChecked())
            return true;
        else
            cb_q35_5.setError("Select One");


        if (cb_q35_6.isChecked())
            return true;
        else
            cb_q35_6.setError("Select One");


        if (cb_q35_7.isChecked())
            return true;
        else
            cb_q35_7.setError("Select One");


        if (cb_q35_8.isChecked())
            return true;
        else
            cb_q35_8.setError("Select One");


        if (cb_q35_9.isChecked())
            return true;
        else
            cb_q35_9.setError("Select One");


        if (cb_q35_10.isChecked())
            return true;
        else
            cb_q35_10.setError("Select One");


        if (cb_q35_11.isChecked())
            return true;
        else
            cb_q35_11.setError("Select One");


        return false;
    }

}
