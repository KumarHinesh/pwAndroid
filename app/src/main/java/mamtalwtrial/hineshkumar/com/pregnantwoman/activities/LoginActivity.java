package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.constants.ContantsValues;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.LoginDTO;
import mamtalwtrial.hineshkumar.com.pregnantwoman.dtos.UserContract;
import mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit.APIService;
import mamtalwtrial.hineshkumar.com.pregnantwoman.retrofit.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    LoginDTO loginDTO;
    UserContract teamDTO;

    ProgressDialog progressDialog;

    EditText et_user_id, et_pass;
    Button btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initilalizeViews();

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, CRF1Activity.class));

                if (validation()) {

                    teamDTO.setDate(new SimpleDateFormat(ContantsValues.DATEFORMAT).format(Calendar.getInstance().getTime()));
                    teamDTO.setTime(new SimpleDateFormat(ContantsValues.TIMEFORMAT).format(Calendar.getInstance().getTime()));

                    progressDialog.show();
                    //sendRequestForLogin(teamDTO);


                } else {


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

        et_user_id = (EditText) findViewById(R.id.et_user_id);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn_signin = (Button) findViewById(R.id.btnsignin);
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