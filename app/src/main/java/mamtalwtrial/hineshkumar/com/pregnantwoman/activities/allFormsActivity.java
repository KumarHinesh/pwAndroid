package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;

public class allFormsActivity extends AppCompatActivity {

    Button btnhematology,btnurine,btnserology,btnbiochem,btnantenatal;
     LinearLayout linearLayout;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_forms);



        btnhematology = findViewById(R.id.btnhematology);
        btnurine = findViewById(R.id.btnurine);
        btnserology = findViewById(R.id.btnserology);
        btnbiochem = findViewById(R.id.btnbiochem);
        btnhematology = findViewById(R.id.btnhematology);
        btnantenatal = findViewById(R.id.btnanatology);


        btnhematology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(allFormsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.hemantologyform);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


            }
        });


        btnurine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(allFormsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.urineexaminationform);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            }
        });


        btnbiochem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(allFormsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.biochemistryform);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        btnserology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(allFormsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.serologyform);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });

        btnantenatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(allFormsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.antenatalform);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        });


        // for year selection done later
//        final int[] choosenYear = {2018};
//        MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(getContext(), new MonthPickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(int selectedMonth, int selectedYear) {
//                yeartv.setText(Integer.toString(selectedYear));
//                choosenYear[0] = selectedYear;
//            }
//        }, choosenYear[0], 0);
//
//        builder.showYearOnly()
//                .setYearRange(1990, 2050)
//                .build()
//                .show();






    }
}
