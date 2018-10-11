package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF1Activity;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments.PwInformation;


public class crfQ31 extends Fragment {


    EditText q31_et, q32_et, q36_et, q37_et;

    Button submitcrf1;

    RadioGroup rg_q33, rg_q34;

    RadioButton rb_q33, rb_q34;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_crf_q31, container, false);

        q31_et = (EditText) view.findViewById(R.id.et_q31);
        q32_et = (EditText) view.findViewById(R.id.et_q32);
        q36_et = (EditText) view.findViewById(R.id.et_q36);
        q37_et = (EditText) view.findViewById(R.id.et_q37);
        submitcrf1 = (Button) view.findViewById(R.id.submitcrf1);


        rg_q33.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q33 = (RadioButton) view.findViewById(rg_q33.getCheckedRadioButtonId());


            }
        });

        rg_q34.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rb_q34 = (RadioButton) view.findViewById(rg_q34.getCheckedRadioButtonId());


            }
        });


        submitcrf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {

                    validation();

                    // sendDataToServer(CRF1Activity.formCrf1DTO);


                    AlertDialog alertDialog = new AlertDialog.Builder(
                            getContext()).create();

                    // Setting Dialog Title
                    alertDialog.setTitle("Submitted");

                    // Setting Dialog Message
                    alertDialog.setMessage("Data Submitted!!!!");


                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                            PwInformation fragment = new PwInformation();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.crf1_frame, fragment);
                            fragmentTransaction.commit();
                        }
                    });


                    alertDialog.show();


                } else {


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
            }
        });


        return view;


    }


    ///
    public String checkEditTextField(EditText editText) {
        String data = "";
        if (!editText.getText().toString().equalsIgnoreCase(""))
            data = editText.getText().toString();
        else
            editText.setError("Please Enter");
        return data;
    }


    ///
    public boolean validation() {

        boolean validation = true;


        /*if (!checkEditTextField(q31_et).equals(""))
            CRF1Activity.formCrf1DTO.setQ31(checkEditTextField(q31_et));
        else
            validation = false;
        if (!checkEditTextField(q32_et).equals(""))
            CRF1Activity.formCrf1DTO.setQ32(checkEditTextField(q32_et));
        else
            validation = false;
        if (!checkEditTextField(q36_et).equals(""))
            CRF1Activity.formCrf1DTO.setQ36(checkEditTextField(q36_et));
        else
            validation = false;
        if (!checkEditTextField(q37_et).equals(""))
            CRF1Activity.formCrf1DTO.setQ37(checkEditTextField(q37_et));
        else
            validation = false;
*/

        if (rg_q33.getCheckedRadioButtonId() == -1) {
            validation = false;
        } else {

            //CRF1Activity.formCrf1DTO.setQ33(rb_q33.getText().toString());

        }

        if (rg_q34.getCheckedRadioButtonId() == -1) {
            validation = false;
        } else {

            //   CRF1Activity.formCrf1DTO.setQ34(rb_q34.getText().toString());

        }


        //  CRF1Activity.formCrf1DTO.setQ35("dummy35");


        return validation;
    }

    //
   /* public void sendDataToServer(FormCrf1 formCrf1DTO) {

        APIService mAPIService = ApiUtils.getAPIService();

        FormCrf1Collection formCrf1Collection = new FormCrf1Collection();

        ArrayList<FormCrf1DTO> list = new ArrayList<>();
        list.add(CRF1Activity.formCrf1DTO);
        formCrf1Collection.setList(list);



        *//*mAPIService.test("Test").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()){

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
*//*


    }
*/

}
