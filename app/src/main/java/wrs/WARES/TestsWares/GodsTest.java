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

public class GodsTest extends AppCompatActivity {

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
    int sum=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int res = R.drawable.gods;
    String res1;
    String res2;
    String res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gods_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.GodsQ);
        answers1 = getResources().getStringArray(R.array.godsAns1);
        answers2 = getResources().getStringArray(R.array.godsAns2);
        answers3 = getResources().getStringArray(R.array.godsAns3);
        answers4 = getResources().getStringArray(R.array.godsAns4);
        answers5 = getResources().getStringArray(R.array.godsAns5);
        answers6 = getResources().getStringArray(R.array.godsAns6);
        answers7 = getResources().getStringArray(R.array.godsAns7);
        answers8 = getResources().getStringArray(R.array.godsAns8);
        answers9 = getResources().getStringArray(R.array.godsAns9);
        answers10 = getResources().getStringArray(R.array.godsAns10);
        answers11 = getResources().getStringArray(R.array.godsAns11);

        res1 = getString(R.string.godsRes1);
        res2 = getString(R.string.godsRes2);
        res3 = getString(R.string.godsRes3);

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
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
            case 11:
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
            case 4:
            case 6:
            case 8:
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
        if(q==11){
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=9) intent1.putExtra("text", res3);
            if(sum<9&&sum>=6) intent1.putExtra("text", res2);
            if(sum<6) intent1.putExtra("text", res1);
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 2:
            case 4:
            case 6:
            case 8:
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
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
            case 11:
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
        if (q == 11) {
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=9) intent1.putExtra("text", res3);
            if(sum<9&&sum>=6) intent1.putExtra("text", res2);
            if(sum<6) intent1.putExtra("text", res1);
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
                return;
            case 8:
                ArrayAdapter<String> adapter9= new ArrayAdapter<>(this, R.layout.black_lay, answers9);
                answers.setAdapter(adapter9);
                return;
            case 9:
                ArrayAdapter<String> adapter10= new ArrayAdapter<>(this, R.layout.black_lay, answers10);
                answers.setAdapter(adapter10);
                return;
            case 10:
                ArrayAdapter<String> adapter11= new ArrayAdapter<>(this, R.layout.black_lay, answers11);
                answers.setAdapter(adapter11);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(sum>=9) ed.putBoolean("gods3", true);
        if(sum<9&&sum>=6) ed.putBoolean("gods2", true);
        if(sum<6) ed.putBoolean("gods1", true);
        ed.apply();
    }
}
