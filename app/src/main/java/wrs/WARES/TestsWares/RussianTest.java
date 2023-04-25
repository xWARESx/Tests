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

public class RussianTest extends AppCompatActivity {

    public static String[] questions = {"Начнем с ударений.\nтОрты или тортЫ", "Фильм нАчался, начАлся или началсЯ", "Не забудьте меня увЕдомить.\nИли уведомИть ", "Любимое н/нн.\nПечен(н)ые в духовке яблоки", "Только аккуратно!\nМожет возникнуть путан(н)ица", "Я больше чем уверен, что ты смышленный!\nИли смышленый?", "Все-таки.\nЗдесь тире или дефис?", "У меня есть сто рублей, а нужно четыреста. Мне не хватает ... рублей", "На улице детишки прыгали бегали да просто ходили.\nСколько здесь запятых?", "Посмотрев ей в глаза я понял что хочу провести с ней всю жизнь.\nА здесь сколько запятых?", "\"Посмотрев ей в глаза.\"\nЭто обособленное определение, выраженное каким оборотом?", "Кто является создателем первой научной русской грамматики?", "И напоследок:\nсколько существует слов на букву \"й\"?"};
    private String[] answers1 = {"тОрты", "тортЫ"};
    private String[] answers2 = {"нАчался", "началсЯ", "начАлся"};
    private String[] answers3 = {"увЕдомить", "уведомИть"};
    private String[] answers4 = {"печеные", "печенные"};
    private String[] answers5 = {"путаница", "путанница"};
    private String[] answers6 = {"смышленый", "смышленный"};
    private String[] answers7 = {"пфф, тире", "пфф, дефис"};
    private String[] answers8 = {"трехста", "трехсот"};
    private String[] answers9 = {"одна", "две", "три"};
    private String[] answers10 = {"одна", "две", "три"};
    private String[] answers11 = {"деепричастным", "причастным"};
    private String[] answers12 = {"Ломоносов", "Лобачевский", "Чебышев"};
    private String[] answers13 = {"3", "больше 50, но меньше 100", "около 10"};
    public static String[] rightAns = {"тОрты", "началсЯ. В слове «началсЯ» (а также в «дождалИсь» и «собралИсь») ударение падает на последний слог, хотя в настоящем времени ударение стоит в другом месте — «начАться». Лингвисты приводят такую закономерность: достаточно часто в возвратных глаголах ударение в прошедшем времени переходит на окончание","увЕдомить",
    "печенные. Так как есть зависимое слово. Печенные где? В духовке",
            "путаница", "смышленый", "дефис", "трехсот. Нет пятисот, четырехсот, но нет ста рублей",
    "одна. \"Да\" - это тоже союз, заменяет \"и\"", "две. Выделяется деепричастный оборот и \"я понял, что\"",
    "деепричастным. Что сделав?", "Ломоносов", "больше 50, но меньше 100. Таких аж 74"};

    int q=1;
    int sum=0;
    private int mCurrentIndex = 0;
    SharedPreferences sPref;
    TextView question;
    ListView answers;
    static boolean checked;
    int res = R.drawable.russian_res;
    String res1 = "Вам стоит подучить русский язык";
    String res2 = "Хорошо, но некоторые правила все же стоит повторить";
    String res3 = "Отлично! Вы прекрасный носитель русского языка. Ломоносов Вами бы гордился";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_test);
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

        if(q==13){
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=14) intent1.putExtra("text", res3);
            if(sum<14&&sum>=7) intent1.putExtra("text", res2);
            if(sum<7) intent1.putExtra("text", res1);
            startActivity(intent1);
        }
        q++;
    }

    private void checkAnswer1(){
        switch (q){
            case 1:
            case 3:
            case 5:
            case 6:
            case 9:
            case 11:
            case 12:
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
            case 2:
            case 4:
            case 7:
            case 8:
            case 10:
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
        if(q==13){
            Intent intent1 = new Intent(this, Results2.class);
            intent1.putExtra("image", res);
            if(sum>=14) intent1.putExtra("text", res3);
            if(sum<14&&sum>=7) intent1.putExtra("text", res2);
            if(sum<7) intent1.putExtra("text", res1);
            startActivity(intent1);
        }

        q++;
    }
    private void checkAnswer2() {
        switch (q) {
            case 2:
            case 4:
            case 7:
            case 8:
            case 10:
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
            case 1:
            case 3:
            case 5:
            case 6:
            case 9:
            case 11:
            case 12:
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
            if(sum>=14) intent1.putExtra("text", res3);
            if(sum<14&&sum>=7) intent1.putExtra("text", res2);
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
                ArrayAdapter<String> adapter1= new ArrayAdapter<>(this, R.layout.russian_lay, answers1);
                answers.setAdapter(adapter1);
                return;
            case 1:
                ArrayAdapter<String> adapter2= new ArrayAdapter<>(this, R.layout.russian_lay, answers2);
                answers.setAdapter(adapter2);
                return;
            case 2:
                ArrayAdapter<String> adapter3= new ArrayAdapter<>(this, R.layout.russian_lay, answers3);
                answers.setAdapter(adapter3);
                return;
            case 3:
                ArrayAdapter<String> adapter4= new ArrayAdapter<>(this, R.layout.russian_lay, answers4);
                answers.setAdapter(adapter4);
                return;
            case 4:
                ArrayAdapter<String> adapter5= new ArrayAdapter<>(this, R.layout.russian_lay, answers5);
                answers.setAdapter(adapter5);
                return;
            case 5:
                ArrayAdapter<String> adapter6= new ArrayAdapter<>(this, R.layout.russian_lay, answers6);
                answers.setAdapter(adapter6);
                return;
            case 6:
                ArrayAdapter<String> adapter7= new ArrayAdapter<>(this, R.layout.russian_lay, answers7);
                answers.setAdapter(adapter7);
                return;
            case 7:
                ArrayAdapter<String> adapter8= new ArrayAdapter<>(this, R.layout.russian_lay, answers8);
                answers.setAdapter(adapter8);
                return;
            case 8:
                ArrayAdapter<String> adapter9= new ArrayAdapter<>(this, R.layout.russian_lay, answers9);
                answers.setAdapter(adapter9);
                return;
            case 9:
                ArrayAdapter<String> adapter10= new ArrayAdapter<>(this, R.layout.russian_lay, answers10);
                answers.setAdapter(adapter10);
                return;
            case 10:
                ArrayAdapter<String> adapter11= new ArrayAdapter<>(this, R.layout.russian_lay, answers11);
                answers.setAdapter(adapter11);
                return;
            case 11:
                ArrayAdapter<String> adapter12= new ArrayAdapter<>(this, R.layout.russian_lay, answers12);
                answers.setAdapter(adapter12);
                return;
            case 12:
                ArrayAdapter<String> adapter13= new ArrayAdapter<>(this, R.layout.russian_lay, answers13);
                answers.setAdapter(adapter13);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(sum>=14) ed.putBoolean("russian3", true);
        if(sum<14&&sum>=7) ed.putBoolean("russian2", true);
        if(sum<7) ed.putBoolean("russian1", true);
        ed.apply();
    }
}
