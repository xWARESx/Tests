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

public class SelfTest extends AppCompatActivity {

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
    private String[] answers15;
    private String[] answers16;
    private String[] answers17;
    private String[] answers18;



    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    //SharedPreferences sPref;
    TextView question;
    ListView answers;
    int res = R.drawable.self_res;
    static boolean checked;
    String res1 = "низкий уровень способностей к саморазвитию и самообразованию";
    String res2 = "средний уровень способностей к саморазвитию и самообразованию";
    String res3 = "Высокий уровень способностей к саморазвитию и самообразованию";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.selfQ);
        answers1 = getResources().getStringArray(R.array.selfAns1);
        answers2 = getResources().getStringArray(R.array.selfAns2);
        answers3 = getResources().getStringArray(R.array.selfAns3);
        answers4 = getResources().getStringArray(R.array.selfAns4);
        answers5 = getResources().getStringArray(R.array.selfAns5);
        answers6 = getResources().getStringArray(R.array.selfAns6);
        answers7 = getResources().getStringArray(R.array.selfAns7);
        answers8 = getResources().getStringArray(R.array.selfAns8);
        answers9 = getResources().getStringArray(R.array.selfAns9);
        answers10 = getResources().getStringArray(R.array.selfAns10);
        answers11 = getResources().getStringArray(R.array.selfAns11);
        answers12 = getResources().getStringArray(R.array.selfAns12);
        answers13 = getResources().getStringArray(R.array.selfAns13);
        answers14 = getResources().getStringArray(R.array.selfAns14);
        answers15 = getResources().getStringArray(R.array.selfAns15);
        answers16 = getResources().getStringArray(R.array.selfAns16);
        answers17 = getResources().getStringArray(R.array.selfAns17);
        answers18 = getResources().getStringArray(R.array.selfAns18);

        res1 = getString(R.string.selfRes1);
        res2 = getString(R.string.selfRes2);
        res3 = getString(R.string.selfRes3);

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
        switch (q){
            case 6:
            case 12:
            case 14:
            case 15:
                sum+=2;
                break;
            case 1:
            case 3:
            case 11:
            case 17:
                sum+=3;
                break;
            case 2:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 13:
            case 16:
            case 18:
                sum++;
                break;
        }
        if(q==18){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=28) intent1.putExtra("text", res1);
            if(sum>28&&sum<=37) intent1.putExtra("text", res2);
            if(sum>37&&sum<=45) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }
        q++;
    }

    private void checkAnswer1(){
        switch (q){
            case 1:
            case 5:
            case 7:
            case 9:
            case 10:
            case 17:
            case 18:
                sum+=2;
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            case 13:
            case 16:
                sum+=3;
                break;
            case 3:
            case 11:
            case 12:
            case 14:
            case 15:
                sum++;
                break;
        }
        if(q==18){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=28) intent1.putExtra("text", res1);
            if(sum>28&&sum<=37) intent1.putExtra("text", res2);
            if(sum>37&&sum<=45) intent1.putExtra("text", res3);
            intent1.putExtra("image", res);
            startActivity(intent1);
        }

        q++;
    }
    private void checkAnswer2() {
        switch (q){
            case 2:
            case 3:
            case 4:
            case 6:
            case 8:
            case 11:
            case 13:
            case 16:
                sum+=2;
                break;
            case 5:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 18:
                sum+=3;
                break;
            case 1:
            case 17:
                sum++;
                break;

        }
        if(q==18){
            Intent intent1 = new Intent(this, Results1.class);
            if(sum<=28) intent1.putExtra("text", res1);
            if(sum>28&&sum<=37) intent1.putExtra("text", res2);
            if(sum>37&&sum<=45) intent1.putExtra("text", res3);
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
                return;
            case 14:
                ArrayAdapter<String> adapter15= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers15);
                answers.setAdapter(adapter15);
                return;
            case 15:
                ArrayAdapter<String> adapter16= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers16);
                answers.setAdapter(adapter16);
                return;
            case 16:
                ArrayAdapter<String> adapter17= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers17);
                answers.setAdapter(adapter17);
                return;
            case 17:
                ArrayAdapter<String> adapter18= new ArrayAdapter<>(this, R.layout.w_and_b_lay, answers18);
                answers.setAdapter(adapter18);

        }
    }
}
