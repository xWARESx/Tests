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

public class SlangTest extends AppCompatActivity {

    public static String[] questions = {"Шаришь? А что это?", "Что такое кринж?", "Человек, в которого Вы влюбились - это...", "Если ты не знал, что такое краш, то ты олд. Кто?", "Не парься, ты не олд. Это был всего лишь рофл.\nРофл?", "Что означает имбовый?", "Пипяо.\nДа, и такое есть. Что это?(с цензурой)", "Запилить", "Это приложение создает такой крутой вайб. То есть...", "Рандомный - это...", "А где пруфы?", "А помните как все форсили фразу эщкере.\nЧто делали?", "Если Вы плохо пройдете этот тест, то всегда можно апнуться и пройти заново.\nАпнуться?"};
    private String[] answers1 = {"разбираться в каком-то материале", "осуждать другое мнение", "любить аниме"};
    private String[] answers2 = {"смесь между неловкостью и стыдом", "нож", "неприязнь"};
    private String[] answers3 = {"крошь", "краш", "тян"};
    private String[] answers4 = {"старый", "тупой"};
    private String[] answers5 = {"шутка", "оговорка"};
    private String[] answers6 = {"глупый", "крутой", "сильный"};
    private String[] answers7 = {"капец", "женский половой орган", "блин"};
    private String[] answers8 = {"починить", "замена глаголов, обозначающих действие", "выложить в сеть"};
    private String[] answers9 = {"атмосферу", "впечатление"};
    private String[] answers10 = {"случайный", "целенаправленный"};
    private String[] answers11 = {"документы", "доказательства", "крыши, на которые можно залезть"};
    private String[] answers12 = {"делали популярным", "ненавидили"};
    private String[] answers13 = {"повысить уровень", "узнать больше"};
    public static String[] rightAns = {"разбираться в каком-то материале", "смесь между неловкостью и стыдом", "краш", "старый", "шутка", "крутой", "капец", "замена глаголов, обозначающих действие", "атмосферу", "случайный", "доказательства", "делали популярным", "повысить уровень"};
    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int res = R.drawable.slang_res;
    String res1 = "Вы вряд ли поймете о чем сейчас говорит молодежь. Возможно, Вы все еще ставите в конце слов твердый знак";
    String res2 = "Вы не отстаете от молодых, но айтемы называете одеждой";
    String res3 = "Вы рарнее рарных айтемов";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slang_test);
        checked=true;
        question = (TextView) findViewById(R.id.question1);
        answers = (ListView) findViewById(R.id.answers1);
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
        b1.setTitle("неверно").setIcon(R.drawable.icon_answer_bad).setCancelable(false).setPositiveButton("дальше", new DialogInterface.OnClickListener() {
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
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle("верно").setIcon(R.drawable.icon_answe_good).setCancelable(false).setPositiveButton("дальше", new DialogInterface.OnClickListener() {
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
            case 3:
            case 6:
            case 8:
            case 11:
                AlertDialog.Builder b1 = new AlertDialog.Builder(this);
                b1.setTitle("неверно").setIcon(R.drawable.icon_answer_bad).setCancelable(false).setPositiveButton("дальше", new DialogInterface.OnClickListener() {
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
        if(q==13){
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=12) intent1.putExtra("text", res3);
            if(sum<12&&sum>=7) intent1.putExtra("text", res2);
            if(sum<7) intent1.putExtra("text", res1);
            startActivity(intent1);

        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 3:
            case 6:
            case 8:
            case 11:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle("верно").setIcon(R.drawable.icon_answe_good).setCancelable(false).setPositiveButton("дальше", new DialogInterface.OnClickListener() {
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
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
                AlertDialog.Builder b1 = new AlertDialog.Builder(this);
                b1.setTitle("неверно").setIcon(R.drawable.icon_answer_bad).setCancelable(false).setPositiveButton("дальше", new DialogInterface.OnClickListener() {
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
        if (q == 13) {
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=12) intent1.putExtra("text", res3);
            if(sum<12&&sum>=7) intent1.putExtra("text", res2);
            if(sum<7) intent1.putExtra("text", res1);
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
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(sum>=12) ed.putBoolean("Имбовый", true);
        if(sum<12&&sum>=7) ed.putBoolean("Нормуль", true);
        if(sum<7) ed.putBoolean("Олд", true);
        ed.apply();
    }
}
