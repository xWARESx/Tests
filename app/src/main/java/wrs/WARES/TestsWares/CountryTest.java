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

public class CountryTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    private String[] answers2;
    private String[] answers3;
    private String[] answers4;
    private String[] answers5;
    private String[] answers6;
    private String[] answers7;
    int q=1;
    int usa=0;
    int canada=0;
    int australia=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int resU = R.drawable.res_u;
    int resA = R.drawable.res_a;
    int resC = R.drawable.res_c;
    String resUsa;
    String resCanada;
    String resAustralia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.countryQ);
        answers1 = getResources().getStringArray(R.array.countryAns1);
        answers2 = getResources().getStringArray(R.array.countryAns2);
        answers3 = getResources().getStringArray(R.array.countryAns3);
        answers4 = getResources().getStringArray(R.array.countryAns4);
        answers5 = getResources().getStringArray(R.array.countryAns5);
        answers6 = getResources().getStringArray(R.array.countryAns6);
        answers7 = getResources().getStringArray(R.array.countryAns7);


        resUsa = getString(R.string.resUsa);
        resCanada = getString(R.string.resCanada);
        resAustralia = getString(R.string.resAustralia);

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

    private void checkAnswer3()
    {
        switch (q){
            case 1:
            case 3:
            case 7:
                usa++;
                break;
                case 2:
                    canada--;
                    australia--;
                    break;
            case 4:
            case 6:
                australia++;
            break;
        case 5:
            canada++;
            break;

        }
        if(q==7){
            Intent intent1 = new Intent(this, Results.class);
            if(usa>=australia&&usa>=canada){
                intent1.putExtra("image", resU);
                intent1.putExtra("text", resUsa);
            }
            if(australia>usa&&australia>=canada){
                intent1.putExtra("image", resA);
                intent1.putExtra("text", resAustralia);
            }
            if(canada>usa&&canada>australia){
                intent1.putExtra("image", resC);
                intent1.putExtra("text", resCanada);
            }
            startActivity(intent1);

        }
        q++;
    }

    private void checkAnswer1(){
        switch (q){
            case 1:
            case 7:
                canada++;
                break;
            case 2:
                canada++;
                australia++;
                usa++;
                break;
            case 3:
            case 5:
                australia++;
                break;
            case 4:
            case 6:
                usa++;
                break;

        }
        if(q==7){
            Intent intent1 = new Intent(this, Results.class);
            if(usa>=australia&&usa>=canada){
                intent1.putExtra("image", resU);
                intent1.putExtra("text", resUsa);
            }
            if(australia>usa&&australia>=canada){
                intent1.putExtra("image", resA);
                intent1.putExtra("text", resAustralia);
            }
            if(canada>usa&&canada>australia){
                intent1.putExtra("image", resC);
                intent1.putExtra("text", resCanada);
            }
            startActivity(intent1);
        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 1:
            case 7:
                australia++;
                break;
            case 2:
                canada++;
                australia++;
                break;
            case 3:
            case 4:
            case 6:
                canada++;
                break;
            case 5:
                usa++;
                break;
        }
        if (q == 7) {
            Intent intent1 = new Intent(this, Results.class);
            if(usa>=australia&&usa>=canada){
                intent1.putExtra("image", resU);
                intent1.putExtra("text", resUsa);
            }
            if(australia>usa&&australia>=canada){
                intent1.putExtra("image", resA);
                intent1.putExtra("text", resAustralia);
            }
            if(canada>usa&&canada>australia){
                intent1.putExtra("image", resC);
                intent1.putExtra("text", resCanada);
            }
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

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(usa>=australia&&usa>=canada){
            ed.putBoolean("usa", true);
        }
        if(australia>usa&&australia>=canada){
            ed.putBoolean("australia", true);
        }
        if(canada>usa&&canada>australia){
            ed.putBoolean("canada", true);
        }
        ed.apply();
    }
}
