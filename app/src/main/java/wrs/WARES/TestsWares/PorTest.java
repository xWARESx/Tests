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

public class PorTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.por_res;
    static boolean checked;
    String res1;
    String res2;
    String res3;
    String res4;
    String res5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.porQ);
        answers1 = getResources().getStringArray(R.array.porAns);

        res1 = getString(R.string.porRes1);
        res2 = getString(R.string.porRes2);
        res3 = getString(R.string.porRes3);
        res4 = getString(R.string.porRes4);
        res5 = getString(R.string.porRes5);

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
                        break;
                }
            }
        });
        updateQuestion();
        updateAnswers();
    }

    private void checkAnswer3() {
        q++;
    }

    private void checkAnswer1(){
        switch (q){
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                sum++;
                break;

        }
        if(q==20){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=5) intent1.putExtra("text", res1);
            if(sum>5&&sum<=10) intent1.putExtra("text", res2);
            if(sum>10&&sum<=15) intent1.putExtra("text", res3);
            if(sum>15&&sum<=18) intent1.putExtra("text", res4);
            if(sum>18&&sum<=20) intent1.putExtra("text", res5);
            intent1.putExtra("image", res);
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
                sum++;
                break;
        }
        if (q == 20) {
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=5) intent1.putExtra("text", res1);
            if(sum>5&&sum<=10) intent1.putExtra("text", res2);
            if(sum>10&&sum<=15) intent1.putExtra("text", res3);
            if(sum>15&&sum<=18) intent1.putExtra("text", res4);
            if(sum>18&&sum<=20) intent1.putExtra("text", res5);
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
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.b_and_w_lay, answers1);
            answers.setAdapter(adapter1);
        }
    }

}
