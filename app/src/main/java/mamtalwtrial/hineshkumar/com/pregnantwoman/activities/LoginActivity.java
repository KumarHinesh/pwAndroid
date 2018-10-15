package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.Sync.GetAllData;
import mamtalwtrial.hineshkumar.com.pregnantwoman.contractClasses.UserContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.LoginDTO;

public class LoginActivity extends AppCompatActivity {


    LoginDTO loginDTO;
    UserContract teamDTO;

    TextView tv_headingText;

    ProgressDialog progressDialog;

    EditText et_user_id, et_pass;
    Button btn_signin, btn_syncData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initilalizeViews();

        tv_headingText.setText("Login Activity");

        btn_syncData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new GetAllData(LoginActivity.this, "User").execute();

            }
        });


        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {

                    startActivity(new Intent(LoginActivity.this, CRF1DashboardActivity.class));
                    finish();

                    progressDialog.show();

                } else {
                    Toast.makeText(LoginActivity.this, "Please Enter All fields", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public boolean validation() {
        boolean validation = true;

        if (et_pass.getText().equals("")) {
            validation = false;
            et_pass.setError("Please entEr");
        } else {
            teamDTO.setPassword(et_pass.getText().toString());
        }

        if (et_user_id.getText().equals("")) {
            validation = false;
            et_user_id.setError("Please entEr");

        } else {
            teamDTO.setUserName(et_user_id.getText().toString());

        }


        return validation;
    }

    public void initilalizeViews() {
        teamDTO = new UserContract();

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Wait");
        progressDialog.setMessage("Loging In..");

        tv_headingText = findViewById(R.id.tv_headingText);

        et_user_id = findViewById(R.id.et_user_id);
        et_pass = findViewById(R.id.et_pass);
        btn_signin = findViewById(R.id.btnsignin);


        btn_syncData = findViewById(R.id.btn_syncData);
    }

    /*public void sendRequestForLogin(final UserContract teamDTO) {
        APIService mAPIService = ApiUtils.getAPIService();

        mAPIService.userLogin(teamDTO).enqueue(new Callback<LoginDTO>() {
            @Override
            public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {

                if (response.code() == 200) {

                    loginDTO = response.body();

                    if (loginDTO != null && loginDTO.getTeamDTO() != null) {

                        switch (loginDTO.getTeamDTO().getTeamTitle().getTitle()) {

                            case ContantsValues.TEAM_1:
                                progressDialog.dismiss();
                                startActivity(new Intent(LoginActivity.this, CRF1Activity.class).putExtra("team", new Gson().toJson(loginDTO.getTeamDTO())));
                                finish();
                                break;
                        }

                    } else {

                        Toast.makeText(LoginActivity.this, "Login faild DTO Return null", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                    }


                } else {

                    Toast.makeText(LoginActivity.this, "Login faild reponse code not 200", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<LoginDTO> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login faild exception occurs", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });


    }*/


}

//TODO:Check sync arguments
/*
new SyncAllData(
                    this,
                    "Forms",
                    "updateSyncedForms",
                    FormsContract.class,
                    MainApp._HOST_URL + FormsContract.FormsTable._URL,
                    db.getUnsyncedForms()
            ).execute();

            FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " = '' "
*/