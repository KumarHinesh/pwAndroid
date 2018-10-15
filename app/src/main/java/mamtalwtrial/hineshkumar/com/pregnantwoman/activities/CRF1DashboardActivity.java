package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.Sync.SyncAllData;
import mamtalwtrial.hineshkumar.com.pregnantwoman.constants.ContantsValues;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.FoetusesContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.FormsContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.core.AndroidDatabaseManager;
import mamtalwtrial.hineshkumar.com.pregnantwoman.core.DatabaseHelper;

public class CRF1DashboardActivity extends AppCompatActivity {

    Button btnSyncData, btnNewScreening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crf1_dashboard);
        initializingView();

        btnSyncData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(CRF1DashboardActivity.this);
                new SyncAllData(
                        CRF1DashboardActivity.this,
                        "CRF1",
                        "updateSyncedForms",
                        FormsContract.class,
                        ContantsValues.HOST_URL + FormsContract.FormsTable._URL,
                        db.getUnsyncedCrf1()
                ).execute();


                new SyncAllData(
                        CRF1DashboardActivity.this,
                        "FETUSES",
                        "updateSyncedFoetuses",
                        FoetusesContract.class,
                        ContantsValues.HOST_URL + FoetusesContract.FormsTable._URL,
                        db.getUnsyncedFoetuses()
                ).execute();

            }
        });


        btnNewScreening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CRF1DashboardActivity.this, AndroidDatabaseManager.class));
                finish();
            }
        });

    }

    public void initializingView() {

        btnSyncData = findViewById(R.id.btnSyncData);
        btnNewScreening = findViewById(R.id.btnNewScreening);

    }

}
