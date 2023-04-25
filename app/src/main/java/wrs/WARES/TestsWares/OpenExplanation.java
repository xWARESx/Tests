package wrs.WARES.TestsWares;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.WARES.tests.R;

public class OpenExplanation extends AppCompatActivity {

    boolean unblock = Donate.unblock;
    boolean unblock1;
    boolean unblock2;


    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_explanation);

        sPref = getPreferences(MODE_PRIVATE);
        //sPref.edit().clear().apply();
        unblock1 = sPref.getBoolean("unblock", false);
        if(unblock1) unblock2 = true;
    }

    public void openExplanation(View view) {
        if(unblock2){
            Intent intent = new Intent(this, ExplanationActivity.class);
            startActivity(intent);}
        else {
            AlertDialog.Builder b1 = new AlertDialog.Builder(this);
            b1.setTitle(getString(R.string.info_unblock)).setCancelable(false).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog al1 = b1.create();
            al1.show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if (unblock) {
            ed.putBoolean("unblock", true);
            ed.apply();
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);}
    }

