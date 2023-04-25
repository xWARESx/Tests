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

public class ConfidenceTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    private String[] answers2;
    private String[] answers3;
    private String[] answers4;
    private String[] answers5;
    private String[] answers6;
    private String[] answers7;
    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.conf_res;
    static boolean checked;
    int a=0, b=0, c=0;
    String res1;
    String res2;
    String res3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confidence_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.confQ);
        answers1 = getResources().getStringArray(R.array.confAns1);
        answers2 = getResources().getStringArray(R.array.confAns2);
        answers3 = getResources().getStringArray(R.array.confAns3);
        answers4 = getResources().getStringArray(R.array.confAns4);
        answers5 = getResources().getStringArray(R.array.confAns5);
        answers6 = getResources().getStringArray(R.array.confAns6);
        answers7 = getResources().getStringArray(R.array.confAns7);

        res1 = getString(R.string.confRes1);
        res2 = getString(R.string.confRes2);
        res3 = getString(R.string.confRes3);

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
        c++;
        if (q == 7) {
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c) intent1.putExtra("text", res1);
            if(b>a&&b>c) intent1.putExtra("text", res2);
            if(c>a&&c>b) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }
        q++;
    }

    private void checkAnswer1(){
        a++;
        if(q==7){
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c) intent1.putExtra("text", res1);
            if(b>a&&b>c) intent1.putExtra("text", res2);
            if(c>a&&c>b) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }

        q++;
    }
    private void checkAnswer2() {
      b++;
        if (q == 7) {
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c) intent1.putExtra("text", res1);
            if(b>a&&b>c) intent1.putExtra("text", res2);
            if(c>a&&c>b) intent1.putExtra("text", res3);
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
        switch (mCurrentIndex){
            case 0:
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers2);
                answers.setAdapter(adapter2);
                return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers6);
                answers.setAdapter(adapter6);
                return;
            case 6:
                ArrayAdapter<String> adapter7= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers7);
                answers.setAdapter(adapter7);

        }
    }
}
