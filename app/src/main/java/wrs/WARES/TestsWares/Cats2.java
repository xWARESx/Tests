package wrs.WARES.TestsWares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class Cats2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats2);
    }
    public void openTest(View view) {
        Intent intent = new Intent(this, Cats2Test.class);
        startActivity(intent);
    }

    public void openList(View view) {
        Intent intent = new Intent(this, Psycho.class);
        startActivity(intent);
    }
}
