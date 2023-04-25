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

public class RoMTest extends AppCompatActivity {
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
    int q=1;
    int Rick = -3;
    int Morty = 0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int iRick = R.drawable.rick2;
    int iMorty = R.drawable.morty2;
    String textRick;
    String textMorty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ro_m_test);
        checked=true;
         question = (TextView) findViewById(R.id.question);
        answers = (ListView) findViewById(R.id.answers);

        questions = getResources().getStringArray(R.array.romQ);
        answers1 = getResources().getStringArray(R.array.romAns1);
        answers2 = getResources().getStringArray(R.array.romAns2);
        answers3 = getResources().getStringArray(R.array.romAns3);
        answers4 = getResources().getStringArray(R.array.romAns4);
        answers5 = getResources().getStringArray(R.array.romAns5);
        answers6 = getResources().getStringArray(R.array.romAns6);
        answers7 = getResources().getStringArray(R.array.romAns7);
        answers8 = getResources().getStringArray(R.array.romAns8);
        answers9 = getResources().getStringArray(R.array.romAns9);
        answers10 = getResources().getStringArray(R.array.romAns10);
        answers11 = getResources().getStringArray(R.array.romAns11);

        textRick = getString(R.string.romRes1);
        textMorty = getString(R.string.romRes2);

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
            case 4:
                case 6:
                case 8:
                case 11:
                Rick++;
                break;
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
                Morty++;
                break;
        }
        if(q==11){
            Intent intent1 = new Intent(this, Results.class);
            if(Rick>Morty){
                intent1.putExtra("image", iRick);
                intent1.putExtra("text", textRick);
            }
            else{
                intent1.putExtra("image", iMorty);
                intent1.putExtra("text", textMorty);
            }
            startActivity(intent1);}

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
                Rick++;
                break;
            case 1:
            case 4:
            case 6:
            case 8:
            case 11:
                Morty++;
                break;
        }
        if (q == 11) {
            Intent intent1 = new Intent(this, Results.class);
            if (Rick > Morty) {
                intent1.putExtra("image", iRick);
                intent1.putExtra("text", textRick);
            } else {
                intent1.putExtra("image", iMorty);
                intent1.putExtra("text", textMorty);
            }
            startActivity(intent1); }
            q++;
        }


    private void updateQuestion(){
        String quest = questions[mCurrentIndex];
        question.setText(quest);



    }
    private void updateAnswers(){
        switch (mCurrentIndex){
            case 0:
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers2);
                answers.setAdapter(adapter2);
            return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers6);
                answers.setAdapter(adapter6);
                return;
            case 6:
                ArrayAdapter<String> adapter7= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers7);
                answers.setAdapter(adapter7);
                return;
            case 7:
                ArrayAdapter<String> adapter8= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers8);
                answers.setAdapter(adapter8);
                return;
            case 8:
                ArrayAdapter<String> adapter9= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers9);
                answers.setAdapter(adapter9);
                return;
            case 9:
                ArrayAdapter<String> adapter10= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers10);
                answers.setAdapter(adapter10);
                return;
            case 10:
                ArrayAdapter<String> adapter11= new ArrayAdapter<>(this, R.layout.my_custom_layout, answers11);
                answers.setAdapter(adapter11);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(Rick>Morty) ed.putBoolean("Рик", true);
        else ed.putBoolean("Морти", true);
        ed.apply();
    }
}
