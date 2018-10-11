package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF2Activity;


public class Crf2PwWeight extends Fragment {

    TextView tv_headingText;

    boolean isDataFiled = false;
    //dialog
    Button btnCancel, btnConform;
    Dialog dialog;
    TextView tv_RomanEngText, tv_engText;

    double avrageVal = -1;


    EditText et_r1_mauc1, et_r2_mauc1, et_r1_mauc2, et_r2_mauc2, et_r1_mauc3, et_r2_mauc3, et_r1_mauc4, et_r2_mauc4;
    Button btn_checkReading, btn_maucSubmit;
    TextView tv_muac_difference1, tv_muac_difference2, tv_muac_difference3, tv_muac_difference4, tv_averageMAUC, tv_ass_id;

    EditText et_readerId_1, et_readerId_2;
    int turn = 1;

    LinearLayout[] listOfLayout;
    LinearLayout ll_muac1, ll_muac2, ll_muac3, ll_muac4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.crf2_lw_weight_fragment, container, false);




        /*tv_headingText = (TextView) view.findViewById(R.id.tv_headingText);
        tv_headingText.setText("Lw Weight");
*/
        et_readerId_1 = (EditText) view.findViewById(R.id.et_readerId_1);
        et_readerId_2 = (EditText) view.findViewById(R.id.et_readerId_2);


        tv_ass_id = (TextView) view.findViewById(R.id.tv_ass_id);

        ll_muac1 = (LinearLayout) view.findViewById(R.id.ll_muac1);
        ll_muac2 = (LinearLayout) view.findViewById(R.id.ll_muac2);
        ll_muac3 = (LinearLayout) view.findViewById(R.id.ll_muac3);
        ll_muac4 = (LinearLayout) view.findViewById(R.id.ll_muac4);

        listOfLayout = new LinearLayout[]{ll_muac1, ll_muac2, ll_muac3, ll_muac4};


        et_r1_mauc1 = (EditText) view.findViewById(R.id.et_r1_mauc1);
        et_r2_mauc1 = (EditText) view.findViewById(R.id.et_r2_mauc1);
        et_r1_mauc2 = (EditText) view.findViewById(R.id.et_r1_mauc2);
        et_r2_mauc2 = (EditText) view.findViewById(R.id.et_r2_mauc2);
        et_r1_mauc3 = (EditText) view.findViewById(R.id.et_r1_mauc3);
        et_r2_mauc3 = (EditText) view.findViewById(R.id.et_r2_mauc3);
        et_r2_mauc4 = (EditText) view.findViewById(R.id.et_r2_mauc4);
        et_r1_mauc4 = (EditText) view.findViewById(R.id.et_r1_mauc4);


        tv_muac_difference1 = (TextView) view.findViewById(R.id.tv_muac_difference1);
        tv_muac_difference2 = (TextView) view.findViewById(R.id.tv_muac_difference2);
        tv_muac_difference3 = (TextView) view.findViewById(R.id.tv_muac_difference3);
        tv_muac_difference4 = (TextView) view.findViewById(R.id.tv_muac_difference4);
        tv_averageMAUC = (TextView) view.findViewById(R.id.tv_averageMAUC);

        btn_maucSubmit = (Button) view.findViewById(R.id.btn_maucSubmit);

        btn_maucSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkFieldValidation()) {

                    CRF2Activity.fragmentManager.beginTransaction().replace(R.id.crf2_frame, new Crf2PwHeightFragment(), null).addToBackStack(null).commit();

                }


            }
        });

        btn_checkReading = (Button) view.findViewById(R.id.btn_checkReading);

        btn_checkReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (turn == 1) {

                    checkReadingEditText(et_r1_mauc1, et_r2_mauc1, tv_muac_difference1);

                } else if (turn == 2) {

                    checkReadingEditText(et_r1_mauc2, et_r2_mauc2, tv_muac_difference2);
                } else if (turn == 3) {

                    checkReadingEditText(et_r1_mauc3, et_r2_mauc3, tv_muac_difference3);
                } else if (turn == 4) {

                    checkReadingEditText(et_r1_mauc4, et_r2_mauc4, tv_muac_difference4);
                }


                //   CRF1Activity.turnId = turn;
            }
        });

     /*   try{  isDataFiled = !CRF1Activity.formCrf1DTO.getMuacAssesments().isEmpty(); }catch (Exception e){}

        if(isDataFiled){

            ArrayList<MuacAssesmentDTO> muacAssesmentDTOS = (ArrayList<MuacAssesmentDTO>) CRF1Activity.formCrf1DTO.getMuacAssesments();

            et_readerId_1.setText(muacAssesmentDTOS.get(0).getReaderCode1());
            et_readerId_2.setText(muacAssesmentDTOS.get(0).getReaderCode2());

            if(muacAssesmentDTOS.size()>=1){

                et_r1_mauc1.setText(muacAssesmentDTOS.get(0).getReading1().toString());
                et_r2_mauc1.setText(muacAssesmentDTOS.get(0).getReading2().toString());
                checkReadingEditText(et_r1_mauc1,et_r2_mauc1,tv_muac_difference1);
            }
            if(muacAssesmentDTOS.size()>=2){
                ll_muac2.setVisibility(View.VISIBLE);
                et_r1_mauc2.setText(muacAssesmentDTOS.get(1).getReading1().toString());
                et_r2_mauc2.setText(muacAssesmentDTOS.get(1).getReading2().toString());
                checkReadingEditText(et_r1_mauc2,et_r2_mauc2,tv_muac_difference2);
            }
            if(muacAssesmentDTOS.size()>=3){
                ll_muac3.setVisibility(View.VISIBLE);
                et_r1_mauc3.setText(muacAssesmentDTOS.get(2).getReading1().toString());
                et_r2_mauc3.setText(muacAssesmentDTOS.get(2).getReading2().toString());
                checkReadingEditText(et_r1_mauc3,et_r2_mauc3,tv_muac_difference3);
            }
            if(muacAssesmentDTOS.size()>=4){
                ll_muac4.setVisibility(View.VISIBLE);
                et_r1_mauc4.setText(muacAssesmentDTOS.get(3).getReading1().toString());
                et_r2_mauc4.setText(muacAssesmentDTOS.get(3).getReading2().toString());
                checkReadingEditText(et_r1_mauc4,et_r2_mauc4,tv_muac_difference4);
            }
        }
*/

        return view;
    }

    public boolean textVaildation(EditText et1, EditText et2) {

        boolean b = true;


        String tem1 = et1.getText().toString();
        String tem2 = et2.getText().toString();


        if (TextUtils.isEmpty(tem1)) {
            et1.setError("Required");
            b = false;
        }
        if (!tem1.contains(".")) {
            et1.setError("Enter Decimal Value");
            b = false;

        }


        if (TextUtils.isEmpty(tem2)) {

            et2.setError("Required");

            b = false;
        }

        if (!tem2.contains(".")) {

            et2.setError("Enter Decimal Value");
            b = false;

        }


        return b;
    }

    public float convertIntoFloat(String value) {

        float val = Float.parseFloat(value);

        return val;
    }

    public void checkReadingEditText(EditText et_1, EditText et_2, TextView tv) {


        if (textVaildation(et_1, et_2)) {

            float f1 = convertIntoFloat(et_1.getText().toString());
            float f2 = convertIntoFloat(et_2.getText().toString());

            float diff = f1 - f2;

            double difference = Math.round(diff * 10000.0) / 10000.0;

            if ((difference <= 0 && difference >= -0.5) || (difference >= 0 && difference <= 0.5)) {


                //  DecimalFormat decimalFormat = new DecimalFormat(10.0);
                ;

                tv.setText(difference + "");
                tv.setTextColor(Color.GREEN);

                et_1.setEnabled(false);
                et_2.setEnabled(false);

                btn_checkReading.setClickable(false);
                btn_checkReading.setBackgroundResource(R.drawable.button_shape_green);

                float temp1 = (f1 + f2) / 2;
                avrageVal = Double.parseDouble(new DecimalFormat("##.#").format(temp1));
                tv_averageMAUC.setText(avrageVal + "");

            } else {

                tv.setText(difference + "");
                tv.setTextColor(Color.RED);

                turn++;

                et_1.setEnabled(false);
                et_2.setEnabled(false);

                if (turn <= 4) {

                    listOfLayout[turn - 1].setVisibility(View.VISIBLE);
                }
                if (turn == 5) {

                    //   myCustomeDialog(1);

                }


            }

        }

    }


/*    public void myCustomeDialog(int i){


        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confromation_dialog);
        dialog.setCancelable(false);



        // dialog = new Dialog(getContext());
        //dialog.setContentView(R.layout.fragment_pw_info_fragment1);
        btnConform = (Button) dialog.findViewById(R.id.btnConform);
        btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        tv_RomanEngText = (TextView) dialog.findViewById(R.id.tv_RomanEngText);
        tv_engText = (TextView) dialog.findViewById(R.id.tv_engText);

        if(i==0){

            tv_RomanEngText.setText("Apny 4 Bar Galt Muac dala h islia form band ho gya h");
            tv_engText.setText("You entered wrong muac thats why form closed");
            btnCancel.setVisibility(View.GONE);
            btnConform.setText("Ok");
        }else {

            ////////////////////////////////////////////////////////////////////////////////
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("notEligble", CounselingCRF1Activity.MODE_PRIVATE);
            int val = sharedPreferences.getInt("val", 0);

            val++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("val",val);
            editor.commit();

            tv_RomanEngText.setText("Average MUAC maamtaLw Trial k laiq nhi");
            tv_engText.setText("Average MUAC is not Valid");

        }


        btnConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(WifiConnectOrNot.haveNetworkConnection(getContext())){

          ///          SendDataToServer.sendCrf1Form(CRF1Activity.formCrf1DTO);

                }else {

//                    SaveAndReadInternalData.saveCrf1FormInternal(getContext(),new Gson().toJson(CRF1Activity.formCrf1DTO, FormCrf1DTO.class));

                }

                dialog.dismiss();
                //  startActivity(new Intent(getContext(), DashboardActivity.class));
                //  getActivity().finish();

            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
        dialog.show();

    }*/


    public boolean checkFieldValidation() {
        boolean b = true;
        String tem1 = et_readerId_1.getText().toString();
        String tem2 = et_readerId_2.getText().toString();

        if (TextUtils.isEmpty(tem1)) {
            et_readerId_1.setError("Must Required");
            b = false;
        } else if (tem1.length() < 3) {

            et_readerId_1.setError("Enter Min Three Digit code");
            b = false;
        }

        if (TextUtils.isEmpty(tem2)) {
            et_readerId_2.setError("Must Required");
            b = false;
        } else if (tem2.length() < 3) {

            et_readerId_2.setError("Enter Min Three Digit code");
            b = false;
        }
        if (avrageVal == -1) {

            b = false;
        }
        String tem3 = et_r2_mauc1.getText().toString();
        String tem4 = et_r1_mauc1.getText().toString();

        if (TextUtils.isEmpty(tem3)) {
            et_r2_mauc1.setError("Must Required");
            b = false;
        }
        if (TextUtils.isEmpty(tem4)) {
            et_r2_mauc1.setError("Must Required");
            b = false;
        }


        return b;
    }

    /*public void dataInsertInForm(){

        List<WeightLwCrf3cDTO> weightLwCrf3cDTOS = new ArrayList<WeightLwCrf3cDTO>();

        if(turn>=1){ weightLwCrf3cDTOS.add(getWeightLwObject(1,et_r1_mauc1,et_r2_mauc1)); }
        if(turn>=2){ weightLwCrf3cDTOS.add(getWeightLwObject(2,et_r1_mauc2,et_r2_mauc2)); }
        if(turn>=3){ weightLwCrf3cDTOS.add(getWeightLwObject(3,et_r1_mauc3,et_r2_mauc3)); }
        if(turn>=4){ weightLwCrf3cDTOS.add(getWeightLwObject(4,et_r1_mauc4,et_r2_mauc4)); }

        CRF3cActivity.formsCrf2AndCrf3All.getFormCrf3cDTO().setWeightLwCrf3c(weightLwCrf3cDTOS);

        CRF3cActivity.formsCrf2AndCrf3All.getFormCrf3cDTO().setQ23(avrageVal+"");
    }*/


    public float getTextFromField(EditText et) {

        return Float.parseFloat(et.getText().toString());
    }

    /*public WeightLwCrf3cDTO getWeightLwObject(int id ,EditText et_1, EditText et_2){

        WeightLwCrf3cDTO weightLwCrf3cDTO = new WeightLwCrf3cDTO();

        weightLwCrf3cDTO.setReader1(getTextFromField(et_1));
        weightLwCrf3cDTO.setReader2(getTextFromField(et_2));
        weightLwCrf3cDTO.setReaderCode1(et_readerId_1.getText().toString());
        weightLwCrf3cDTO.setReaderCode2(et_readerId_2.getText().toString());
        weightLwCrf3cDTO.setId(id);
        weightLwCrf3cDTO.setDifference(getTextFromField(et_1)-getTextFromField(et_2));

        return weightLwCrf3cDTO;
    }*/


}
