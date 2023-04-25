package wrs.WARES.TestsWares;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class UnderSky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_sky);
    }
    public void openTest(View view) {
        Intent intent = new Intent(this, UnderSkyTest.class);
        startActivity(intent);
    }

    public void openList(View view) {
        Intent intent = new Intent(this, Psycho.class);
        startActivity(intent);
    }
}
