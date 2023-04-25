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

public class TastyTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;


    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.tasty_res;
    static boolean checked;
    String res1;
    String res2;
    String res3;
    String res4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.tastyQ);
        answers1 = getResources().getStringArray(R.array.tastyAns);

        res1 = getString(R.string.tastyRes1);
        res2 = getString(R.string.tastyRes2);
        res3 = getString(R.string.tastyRes3);
        res4 = getString(R.string.tastyRes4);

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
                    case 3:
                        checkAnswer4();
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
        Intent intent1 = new Intent(this, Results1.class);
        intent1.putExtra("text", res1);
        intent1.putExtra("image", res);
        startActivity(intent1);
    }
    private void checkAnswer2() {
        Intent intent1 = new Intent(this, Results1.class);
        intent1.putExtra("text", res2);
        intent1.putExtra("image", res);
        startActivity(intent1);
    }
    private void checkAnswer3() {
        Intent intent1 = new Intent(this, Results1.class);
        intent1.putExtra("text", res3);
        intent1.putExtra("image", res);
        startActivity(intent1);
    }
    private void checkAnswer4() {
        Intent intent1 = new Intent(this, Results1.class);
        intent1.putExtra("text", res4);
        intent1.putExtra("image", res);
        startActivity(intent1);
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
