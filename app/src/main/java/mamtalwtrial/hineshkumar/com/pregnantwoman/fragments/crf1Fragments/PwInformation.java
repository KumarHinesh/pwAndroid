package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.net.URL;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF1Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.PregnantWomanDTO;


public class PwInformation extends Fragment {

    EditText et_pw_name, et_husband_name, et_site, et_para, et_block, et_structure, et_household, et_woman_no, et_q17_reason;
    Button btn_next_pw_info;

    RadioButton rb_q17;

    RadioGroup rg17;

    URL url;

    PregnantWomanDTO pregnantWomanDTO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_pw_information, container, false);
       initializeViews(view);



        rg17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q17 = view.findViewById(rg17.getCheckedRadioButtonId());

            }
        });




        btn_next_pw_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (validation()){

                    switch(1){

                        case 1:
                            CRF1Activity.fragmentManager.beginTransaction().replace(R.id.crf1_frame, new CrfQ18(), null).addToBackStack(null).commit();
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



                }else {

                    AlertDialog alertDialog = new AlertDialog.Builder(
                            getContext()).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Erorr");

                    // Setting Dialog Message
                    alertDialog.setMessage("Erorr please fill complete Information");

                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            Toast.makeText(getContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        }
                    });


                    alertDialog.show();

                }


                    //...... Some other stuff then parse the JSON feed into a POJO


            }
        });

        return view;
    }


    public boolean validation(){
        boolean validation = true;

        if (!checkEditTextField(et_pw_name).equals(""))
            return false;
        else
            et_pw_name.setError(null);

        if (!checkEditTextField(et_husband_name).equals(""))
            return false;
        else
            et_husband_name.setError(null);

        if (!checkEditTextField(et_site).equals(""))
            return false;
        else
            et_site.setError(null);

        if (!checkEditTextField(et_para).equals(""))
            return false;
        else
            et_para.setError(null);

        if (!checkEditTextField(et_block).equals(""))
            return false;
        else
            et_block.setError(null);

        if (!checkEditTextField(et_structure).equals(""))
            return false;
        else
            et_structure.setError(null);

        if (!checkEditTextField(et_household).equals(""))
            return false;
        else
            et_household.setError(null);

        if (!checkEditTextField(et_woman_no).equals(""))
            return false;
        else
            et_woman_no.setError(null);

        /*if (validation)
            CRF1Activity.formCrf1DTO.setPregnantWomanDTO(pregnantWomanDTO);
*/
        return rg17.getCheckedRadioButtonId() != -1;
    }

    public String checkEditTextField(EditText editText){
        String data = "";
        if (!editText.getText().toString().equalsIgnoreCase(""))
            data = editText.getText().toString();
        else
            editText.setError("Please Enter");
        return data;
    }


    public void initializeViews(View view){

        btn_next_pw_info = view.findViewById(R.id.btn_next_pw_info);

        //initialiling EDIT TEXT
        et_pw_name = view.findViewById(R.id.et_pw_name);
        et_husband_name = view.findViewById(R.id.et_husband_name);
        et_site = view.findViewById(R.id.et_site);
        et_para = view.findViewById(R.id.et_para);
        et_block = view.findViewById(R.id.et_block);
        et_structure = view.findViewById(R.id.et_structure);
        et_household = view.findViewById(R.id.et_household);
        et_woman_no = view.findViewById(R.id.et_woman_no);
        et_q17_reason = view.findViewById(R.id.et_q17_reason);

        //initialiling  RADIO GROUPS
        rg17 = view.findViewById(R.id.rg_q17);


        pregnantWomanDTO = new PregnantWomanDTO();
    }


    public void sendDataToServer(){

    }

    /*public void showParaList(Context context, String engMessage, String romanEng){

        Button btnConform;
        TextView tv_engText, tv_RomanEngText;

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.show_para_list);
        dialog.setCancelable(false);

        btnConform = (Button) dialog.findViewById(R.id.btnok);

        tv_engText = (TextView) dialog.findViewById(R.id.tv_engText);
        tv_RomanEngText = (TextView) dialog.findViewById(R.id.tv_RomanEngText);

        tv_engText.setText(engMessage);
        tv_RomanEngText.setText(romanEng);

        btnConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();
    }*/




}
