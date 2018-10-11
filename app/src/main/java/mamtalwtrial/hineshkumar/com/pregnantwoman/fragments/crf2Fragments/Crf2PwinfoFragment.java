package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF2Activity;


public class Crf2PwinfoFragment extends Fragment {

    View view;
    Button btn_next_pw_info;
    RadioGroup rg_q17;
    RadioButton rb_q17;
    TextView tv_q17;
    RelativeLayout rl_q17;
    EditText et_q17_reason;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_crf2_pwinfo, container, false);
        initalizeViews(view, getContext());


        rg_q17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_q17 = (RadioButton) view.findViewById(rg_q17.getCheckedRadioButtonId());
                if (rb_q17.getTag().toString().equals("3")){
                    rl_q17.setVisibility(View.VISIBLE);
                }else {
                    rl_q17.setVisibility(View.GONE);
                }
            }
        });

        btn_next_pw_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation(view)){

//                    int visitNo = Integer.parseInt(CRF2Activity.formCrf2DTO.getQ17());

                    switch(1){

                        case 1:

                            CRF2Activity.fragmentManager.beginTransaction().replace(R.id.crf2_frame, new Crf2PwMuacAssessmentFragment(), null).addToBackStack(null).commit();
                                    //      .replace(R.id.crf2_frame, fragment, ).addToBackStack(null).commit();
                                 //   .replace(R.id.crf2_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
                            break;

                        case 2:

                            break;

                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:

                            break;

                        case 6:

                            break;

                        case 7:

                            break;

                    }

                }

            }
        });



        return view;
    }


    public void initalizeViews(View view, Context context){

        //initialiling EDIT TEXT
        et_q17_reason = (EditText) view.findViewById(R.id.et_q17_reason);

        //initialiling RELATIVE LAYOUT
        rl_q17 = (RelativeLayout) view.findViewById(R.id.rl_q17);

        //initialiling BUTTON
        btn_next_pw_info = (Button) view.findViewById(R.id.btn_next_pw_info);

       //initialiling  RADIO GROUPS
        rg_q17 = (RadioGroup) view.findViewById(R.id.rg_q17);

       //initialiling TEXT VIEW
        tv_q17 = (TextView) view.findViewById(R.id.tv_q17);

       //initialiling PROGRASS DIALOG
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Wait");
    }

    // function for validation and inert Values in DTO
    public boolean validation(View view){
        boolean validation = true;

        String tem = null;
        String[] data = null;

        data = checkRgAndGetFieldData(view, rg_q17, tv_q17, et_q17_reason, "1", null, null, null);

       /* if (data != null){

            if (!data[1].equalsIgnoreCase("")){
                validation = false;
            }else {
                //CRF2Activity.formCrf2DTO
            }

        }else {
            validation = false;
        }*/


       /* tem = checkRadioGroupViews(view, rg_q17, tv_q17);
        if ( tem != null)
            CRF2Activity.formCrf2DTO.setQ17(tem);      //System.out.println("Data Filed");
        else
            validation = false;
*/

        return validation;
    }

    // check radiogroup fields if check any child function return tag value otherWise return null
    public String checkRadioGroupViews(View view, RadioGroup radioGroup, TextView textView){
        RadioButton radioButton;
        if (radioGroup.getCheckedRadioButtonId() != -1){
            radioButton = (RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId());
            return radioButton.getTag().toString();
        }else {
            return null;
        }
    }

    // check RadioGroup value if text muxt given then get text otherwise set Error on edittexxt and return null
    public String[] checkRgAndGetFieldData(View view, RadioGroup radioGroup, TextView textView, EditText editText, String val1, String val2, String val3, Object o){
        String data[] = new String[2];
        RadioButton radioButton;
        if (radioGroup.getCheckedRadioButtonId() != -1){
            radioButton = (RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId());
            String tempVal = radioButton.getTag().toString();
            data[0] = tempVal;
            if (tempVal.equals(val1) || tempVal.equals(val2) || tempVal.equals(val3)){
                String tVal = editText.getText().toString();
                if (tVal.isEmpty() || tVal == null || tVal.equals("")){
                    editText.setError("Required");
                    data[1] = "";
                }else{
                    data[1] = tVal;
                }
            }
            return data;
        }else {
            return null;
        }


    }


}
