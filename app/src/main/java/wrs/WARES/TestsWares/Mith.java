package wrs.WARES.TestsWares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class Mith extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mith);
    }
    public void openTest(View view) {
        Intent intent = new Intent(this, MithTest.class);
        startActivity(intent);
    }

    public void openList(View view) {
        Intent intent = new Intent(this, Brain.class);
        startActivity(intent);
    }
}
