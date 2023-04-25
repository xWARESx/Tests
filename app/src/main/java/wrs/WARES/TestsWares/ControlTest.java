package wrs.WARES.TestsWares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class ControlTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;

    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.control_res;
    static boolean checked;
    String res1;
    String res2;
    String res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.controlQ);
        answers1 = getResources().getStringArray(R.array.controlAns);

        res1 = getString(R.string.controlRes1);
        res2 = getString(R.string.controlRes2);
        res3 = getString(R.string.controlRes3);

        answers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: checkAnswer1();
                        mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                        updateQuestion();
                        updateAnswers();
                        break;
                    case 1: checkAnswer2();
                        mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                        updateQuestion();
                        updateAnswers();
                        break;
                }
            }
        });
        updateQuestion();
        updateAnswers();
    }


    private void checkAnswer1(){
        switch (q){
            case 2:
            case 3:
            case 4:
            case 6:
            case 8:
            case 9:
            case 10:
                sum++;
                break;
        }
        if(q==10){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=3) intent1.putExtra("text", res1);
            if(sum>3&&sum<=6) intent1.putExtra("text", res2);
            if(sum>6&&sum<=10) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }

        q++;
    }
    private void checkAnswer2() {
        switch (q){
            case 1:
            case 5:
            case 7:
                sum++;
                break;
        }
        if(q==10){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=3) intent1.putExtra("text", res1);
            if(sum>3&&sum<=6) intent1.putExtra("text", res2);
            if(sum>6&&sum<=10) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }

        q++;
    }



    private void updateQuestion(){
        String quest = questions[mCurrentIndex];
        question.setText(quest);



    }
    private void updateAnswers(){
        if (mCurrentIndex == 0) {
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.actor_lay, answers1);
            answers.setAdapter(adapter1);
        }
    }
}
