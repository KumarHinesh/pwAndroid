package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.constants.ContantsValues;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.UserContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FormCrf1DTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.UltrasoundExaminationDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments.PwInformation;

public class CRF1Activity extends AppCompatActivity {


    public static String FORM_UID = "";
    public static long FORM_ID = -1;
    public static int babyNo = 1;
    public static FormCrf1DTO formCrf1DTO;
    public static FragmentManager fragmentManager;
    UserContract teamDTO;
    public static List<UltrasoundExaminationDTO> ultrasoundExaminationDTOList;
    public static String DEVICE_ID = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crf1);

        teamDTO = new Gson().fromJson(getIntent().getStringExtra("team"), UserContract.class);
        DEVICE_ID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        ultrasoundExaminationDTOList = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = new PwInformation();
        formCrf1DTO = new FormCrf1DTO();

        formCrf1DTO.setTeamDTO(teamDTO);

        formCrf1DTO.setQ02(new SimpleDateFormat(ContantsValues.DATEFORMAT).format(Calendar.getInstance().getTime()) + "");
        formCrf1DTO.setQ03(new SimpleDateFormat(ContantsValues.TIMEFORMAT).format(Calendar.getInstance().getTime()) + "");

        if (findViewById(R.id.crf1_frame) != null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.crf1_frame, fragment, null).addToBackStack(null);
            fragmentTransaction.commit();
        }

    }


    /*private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updateSB1();
        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
*/

}
