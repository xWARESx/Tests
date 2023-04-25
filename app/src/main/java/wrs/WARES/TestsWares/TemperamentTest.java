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

public class TemperamentTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    private String[] answers2;
    private String[] answers3;
    private String[] answers4;
    private String[] answers5;
    private String[] answers6;
    private String[] answers7;
    private String[] answers8;
    private String[] answers9;
    private String[] answers10;
    private String[] answers11;
    private String[] answers12;
    private String[] answers13;
    private String[] answers14;

    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.temp_res;
    static boolean checked;
    int a=0, b=0, c=0, d=0;
    String res1;
    String res2;
    String res3;
    String res4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperament_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.tempQ);
        answers1 = getResources().getStringArray(R.array.tempAns1);
        answers2 = getResources().getStringArray(R.array.tempAns2);
        answers3 = getResources().getStringArray(R.array.tempAns3);
        answers4 = getResources().getStringArray(R.array.tempAns4);
        answers5 = getResources().getStringArray(R.array.tempAns5);
        answers6 = getResources().getStringArray(R.array.tempAns6);
        answers7 = getResources().getStringArray(R.array.tempAns7);
        answers8 = getResources().getStringArray(R.array.tempAns8);
        answers9 = getResources().getStringArray(R.array.tempAns9);
        answers10 = getResources().getStringArray(R.array.tempAns10);
        answers11 = getResources().getStringArray(R.array.tempAns11);
        answers12 = getResources().getStringArray(R.array.tempAns12);
        answers13 = getResources().getStringArray(R.array.tempAns13);
        answers14 = getResources().getStringArray(R.array.tempAns14);

        res1 = getString(R.string.tempRes1);
        res2 = getString(R.string.tempRes2);
        res3 = getString(R.string.tempRes3);
        res4 = getString(R.string.tempRes4);

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

    private void checkAnswer3() {
        if (q == 14) {
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c&&a>d) intent1.putExtra("text", res1);
            if(b>a&&b>c&&b>d) intent1.putExtra("text", res2);
            if(c>a&&c>b&&c>d) intent1.putExtra("text", res3);
            if(d>a&&d>b&&d>c) intent1.putExtra("text", res4);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }
        c++;
        q++;
    }

    private void checkAnswer1(){
        if(q==14){
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c&&a>d) intent1.putExtra("text", res1);
            if(b>a&&b>c&&b>d) intent1.putExtra("text", res2);
            if(c>a&&c>b&&c>d) intent1.putExtra("text", res3);
            if(d>a&&d>b&&d>c) intent1.putExtra("text", res4);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }
        a++;
        q++;
    }
    private void checkAnswer2() {
        if (q == 14) {
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c&&a>d) intent1.putExtra("text", res1);
            if(b>a&&b>c&&b>d) intent1.putExtra("text", res2);
            if(c>a&&c>b&&c>d) intent1.putExtra("text", res3);
            if(d>a&&d>b&&d>c) intent1.putExtra("text", res4);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }
        b++;
        q++;
    }
    private void checkAnswer4() {
        if (q == 14) {
            Intent intent1 = new Intent(this, Results1.class);
            if(a>b&&a>c&&a>d) intent1.putExtra("text", res1);
            if(b>a&&b>c&&b>d) intent1.putExtra("text", res2);
            if(c>a&&c>b&&c>d) intent1.putExtra("text", res3);
            if(d>a&&d>b&&d>c) intent1.putExtra("text", res4);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }
        d++;
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
                return;
            case 7:
                ArrayAdapter<String> adapter8= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers8);
                answers.setAdapter(adapter8);
                return;
            case 8:
                ArrayAdapter<String> adapter9= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers9);
                answers.setAdapter(adapter9);
                return;
            case 9:
                ArrayAdapter<String> adapter10= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers10);
                answers.setAdapter(adapter10);
                return;
            case 10:
                ArrayAdapter<String> adapter11= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers11);
                answers.setAdapter(adapter11);
                return;
            case 11:
                ArrayAdapter<String> adapter12= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers12);
                answers.setAdapter(adapter12);
                return;
            case 12:
                ArrayAdapter<String> adapter13= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers13);
                answers.setAdapter(adapter13);
                return;
            case 13:
                ArrayAdapter<String> adapter14= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers14);
                answers.setAdapter(adapter14);

        }
    }
}
