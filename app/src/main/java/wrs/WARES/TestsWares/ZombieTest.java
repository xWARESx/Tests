package wrs.WARES.TestsWares;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.WARES.tests.R;

public class ZombieTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    private String[] answers2;
    private String[] answers3;
    private String[] answers4;
    private String[] answers5;
    private String[] answers6;
    private String[] answers7;
    private String[] answers8;
    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int res = R.drawable.zombie_res;
    String res1;
    String res2;
    String res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombie_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.zombieQ);
        answers1 = getResources().getStringArray(R.array.zombieAns1);
        answers2 = getResources().getStringArray(R.array.zombieAns2);
        answers3 = getResources().getStringArray(R.array.zombieAns3);
        answers4 = getResources().getStringArray(R.array.zombieAns4);
        answers5 = getResources().getStringArray(R.array.zombieAns5);
        answers6 = getResources().getStringArray(R.array.zombieAns6);
        answers7 = getResources().getStringArray(R.array.zombieAns7);
        answers8 = getResources().getStringArray(R.array.zombieAns8);

        res1 = getString(R.string.zombieRes1);
        res2 = getString(R.string.zombieRes2);
        res3 = getString(R.string.zombieRes3);

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
            case 3:
            case 4:
            case 6:
                sum++;
                break;

        }
        if(q==8){
            Intent intent1 = new Intent(this, Results.class);
            intent1.putExtra("image", res);
            if(sum>=7) intent1.putExtra("text", res3);
            if(sum<7&&sum>=5) intent1.putExtra("text", res2);
            if(sum<5) intent1.putExtra("text", res1);
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 2:
            case 5:
            case 7:
            case 8:
                sum++;
                break;
        }
        if(q==8){
            Intent intent1 = new Intent(this, Results.class);
            intent1.putExtra("image", res);
            if(sum>=7) intent1.putExtra("text", res3);
            if(sum<7&&sum>=5) intent1.putExtra("text", res2);
            if(sum<5) intent1.putExtra("text", res1);
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
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.black_lay, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.black_lay, answers2);
                answers.setAdapter(adapter2);
                return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.black_lay, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.black_lay, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.black_lay, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.black_lay, answers6);
                answers.setAdapter(adapter6);
                return;
            case 6:
                ArrayAdapter<String> adapter7= new ArrayAdapter<>(this, R.layout.black_lay, answers7);
                answers.setAdapter(adapter7);
                return;
            case 7:
                ArrayAdapter<String> adapter8= new ArrayAdapter<>(this, R.layout.black_lay, answers8);
                answers.setAdapter(adapter8);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(sum>=7) ed.putBoolean("zombie3", true);
        if(sum<7&&sum>=5) ed.putBoolean("zombie2", true);
        if(sum<5) ed.putBoolean("zombie1", true);
        ed.apply();
    }
}
