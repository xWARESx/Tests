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

public class EvolutionTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    private String[] answers2;
    private String[] answers3;
    private String[] answers4;
    private String[] answers5;
    private String[] answers6;
    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int res = R.drawable.ev_res;
    String res1;
    String res2;
    String res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolution_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.evQ);
        answers1 = getResources().getStringArray(R.array.evAns1);
        answers2 = getResources().getStringArray(R.array.evAns2);
        answers3 = getResources().getStringArray(R.array.evAns3);
        answers4 = getResources().getStringArray(R.array.evAns4);
        answers5 = getResources().getStringArray(R.array.evAns5);
        answers6 = getResources().getStringArray(R.array.evAns6);

        res1 = getString(R.string.evRes1);
        res2 = getString(R.string.evRes2);
        res3 = getString(R.string.evRes3);

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
            case 4:
            case 6:
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
            case 5:
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
        if(q==6){
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=5) intent1.putExtra("text", res3);
            if(sum<5&&sum>=3) intent1.putExtra("text", res2);
            if(sum<3) intent1.putExtra("text", res1);
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 2:
            case 3:
            case 5:
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
            case 6:
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
        if (q == 6) {
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=5) intent1.putExtra("text", res3);
            if(sum<5&&sum>=3) intent1.putExtra("text", res2);
            if(sum<3) intent1.putExtra("text", res1);
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
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.evolution_lay, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.evolution_lay, answers2);
                answers.setAdapter(adapter2);
                return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.evolution_lay, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.evolution_lay, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.evolution_lay, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.evolution_lay, answers6);
                answers.setAdapter(adapter6);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(sum>=5) ed.putBoolean("evolution3", true);
        if(sum<5&&sum>=3) ed.putBoolean("evolution2", true);
        if(sum<3) ed.putBoolean("evolution1", true);
        ed.apply();
    }
}
