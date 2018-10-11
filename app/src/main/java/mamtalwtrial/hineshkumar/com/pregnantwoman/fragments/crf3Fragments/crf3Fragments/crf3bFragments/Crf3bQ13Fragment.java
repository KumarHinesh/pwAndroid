package mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf3Fragments.crf3Fragments.crf3bFragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.activities.CRF2Activity;


public class Crf3bQ13Fragment extends Fragment {

    Button btn_next;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_crf3b_q13, container, false);
        initializingViews(view, getContext());

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CRF2Activity.fragmentManager.beginTransaction().replace(R.id.crf2_frame, new Crf3bQ19Fragment(), null).addToBackStack(null).commit();

            }
        });



        // Inflate the layout for this fragment
        return view;
    }


    public void initializingViews(View view, Context context){


        //initialiling EDIT TEXT


        //initialiling RELATIVE LAYOUT


        //initialiling BUTTON
        btn_next = (Button) view.findViewById(R.id.btn_next);

        //initialiling  RADIO GROUPS


        //initialiling TEXT VIEW


        //initialiling PROGRASS DIALOG
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Wait");

    }


}
