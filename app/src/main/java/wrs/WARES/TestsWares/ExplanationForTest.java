package wrs.WARES.TestsWares;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.WARES.tests.R;

public class ExplanationForTest extends AppCompatActivity {
    ListView listView;
    String[] listText1;
    String[] listText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation_for_test);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int test = (int) getIntent().getSerializableExtra("test");
        switch (test){
            case 1:
                listText1 = getResources().getStringArray(R.array.kosmosQ);
                listText2 = getResources().getStringArray(R.array.rightKosmos);
                break;
            case 2:
                listText1 = getResources().getStringArray(R.array.classicQ);
                listText2 = getResources().getStringArray(R.array.classicRight);
                break;
            case 3:
                listText1 = getResources().getStringArray(R.array.wildQ);
                listText2 = getResources().getStringArray(R.array.wildRight);
                break;
            case 4:
                listText1 = getResources().getStringArray(R.array.mathQ);
                listText2 = getResources().getStringArray(R.array.mathRight);
                break;
            case 5:
                listText1 = getResources().getStringArray(R.array.physicsQ);
                        listText2 = getResources().getStringArray(R.array.physicsRight);
                break;
            case 6:
                listText1 = getResources().getStringArray(R.array.evQ);
                        listText2 = getResources().getStringArray(R.array.evRight);
                break;
            case 7:
                listText1 = getResources().getStringArray(R.array.orgQ);
                        listText2 = getResources().getStringArray(R.array.orgRight);
                break;
            case 8:
                listText1 = getResources().getStringArray(R.array.mithQ);
                        listText2 = getResources().getStringArray(R.array.mithRight);
                break;
            case 9:
                listText1 = getResources().getStringArray(R.array.mith2Q);
                        listText2 = getResources().getStringArray(R.array.mith2Right);
                break;
            case 10:
                listText1 = getResources().getStringArray(R.array.GodsQ);
                        listText2 = getResources().getStringArray(R.array.GodsRight);
                break;
            case 11:
                listText1 = getResources().getStringArray(R.array.englishQ);
                        listText2 = EnglishTest.rightAns;
                break;
            case 12:
                listText1 = getResources().getStringArray(R.array.openQ);
                        listText2 = getResources().getStringArray(R.array.openRight);
                break;
            case 13:
                listText1 = getResources().getStringArray(R.array.catsQ);
                        listText2 = getResources().getStringArray(R.array.catsRight);
                break;
            case 14:
                listText1 = getResources().getStringArray(R.array.kidsQ);
                        listText2 = getResources().getStringArray(R.array.kidsRight);
                break;
            case 15:
                listText1 = getResources().getStringArray(R.array.romQ);
                listText2 = getResources().getStringArray(R.array.romRight);
                break;
            case 16:
                listText1 = getResources().getStringArray(R.array.standupQ);
                listText2 = getResources().getStringArray(R.array.standupRight);
                break;
            case 17:
                listText1 = getResources().getStringArray(R.array.actorQ);
                listText2 = getResources().getStringArray(R.array.actorRight);
                break;
            case 18:
                listText1 = getResources().getStringArray(R.array.erudQ);
                listText2 = getResources().getStringArray(R.array.erudRight);
                break;
            case 19:
                listText1 = getResources().getStringArray(R.array.wordsQ);
                listText2 = getResources().getStringArray(R.array.wordsRight);
                break;
            case 20:
                listText1 = getResources().getStringArray(R.array.animalsQ);
                listText2 = getResources().getStringArray(R.array.animalsRight);
                break;
            case 21:
                listText1 = getResources().getStringArray(R.array.animals2Q);
                listText2 = getResources().getStringArray(R.array.animals2Right);
                break;
            case 22:
                listText1 = getResources().getStringArray(R.array.famousQ);
                listText2 = getResources().getStringArray(R.array.famousRight);
                break;
            case 23:
                listText1 = getResources().getStringArray(R.array.quotesQ);
                listText2 = getResources().getStringArray(R.array.quotesRight);
                break;
            case 24:
                listText1 = getResources().getStringArray(R.array.thelawsQ);
                listText2 = getResources().getStringArray(R.array.thelawsRight);
                break;
            case 25:
                listText1 = getResources().getStringArray(R.array.bigQ);
                listText2 = getResources().getStringArray(R.array.bigRight);
                break;
        }



        listView = (ListView) findViewById(R.id.list);
        ExplanationForTest.Adapter adapter = new ExplanationForTest.Adapter(this, listText1, listText2);
        listView.setAdapter(adapter);
    }
    class Adapter extends ArrayAdapter<String> {
        Context context;
        String[] listText1;
        String[] listText2;
        Adapter (Context c, String[] listText1, String[] listText2){
            super(c, R.layout.row2, R.id.att_text1, listText1);
            this.context = c;
            this.listText1 = listText1;
            this.listText2 = listText2;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row3, parent, false);
            TextView text = row.findViewById(R.id.text1);
            text.setText(listText1[position]);
            TextView text2 = row.findViewById(R.id.text2);
            text2.setText(listText2[position]);

            return row;
        }
    }
}
