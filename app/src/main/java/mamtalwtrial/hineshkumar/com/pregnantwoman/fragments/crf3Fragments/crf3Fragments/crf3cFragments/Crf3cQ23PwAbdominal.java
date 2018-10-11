package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf3Fragments.crf3Fragments.crf3cFragments;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF2Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments.Crf2PwHeightFragment;


public class Crf3cQ23PwAbdominal extends Fragment {

    TextView tv_headingText;

    boolean isDataFiled=false;
    //dialog
    Button btnCancel,btnConform;
    Dialog dialog;
    TextView  tv_RomanEngText, tv_engText;

    double avrageVal = -1;


    EditText et_r1_abdominal1, et_r2_abdominal1, et_r1_abdominal2, et_r2_abdominal2, et_r1_abdominal3, et_r2_abdominal3, et_r1_abdominal4, et_r2_abdominal4;
    Button btn_checkReading, btn_next;
    TextView tv_reading_difference1, tv_reading_difference2,tv_reading_difference3, tv_reading_difference4, tv_averageMAUC,tv_ass_id;

    EditText et_readerId_1,et_readerId_2;
    int turn = 1;

    LinearLayout[] listOfLayout;
    LinearLayout ll_abdominal1, ll_abdominal2, ll_abdominal3, ll_abdominal4;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.crf3c_pw_abdominal, container, false);

        et_readerId_1 = (EditText) view.findViewById(R.id.et_readerId_1);
        et_readerId_2 = (EditText) view.findViewById(R.id.et_readerId_2);
        

        ll_abdominal1 = (LinearLayout) view.findViewById(R.id.ll_abdominal1);
        ll_abdominal2 = (LinearLayout) view.findViewById(R.id.ll_abdominal2);
        ll_abdominal3 = (LinearLayout) view.findViewById(R.id.ll_abdominal3);
        ll_abdominal4 = (LinearLayout) view.findViewById(R.id.ll_abdominal4);

        listOfLayout = new LinearLayout[]{ll_abdominal1, ll_abdominal2, ll_abdominal3, ll_abdominal4};
        
        et_r1_abdominal1 = (EditText) view.findViewById(R.id.et_r1_abdominal1);
        et_r2_abdominal1 = (EditText) view.findViewById(R.id.et_r2_abdominal1);
        et_r1_abdominal2 = (EditText) view.findViewById(R.id.et_r1_abdominal2);
        et_r2_abdominal2 = (EditText) view.findViewById(R.id.et_r2_abdominal2);
        et_r1_abdominal3 = (EditText) view.findViewById(R.id.et_r1_abdominal3);
        et_r2_abdominal3 = (EditText) view.findViewById(R.id.et_r2_abdominal3);
        et_r2_abdominal4 = (EditText) view.findViewById(R.id.et_r2_abdominal4);
        et_r1_abdominal4 = (EditText) view.findViewById(R.id.et_r1_abdominal4);


        tv_reading_difference1 = (TextView) view.findViewById(R.id.tv_reading_difference1);
        tv_reading_difference2 = (TextView) view.findViewById(R.id.tv_reading_difference2);
        tv_reading_difference3 = (TextView) view.findViewById(R.id.tv_reading_difference3);
        tv_reading_difference4 = (TextView) view.findViewById(R.id.tv_reading_difference4);
        tv_averageMAUC = (TextView) view.findViewById(R.id.tv_averageMAUC);

        btn_next = (Button) view.findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkFieldValidation()){

                    CRF2Activity.fragmentManager.beginTransaction().replace(R.id.crf2_frame, new Crf3cQ29Fragment(), null).addToBackStack(null).commit();

                }
            }
        });

        btn_checkReading = (Button) view.findViewById(R.id.btn_checkReading);

        btn_checkReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(turn==1){

                    checkReadingEditText(et_r1_abdominal1, et_r2_abdominal1,tv_reading_difference1);

                }
                else if(turn==2){

                    checkReadingEditText(et_r1_abdominal2, et_r2_abdominal2,tv_reading_difference2);
                }
                else if(turn==3){

                    checkReadingEditText(et_r1_abdominal3, et_r2_abdominal3,tv_reading_difference3);
                }
                else if(turn==4){

                    checkReadingEditText(et_r1_abdominal4, et_r2_abdominal4,tv_reading_difference4);
                }
                
            }
        });


        return view;
    }

    public boolean textVaildation(EditText et1, EditText et2){

        boolean b = true;


        String tem1 = et1.getText().toString();
        String tem2 = et2.getText().toString();



        if(TextUtils.isEmpty(tem1)){
            et1.setError("Required");
            b= false;
        }
        if(!tem1.contains(".")){
            et1.setError("Enter Decimal Value");
            b= false;

        }


        if(TextUtils.isEmpty(tem2)){

            et2.setError("Required");

            b = false;
        }

        if(!tem2.contains(".")){

            et2.setError("Enter Decimal Value");
            b= false;

        }


        return b;
    }

    public float convertIntoFloat(String value){

        float val = Float.parseFloat(value);

        return val;
    }

    public void checkReadingEditText(EditText et_1, EditText et_2, TextView tv){


        if(textVaildation(et_1, et_2)) {

            float f1 = convertIntoFloat(et_1.getText().toString());
            float f2 = convertIntoFloat(et_2.getText().toString());

            float diff = f1 - f2;

            double difference =  Math.round(diff * 10000.0)/10000.0;

            if ((difference <= 0 && difference >= -0.5) || (difference >= 0 && difference <= 0.5)) {


                //  DecimalFormat decimalFormat = new DecimalFormat(10.0);
                ;

                tv.setText( difference+ "");
                tv.setTextColor(Color.GREEN);

                et_1.setEnabled(false);
                et_2.setEnabled(false);

                btn_checkReading.setClickable(false);
                btn_checkReading.setBackgroundResource(R.drawable.button_shape_green);

                float temp1 = (f1 + f2) / 2;
                avrageVal = Double.parseDouble( new DecimalFormat("##.#").format(temp1));
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


                }


            }

        }

    }




    public boolean checkFieldValidation(  ){
        boolean b = true;
        String tem1 =  et_readerId_1.getText().toString();
        String tem2 = et_readerId_2.getText().toString();

        if(TextUtils.isEmpty(tem1)){
            et_readerId_1.setError("Must Required");
            b = false;
        }else if (tem1.length()<3){

            et_readerId_1.setError("Enter Min Three Digit code");
            b = false;
        }

        if(TextUtils.isEmpty(tem2)){
            et_readerId_2.setError("Must Required");
            b = false;
        }else if (tem2.length()<3){

            et_readerId_2.setError("Enter Min Three Digit code");
            b = false;
        }
        if(avrageVal==-1){

            b = false;
        }
        String tem3 = et_r2_abdominal1.getText().toString();
        String tem4 = et_r1_abdominal1.getText().toString();

        if(TextUtils.isEmpty(tem3)){
            et_r2_abdominal1.setError("Must Required");
            b = false;
        }
        if(TextUtils.isEmpty(tem4)){
            et_r2_abdominal1.setError("Must Required");
            b = false;
        }


        return b;
    }

    /*public void dataInsertInForm(){

        List<WeightLwCrf3cDTO> weightLwCrf3cDTOS = new ArrayList<WeightLwCrf3cDTO>();

        if(turn>=1){ weightLwCrf3cDTOS.add(getWeightLwObject(1,et_r1_abdominal1,et_r2_abdominal1)); }
        if(turn>=2){ weightLwCrf3cDTOS.add(getWeightLwObject(2,et_r1_abdominal2,et_r2_abdominal2)); }
        if(turn>=3){ weightLwCrf3cDTOS.add(getWeightLwObject(3,et_r1_abdominal3,et_r2_abdominal3)); }
        if(turn>=4){ weightLwCrf3cDTOS.add(getWeightLwObject(4,et_r1_abdominal4,et_r2_abdominal4)); }

        CRF3cActivity.formsCrf2AndCrf3All.getFormCrf3cDTO().setWeightLwCrf3c(weightLwCrf3cDTOS);

        CRF3cActivity.formsCrf2AndCrf3All.getFormCrf3cDTO().setQ23(avrageVal+"");
    }*/


    public float getTextFromField(EditText et){

        return  Float.parseFloat(et.getText().toString());
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
