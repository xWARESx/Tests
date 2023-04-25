package wrs.WARES.TestsWares;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class KosmosTest extends AppCompatActivity {
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
    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int astronaut = R.drawable.kos_res;
    String res1;
    String res2;
    String res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosmos_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.kosmosQ);
        answers1 = getResources().getStringArray(R.array.kosmosAns1);
        answers2 = getResources().getStringArray(R.array.kosmosAns2);
        answers3 = getResources().getStringArray(R.array.kosmosAns3);
        answers4 = getResources().getStringArray(R.array.kosmosAns4);
        answers5 = getResources().getStringArray(R.array.kosmosAns5);
        answers6 = getResources().getStringArray(R.array.kosmosAns6);
        answers7 = getResources().getStringArray(R.array.kosmosAns7);
        answers8 = getResources().getStringArray(R.array.kosmosAns8);
        answers9 = getResources().getStringArray(R.array.kosmosAns9);
        answers10 = getResources().getStringArray(R.array.kosmosAns10);
        answers11 = getResources().getStringArray(R.array.kosmosAns11);
        answers12 = getResources().getStringArray(R.array.kosmosAns12);
        answers13 = getResources().getStringArray(R.array.kosmosAns13);
        answers14 = getResources().getStringArray(R.array.kosmosAns14);
        answers15 = getResources().getStringArray(R.array.kosmosAns15);
        answers16 = getResources().getStringArray(R.array.kosmosAns16);

        res1 = getString(R.string.kosRes1);
        res2 = getString(R.string.kosRes2);
        res3 = getString(R.string.kosRes3);

        answers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: checkAnswer1();
                        mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                        break;
                    case 1: checkAnswer2();
                        mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                        break;
                    case 2:
                        checkAnswer3();
                        mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                        break;
                }
            }
        });
        updateQuestion();
        updateAnswers();
    }

    private void checkAnswer3() {
        AlertDialog.Builder b1 = new AlertDialog.Builder(this);
        b1.setTitle(getString(R.string.wrong)).setIcon(R.drawable.icon_answer_bad).setCancelable(false).setPositiveButton(getString(R.string.next), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                updateQuestion();
                updateAnswers();
            }
        });
        AlertDialog al1 = b1.create();
        al1.show();
        q++;
    }

    private void checkAnswer1(){
        switch (q){
            case 2:
            case 3:
            case 6:
            case 10:
            case 11:
            case 13:
            case 16:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle(getString(R.string.right)).setIcon(R.drawable.icon_answe_good).setCancelable(false).setPositiveButton(getString(R.string.next), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        updateQuestion();
                        updateAnswers();
                    }
                });
                AlertDialog al = b.create();
                al.show();
                sum++;
                break;
            case 1:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 12:
            case 14:
            case 15:
                AlertDialog.Builder b1 = new AlertDialog.Builder(this);
                b1.setTitle(getString(R.string.wrong)).setIcon(R.drawable.icon_answer_bad).setCancelable(false).setPositiveButton(getString(R.string.next), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        updateQuestion();
                        updateAnswers();
                    }
                });
                AlertDialog al1 = b1.create();
                al1.show();
                break;

        }
        if(q==16){
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", astronaut);
            if(sum>=14) intent1.putExtra("text", res3);
            if(sum<14&&sum>=8) intent1.putExtra("text", res2);
            if(sum<8) intent1.putExtra("text", res1);
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
       switch (q) {
           case 1:
           case 4:
           case 5:
           case 7:
           case 8:
           case 9:
           case 12:
           case 14:
           case 15:
               AlertDialog.Builder b = new AlertDialog.Builder(this);
               b.setTitle(getString(R.string.right)).setIcon(R.drawable.icon_answe_good).setCancelable(false).setPositiveButton(getString(R.string.next), new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                       updateQuestion();
                       updateAnswers();
                   }
               });
               AlertDialog al = b.create();
               al.show();
               sum++;
               break;
           case 2:
           case 3:
           case 6:
           case 10:
           case 11:
           case 13:
           case 16:
               AlertDialog.Builder b1 = new AlertDialog.Builder(this);
               b1.setTitle(getString(R.string.wrong)).setIcon(R.drawable.icon_answer_bad).setCancelable(false).setPositiveButton(getString(R.string.next), new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                       updateQuestion();
                       updateAnswers();
                   }
               });
               AlertDialog al1 = b1.create();
               al1.show();
               break;
        }
        if (q == 16) {
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", astronaut);
            if(sum>=14) intent1.putExtra("text", res3);
            if(sum<14&&sum>=8) intent1.putExtra("text", res2);
            if(sum<8) intent1.putExtra("text", res1);
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
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers2);
                answers.setAdapter(adapter2);
                return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers6);
                answers.setAdapter(adapter6);
                return;
            case 6:
                ArrayAdapter<String> adapter7= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers7);
                answers.setAdapter(adapter7);
                return;
            case 7:
                ArrayAdapter<String> adapter8= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers8);
                answers.setAdapter(adapter8);
                return;
            case 8:
                ArrayAdapter<String> adapter9= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers9);
                answers.setAdapter(adapter9);
                return;
            case 9:
                ArrayAdapter<String> adapter10= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers10);
                answers.setAdapter(adapter10);
                return;
            case 10:
                ArrayAdapter<String> adapter11= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers11);
                answers.setAdapter(adapter11);
                return;
            case 11:
                ArrayAdapter<String> adapter12= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers12);
                answers.setAdapter(adapter12);
                return;
            case 12:
                ArrayAdapter<String> adapter13= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers13);
                answers.setAdapter(adapter13);
                return;
            case 13:
                ArrayAdapter<String> adapter14= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers14);
                answers.setAdapter(adapter14);
                return;
            case 14:
                ArrayAdapter<String> adapter15= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers15);
                answers.setAdapter(adapter15);
                return;
            case 15:
                ArrayAdapter<String> adapter16= new ArrayAdapter<>(this, R.layout.kosmos_lay, answers16);
                answers.setAdapter(adapter16);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(sum>=14) ed.putBoolean("Высший уровень", true);
        if(sum<14&&sum>=8) ed.putBoolean("Средний уровень", true);
        if(sum<8) ed.putBoolean("Низкий уровень", true);
        ed.apply();
    }
}