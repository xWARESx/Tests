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

public class HobbyTest extends AppCompatActivity {

    private String[] questions;
    private String[] answers1;
    private String[] answers2;
    private String[] answers3;
    private String[] answers4;
    private String[] answers5;
    private String[] answers6;
    int q=1;
    int painter=0;
    int photographer=0;
    int chess=0;
    int yoga=0;
    int fishing=0;
    int blog=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int ph = R.drawable.photographer;
    int pa = R.drawable.painter;
    int ch = R.drawable.chess;
    int yo = R.drawable.yoga;
    int fi = R.drawable.fishing;
    int bl = R.drawable.blog;
    String pho;
    String pai;
    String c;
    String y;
    String f;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);

        questions = getResources().getStringArray(R.array.hobbyQ);
        answers1 = getResources().getStringArray(R.array.hobbyAns1);
        answers2 = getResources().getStringArray(R.array.hobbyAns2);
        answers3 = getResources().getStringArray(R.array.hobbyAns3);
        answers4 = getResources().getStringArray(R.array.hobbyAns4);
        answers5 = getResources().getStringArray(R.array.hobbyAns5);
        answers6 = getResources().getStringArray(R.array.hobbyAns6);

        pho = getString(R.string.pho);
        pai = getString(R.string.pai);
        c = getString(R.string.c);
        y = getString(R.string.y);
        f = getString(R.string.f);
        b = getString(R.string.b);

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
                photographer+=2;
                painter+=2;
                break;
            case 2:
                photographer++;
                break;
            case 3:
                chess++;
                blog++;
                break;
            case 4:
                chess++;
                break;
            case 5:
                fishing+=3;
                yoga+=3;
                break;
            case 6:
                yoga++;
                break;
        }
        if(q==6){
            Intent intent1 = new Intent(this, Results.class);
            if(painter>photographer&&painter>chess&&painter>yoga&&painter>fishing&&painter>blog){
                intent1.putExtra("image", pa);
                intent1.putExtra("text", pai);
            }
            if(photographer>painter&&photographer>chess&&photographer>yoga&&photographer>fishing&&photographer>blog){
                intent1.putExtra("image", ph);
                intent1.putExtra("text", pho);
            }
            if(chess>photographer&&chess>painter&&chess>yoga&&chess>fishing&&chess>blog){
                intent1.putExtra("image", ch);
                intent1.putExtra("text", c);
            }
            if(yoga>photographer&&yoga>chess&&yoga>painter&&yoga>fishing&&yoga>blog){
                intent1.putExtra("image", yo);
                intent1.putExtra("text", y);
            }
            if(fishing>photographer&&fishing>chess&&fishing>yoga&&fishing>painter&&fishing>blog){
                intent1.putExtra("image", fi);
                intent1.putExtra("text", f);
            }
            if(blog>photographer&&blog>chess&&blog>yoga&&blog>fishing&&blog>painter){
                intent1.putExtra("image", bl);
                intent1.putExtra("text", b);
            }
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 1:
                photographer-=3;
                painter-=3;
                break;
            case 2:
                painter++;
                break;
            case 3:
                chess-=2;
                blog-=2;
                break;
            case 4:
                blog++;
                break;
            case 5:
                fishing-=1;
                yoga-=1;
                break;
            case 6:
                fishing++;
                break;
        }
        if(q==6){
            Intent intent1 = new Intent(this, Results.class);
            if(painter>photographer&&painter>chess&&painter>yoga&&painter>fishing&&painter>blog){
                intent1.putExtra("image", pa);
                intent1.putExtra("text", pai);
            }
            if(photographer>painter&&photographer>chess&&photographer>yoga&&photographer>fishing&&photographer>blog){
                intent1.putExtra("image", ph);
                intent1.putExtra("text", pho);
            }
            if(chess>photographer&&chess>painter&&chess>yoga&&chess>fishing&&chess>blog){
                intent1.putExtra("image", ch);
                intent1.putExtra("text", c);
            }
            if(yoga>photographer&&yoga>chess&&yoga>painter&&yoga>fishing&&yoga>blog){
                intent1.putExtra("image", yo);
                intent1.putExtra("text", y);
            }
            if(fishing>photographer&&fishing>chess&&fishing>yoga&&fishing>painter&&fishing>blog){
                intent1.putExtra("image", fi);
                intent1.putExtra("text", f);
            }
            if(blog>photographer&&blog>chess&&blog>yoga&&blog>fishing&&blog>painter){
                intent1.putExtra("image", bl);
                intent1.putExtra("text", b);
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
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.hobby_lay, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.hobby_lay, answers2);
                answers.setAdapter(adapter2);
                return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.hobby_lay, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.hobby_lay, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.hobby_lay, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.hobby_lay, answers6);
                answers.setAdapter(adapter6);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(painter>photographer&&painter>chess&&painter>yoga&&painter>fishing&&painter>blog){
            ed.putBoolean("художник", true);
        }
        if(photographer>painter&&photographer>chess&&photographer>yoga&&photographer>fishing&&photographer>blog){
            ed.putBoolean("фотограф", true);
        }
        if(chess>photographer&&chess>painter&&chess>yoga&&chess>fishing&&chess>blog){
            ed.putBoolean("шахматы", true);
        }
        if(yoga>photographer&&yoga>chess&&yoga>painter&&yoga>fishing&&yoga>blog){
            ed.putBoolean("йога", true);
        }
        if(fishing>photographer&&fishing>chess&&fishing>yoga&&fishing>painter&&fishing>blog){
            ed.putBoolean("рыбалка", true);
        }
        if(blog>photographer&&blog>chess&&blog>yoga&&blog>fishing&&blog>painter){
            ed.putBoolean("блог", true);
        }
        ed.apply();
    }
}
