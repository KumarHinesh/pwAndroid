package mamtalwtrial.hineshkumar.com.pregnantwoman.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mamtalwtrial.hineshkumar.com.pregnantwoman.R;
import mamtalwtrial.hineshkumar.com.pregnantwoman.fragments.crf2Fragments.Crf2PwinfoFragment;

public class CRF2Activity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crf2);

        fragmentManager  = getSupportFragmentManager();


        Fragment fragment = new Crf2PwinfoFragment();

        if (findViewById(R.id.crf2_frame) != null)
        {

            if (savedInstanceState != null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.crf2_frame, fragment, null).addToBackStack(null);
            fragmentTransaction.commit();
        }



   /*     getSupportFragmentManager().beginTransaction()

          //      .replace(R.id.crf2_frame, fragment, ).addToBackStack(null).commit();
          .replace(R.id.crf2_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
*/

    }
}
