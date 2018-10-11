package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;


import java.text.SimpleDateFormat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.constants.ContantsValues;

import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.FormCrf1DTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.TeamDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.UltrasoundExaminationDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf1Fragments.PwInformation;

public class CRF1Activity extends AppCompatActivity {

    public static int babyNo = -1;
    public static FormCrf1DTO formCrf1DTO;
    public static FragmentManager fragmentManager;
    TeamDTO teamDTO;
    public static List<UltrasoundExaminationDTO> ultrasoundExaminationDTOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crf1);

        teamDTO = new Gson().fromJson(getIntent().getStringExtra("team"), TeamDTO.class);

        ultrasoundExaminationDTOList = new ArrayList<>();
        fragmentManager  = getSupportFragmentManager();
        Fragment fragment = new PwInformation();
        formCrf1DTO = new FormCrf1DTO();

        formCrf1DTO.setTeamDTO(teamDTO);

        formCrf1DTO.setQ02(new SimpleDateFormat(ContantsValues.DATEFORMAT).format(Calendar.getInstance().getTime())+"");
        formCrf1DTO.setQ03(new SimpleDateFormat(ContantsValues.TIMEFORMAT).format(Calendar.getInstance().getTime())+"");

        if (findViewById(R.id.crf1_frame) != null)
        {

            if (savedInstanceState != null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.crf1_frame, fragment, null).addToBackStack(null);
            fragmentTransaction.commit();
        }


    //   Fragment fragment = new Crf1Q20();
       /* getSupportFragmentManager().beginTransaction()
                .replace(R.id.crf1_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
*/
    }


}
