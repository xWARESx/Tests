package wrs.WARES.TestsWares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class RickOrMorty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rick_or_morty);
    }

    public void openList(View view) {
        Intent intent = new Intent(this, Pciho.class);
        startActivity(intent);
    }
    public void openTest(View view){
        Intent intent = new Intent(this, RoMTest.class);
        startActivity(intent);
    }
}
