package wrs.WARES.TestsWares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class Hobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
    }
    public void openTest(View view) {
        Intent intent = new Intent(this, HobbyTest.class);
        startActivity(intent);
    }

    public void openList(View view) {
        Intent intent = new Intent(this, Pciho.class);
        startActivity(intent);
    }
}
