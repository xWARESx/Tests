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

public class VictimTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;

    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.victim_res;
    static boolean checked;
    String res1;
    String res2;
    String res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.victimQ);
        answers1 = getResources().getStringArray(R.array.victimAns);

        res1 = getString(R.string.victimRes1);
        res2 = getString(R.string.victimRes2);
        res3 = getString(R.string.victimRes3);

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
                    case 2:
                        checkAnswer3();
                        mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                        updateQuestion();
                        updateAnswers();
                }
            }
        });
        updateQuestion();
        updateAnswers();
    }

    private void checkAnswer3() {
        sum+=1;
        if(q==10){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=7) intent1.putExtra("text", res1);
            if(sum>7&&sum<=13) intent1.putExtra("text", res2);
            if(sum>13&&sum<=20) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }

        q++;
    }

    private void checkAnswer1(){
        sum+=2;
        if(q==10){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=7) intent1.putExtra("text", res1);
            if(sum>7&&sum<=13) intent1.putExtra("text", res2);
            if(sum>13&&sum<=20) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }

        q++;
    }
    private void checkAnswer2() {
        if(q==10){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=7) intent1.putExtra("text", res1);
            if(sum>7&&sum<=13) intent1.putExtra("text", res2);
            if(sum>13&&sum<=20) intent1.putExtra("text", res3);
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
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers1);
            answers.setAdapter(adapter1);
        }
    }
}
