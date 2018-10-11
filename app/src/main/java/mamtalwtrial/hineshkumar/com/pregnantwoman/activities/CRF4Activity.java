package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments.Crf2PwinfoFragment;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf4Fragments.Crf4PwinfoFragment;

public class CRF4Activity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crf4);

        fragmentManager = getSupportFragmentManager();

        Fragment fragment = new Crf4PwinfoFragment();

        if (findViewById(R.id.crf4_frame) != null) {
            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.crf4_frame, fragment, null).addToBackStack(null);
            fragmentTransaction.commit();
        }

    }
}
