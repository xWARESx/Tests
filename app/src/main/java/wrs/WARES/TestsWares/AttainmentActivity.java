package wrs.WARES.TestsWares;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.WARES.tests.R;

import java.util.ArrayList;

public class AttainmentActivity extends AppCompatActivity {
    SharedPreferences sPref;
    ListView listView;
    ArrayList<String> listText1 = new ArrayList<>();
    ArrayList<String> listText2 = new ArrayList<>();
    ArrayList<Integer> listImage = new ArrayList<>();
    boolean rick;
    boolean morty;
    boolean c_1_lvl;
    boolean c_2_lvl;
    boolean c_3_lvl;
    boolean slang1;
    boolean slang2;
    boolean slang3;
    boolean classic1;
    boolean classic2;
    boolean classic3;
    boolean russian1;
    boolean russian2;
    boolean russian3;
    boolean painter;
    boolean photographer;
    boolean chess;
    boolean blog;
    boolean fishing;
    boolean yoga;
    boolean wild1;
    boolean wild2;
    boolean wild3;
    boolean actor1;
    boolean actor2;
    boolean actor3;
    boolean comic1;
    boolean comic2;
    boolean comic3;
    boolean math1;
    boolean math2;
    boolean math3;
    boolean erudition1;
    boolean erudition2;
    boolean erudition3;
    boolean zombie1;
    boolean zombie2;
    boolean zombie3;
    boolean words1;
    boolean words2;
    boolean words3;
    boolean physics1;
    boolean physics2;
    boolean physics3;
    boolean animals1;
    boolean animals2;
    boolean animals3;
    boolean animals21;
    boolean animals22;
    boolean animals23;
    boolean evolution1;
    boolean evolution2;
    boolean evolution3;
    boolean organism1;
    boolean organism2;
    boolean organism3;
    boolean usa;
    boolean canada;
    boolean australia;
    boolean mith1;
    boolean mith2;
    boolean mith3;
    boolean mith21;
    boolean mith22;
    boolean mith23;
    boolean gods1;
    boolean gods2;
    boolean gods3;
    boolean famous1;
    boolean famous2;
    boolean famous3;
    boolean harry1;
    boolean harry2;
    boolean harry3;
    boolean quotes1;
    boolean quotes2;
    boolean quotes3;
    boolean english1;
    boolean english2;
    boolean english3;
    boolean laws1;
    boolean laws2;
    boolean laws3;
    boolean opening1;
    boolean opening2;
    boolean opening3;
    boolean cats1;
    boolean cats2;
    boolean cats3;
    boolean kids1;
    boolean kids2;
    boolean kids3;
    boolean big_size1;
    boolean big_size2;
    boolean big_size3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attainment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        sPref = getSharedPreferences("pref", MODE_PRIVATE);
        //sPref.edit().clear().apply();
        rick = sPref.getBoolean("Рик", false);
        morty = sPref.getBoolean("Морти", false);

        if(rick){
            listText1.add(getString(R.string.rick));
            listText2.add(getString(R.string.rom));
            listImage.add(R.drawable.rick);
        }
        if(morty){
            listText1.add(getString(R.string.motry));
            listText2.add(getString(R.string.rom));
            listImage.add(R.drawable.morty);
        }
        c_1_lvl = sPref.getBoolean("Низкий уровень", false);
        c_2_lvl = sPref.getBoolean("Средний уровень", false);
        c_3_lvl = sPref.getBoolean("Высший уровень", false);
        if(c_1_lvl){
            listText1.add(getString(R.string.low));
            listText2.add(getString(R.string.lvlkos));
            listImage.add(R.drawable.kos_res1);
        }
        if(c_2_lvl){
            listText1.add(getString(R.string.middle));
            listText2.add(getString(R.string.lvlkos));
            listImage.add(R.drawable.kos_res1);
        }
        if(c_3_lvl){
            listText1.add(getString(R.string.high));
            listText2.add(getString(R.string.lvlkos));
            listImage.add(R.drawable.kos_res1);
        }
        slang1 = sPref.getBoolean("Олд", false);
        slang2 = sPref.getBoolean("Нормуль", false);
        slang3 = sPref.getBoolean("Имбовый", false);
        if(slang1){
            listText1.add(getString(R.string.old));
            listText2.add(getString(R.string.attSlang));
            listImage.add(R.drawable.slang_res1);
        }
        if(slang2){
            listText1.add(getString(R.string.norm));
            listText2.add(getString(R.string.attSlang));
            listImage.add(R.drawable.slang_res1);
        }
        if(slang3){
            listText1.add(getString(R.string.imb));
            listText2.add(getString(R.string.attSlang));
            listImage.add(R.drawable.slang_res1);
        }
        classic1 = sPref.getBoolean("classic1", false);
        classic2 = sPref.getBoolean("classic2", false);
        classic3 = sPref.getBoolean("classic3", false);
        if(classic1){
            listText1.add(getString(R.string.atClass1));
            listText2.add(getString(R.string.ruslit));
            listImage.add(R.drawable.classic_res);
        }
        if(classic2){
            listText1.add(getString(R.string.atClass2));
            listText2.add(getString(R.string.ruslit));
            listImage.add(R.drawable.classic_res);
        }
        if(classic3){
            listText1.add(getString(R.string.atClass3));
            listText2.add(getString(R.string.ruslit));
            listImage.add(R.drawable.classic_res);
        }
        russian1 = sPref.getBoolean("russian1", false);
        russian2 = sPref.getBoolean("russian2", false);
        russian3 = sPref.getBoolean("russian3", false);
        if(russian1){
            listText1.add(getString(R.string.rusres1));
            listText2.add(getString(R.string.ruslang));
            listImage.add(R.drawable.russian_res1);
        }
        if(russian2){
            listText1.add(getString(R.string.rusres2));
            listText2.add(getString(R.string.ruslang));
            listImage.add(R.drawable.russian_res1);
        }
        if(russian3){
            listText1.add(getString(R.string.rusres3));
            listText2.add(getString(R.string.ruslang));
            listImage.add(R.drawable.russian_res1);
        }
        painter = sPref.getBoolean("художник", false);
        photographer = sPref.getBoolean("фотограф", false);
        chess = sPref.getBoolean("шахматы", false);
        fishing = sPref.getBoolean("рыбалка", false);
        blog = sPref.getBoolean("блог", false);
        yoga = sPref.getBoolean("йога", false);
        if(painter){
            listText1.add(getString(R.string.painter));
            listText2.add(getString(R.string.hobbyAtt));
            listImage.add(R.drawable.painter_res);
        }
        if(photographer){
            listText1.add(getString(R.string.photo));
            listText2.add(getString(R.string.hobbyAtt));
            listImage.add(R.drawable.photographer_res);
        }
        if(chess){
            listText1.add(getString(R.string.chessAtt));
            listText2.add(getString(R.string.hobbyAtt));
            listImage.add(R.drawable.chess_res);
        }
        if(fishing){
            listText1.add(getString(R.string.fishing));
            listText2.add(getString(R.string.hobbyAtt));
            listImage.add(R.drawable.fishing_res);
        }
        if(blog){
            listText1.add(getString(R.string.blog));
            listText2.add(getString(R.string.hobbyAtt));
            listImage.add(R.drawable.blog_res);
        }
        if(yoga){
            listText1.add(getString(R.string.yoga));
            listText2.add(getString(R.string.hobbyAtt));
            listImage.add(R.drawable.yoga_res);
        }
        wild1 = sPref.getBoolean("wild1", false);
        wild2 = sPref.getBoolean("wild2", false);
        wild3 = sPref.getBoolean("wild3", false);
        if(wild1){
            listText1.add(getString(R.string.dead));
            listText2.add(getString(R.string.wild_natureAtt));
            listImage.add(R.drawable.wild_nature_res1);
        }
        if(wild2){
            listText1.add(getString(R.string.live));
            listText2.add(getString(R.string.wild_natureAtt));
            listImage.add(R.drawable.wild_nature_res1);
        }
        if(wild3){
            listText1.add(getString(R.string.lived));
            listText2.add(getString(R.string.wild_natureAtt));
            listImage.add(R.drawable.wild_nature_res1);
        }
        actor1 = sPref.getBoolean("actor1", false);
        actor2 = sPref.getBoolean("actor2", false);
        actor3 = sPref.getBoolean("actor3", false);
        if(actor1){
            listText1.add(getString(R.string.bad));
            listText2.add(getString(R.string.what_actor));
            listImage.add(R.drawable.actor_res1);
        }
        if(actor2){
            listText1.add(getString(R.string.middleAtt));
            listText2.add(getString(R.string.what_actor));
            listImage.add(R.drawable.actor_res1);
        }
        if(actor3){
            listText1.add(getString(R.string.cool));
            listText2.add(getString(R.string.what_actor));
            listImage.add(R.drawable.actor_res1);
        }


        comic1 = sPref.getBoolean("comic1", false);
        comic2 = sPref.getBoolean("comic2", false);
        comic3 = sPref.getBoolean("comic3", false);
        if(comic1){
            listText1.add(getString(R.string.bad));
            listText2.add(getString(R.string.what_comic));
            listImage.add(R.drawable.standup_res);
        }
        if(comic2){
            listText1.add(getString(R.string.middleAtt));
            listText2.add(getString(R.string.what_comic));
            listImage.add(R.drawable.standup_res);
        }
        if(comic3){
            listText1.add(getString(R.string.cool));
            listText2.add(getString(R.string.what_comic));
            listImage.add(R.drawable.standup_res);
        }
        math1 = sPref.getBoolean("math1", false);
        math2 = sPref.getBoolean("math2", false);
        math3 = sPref.getBoolean("math3", false);
        if(math1){
            listText1.add(getString(R.string.mathAtt1));
            listText2.add(getString(R.string.math));
            listImage.add(R.drawable.math_res1);
        }
        if(math2){
            listText1.add(getString(R.string.mathAtt2));
            listText2.add(getString(R.string.math));
            listImage.add(R.drawable.math_res1);
        }
        if(math3){
            listText1.add(getString(R.string.mathAtt3));
            listText2.add(getString(R.string.math));
            listImage.add(R.drawable.math_res1);
        }
        erudition1 = sPref.getBoolean("erudition1", false);
        erudition2 = sPref.getBoolean("erudition2", false);
        erudition3 = sPref.getBoolean("erudition3", false);
        if(erudition1){
            listText1.add(getString(R.string.plohaya));
            listText2.add(getString(R.string.erud));
            listImage.add(R.drawable.erudition_res);
        }
        if(erudition2){
            listText1.add(getString(R.string.sredn));
            listText2.add(getString(R.string.erud));
            listImage.add(R.drawable.erudition_res);
        }
        if(erudition3){
            listText1.add(getString(R.string.otl));
            listText2.add(getString(R.string.erud));
            listImage.add(R.drawable.erudition_res);
        }
        zombie1 = sPref.getBoolean("zombie1", false);
        zombie2 = sPref.getBoolean("zombie2", false);
        zombie3 = sPref.getBoolean("zombie3", false);
        if(zombie1){
            listText1.add(getString(R.string.eatted));
            listText2.add(getString(R.string.zombAtt));
            listImage.add(R.drawable.zombie_res1);
        }
        if(zombie2){
            listText1.add(getString(R.string.dead_but));
            listText2.add(getString(R.string.zombAtt));
            listImage.add(R.drawable.zombie_res1);
        }
        if(zombie3){
            listText1.add(getString(R.string.living));
            listText2.add(getString(R.string.zombAtt));
            listImage.add(R.drawable.zombie_res1);
        }
        words1 = sPref.getBoolean("words1", false);
        words2 = sPref.getBoolean("words2", false);
        words3 = sPref.getBoolean("words3", false);
        if(words1){
            listText1.add(getString(R.string.wordsAtt1));
            listText2.add(getString(R.string.wordsAtt));
            listImage.add(R.drawable.words);
        }
        if(words2){
            listText1.add(getString(R.string.wordsAtt2));
            listText2.add(getString(R.string.wordsAtt));
            listImage.add(R.drawable.words);
        }
        if(words3){
            listText1.add(getString(R.string.wordsAtt3));
            listText2.add(getString(R.string.wordsAtt));
            listImage.add(R.drawable.words);
        }
        physics1 = sPref.getBoolean("physics1", false);
        physics2 = sPref.getBoolean("physics2", false);
        physics3 = sPref.getBoolean("physics3", false);
        if(physics1){
            listText1.add(getString(R.string.physicsAtt1));
            listText2.add(getString(R.string.physicsAtt));
            listImage.add(R.drawable.physics_back);
        }
        if(physics2){
            listText1.add(getString(R.string.physicsAtt2));
            listText2.add(getString(R.string.physicsAtt));
            listImage.add(R.drawable.physics_back);
        }
        if(physics3){
            listText1.add(getString(R.string.physicsAtt3));
            listText2.add(getString(R.string.physicsAtt));
            listImage.add(R.drawable.physics_back);
        }
        animals1 = sPref.getBoolean("animals1", false);
        animals2 = sPref.getBoolean("animals2", false);
        animals3 = sPref.getBoolean("animals3", false);
        if(animals1){
            listText1.add(getString(R.string.animAtt1));
            listText2.add(getString(R.string.animAtt));
            listImage.add(R.drawable.animals_res);
        }
        if(animals2){
            listText1.add(getString(R.string.animAtt2));
            listText2.add(getString(R.string.animAtt));
            listImage.add(R.drawable.animals_res);
        }
        if(animals3){
            listText1.add(getString(R.string.animAtt3));
            listText2.add(getString(R.string.animAtt));
            listImage.add(R.drawable.animals_res);
        }
        animals21 = sPref.getBoolean("2animals1", false);
        animals22 = sPref.getBoolean("2animals2", false);
        animals23 = sPref.getBoolean("2animals3", false);
        if(animals21){
            listText1.add(getString(R.string.animAtt1));
            listText2.add(getString(R.string.anim2Att));
            listImage.add(R.drawable.animals2_res);
        }
        if(animals22){
            listText1.add(getString(R.string.animAtt2));
            listText2.add(getString(R.string.anim2Att));
            listImage.add(R.drawable.animals2_res);
        }
        if(animals23){
            listText1.add(getString(R.string.animAtt3));
            listText2.add(getString(R.string.anim2Att));
            listImage.add(R.drawable.animals2_res);
        }
        evolution1 = sPref.getBoolean("evolution1", false);
        evolution2 = sPref.getBoolean("evolution2", false);
        evolution3 = sPref.getBoolean("evolution3", false);
        if(evolution1){
            listText1.add(getString(R.string.bady));
            listText2.add(getString(R.string.evAtt));
            listImage.add(R.drawable.evolution_res);
        }
        if(evolution2){
            listText1.add(getString(R.string.notbad));
            listText2.add(getString(R.string.evAtt));
            listImage.add(R.drawable.evolution_res);
        }
        if(evolution3){
            listText1.add(getString(R.string.darvin));
            listText2.add(getString(R.string.evAtt));
            listImage.add(R.drawable.evolution_res);
        }
        organism1 = sPref.getBoolean("organism1", false);
        organism2 = sPref.getBoolean("organism2", false);
        organism3 = sPref.getBoolean("organism3", false);
        if(organism1){
            listText1.add(getString(R.string.orgAtt1));
            listText2.add(getString(R.string.orgAtt));
            listImage.add(R.drawable.organism_res1);
        }
        if(organism2){
            listText1.add(getString(R.string.notbad));
            listText2.add(getString(R.string.orgAtt));
            listImage.add(R.drawable.organism_res1);
        }
        if(organism3){
            listText1.add(getString(R.string.orgAtt3));
            listText2.add(getString(R.string.orgAtt));
            listImage.add(R.drawable.organism_res1);
        }
        usa = sPref.getBoolean("usa", false);
        canada = sPref.getBoolean("canada", false);
        australia = sPref.getBoolean("australia", false);
        if(usa){
            listText1.add("USA");
            listText2.add(getString(R.string.your_country));
            listImage.add(R.drawable.res_u1);
        }
        if(canada){
            listText1.add("Canada");
            listText2.add(getString(R.string.your_country));
            listImage.add(R.drawable.res_c1);
        }
        if(australia){
            listText1.add("Australia");
            listText2.add(getString(R.string.your_country));
            listImage.add(R.drawable.res_a1);
        }
        mith1 = sPref.getBoolean("mith1", false);
        mith2 = sPref.getBoolean("mith2", false);
        mith3 = sPref.getBoolean("mith3", false);
        if(mith1){
            listText1.add(getString(R.string.mithAtt1));
            listText2.add(getString(R.string.mithAtt));
            listImage.add(R.drawable.mith_res1);
        }
        if(mith2){
            listText1.add(getString(R.string.mithAtt2));
            listText2.add(getString(R.string.mithAtt));
            listImage.add(R.drawable.mith_res1);
        }
        if(mith3){
            listText1.add(getString(R.string.mithAtt3));
            listText2.add(getString(R.string.mithAtt));
            listImage.add(R.drawable.mith_res1);
        }
        mith21 = sPref.getBoolean("mith21", false);
        mith22 = sPref.getBoolean("mith22", false);
        mith23 = sPref.getBoolean("mith23", false);
        if(mith21){
            listText1.add(getString(R.string.mithAtt1));
            listText2.add(getString(R.string.mith2Att));
            listImage.add(R.drawable.mith2_res1);
        }
        if(mith22){
            listText1.add(getString(R.string.mithAtt2));
            listText2.add(getString(R.string.mith2Att));
            listImage.add(R.drawable.mith2_res1);
        }
        if(mith23){
            listText1.add(getString(R.string.mithAtt3));
            listText2.add(getString(R.string.mith2Att));
            listImage.add(R.drawable.mith2_res1);
        }
        gods1 = sPref.getBoolean("gods1", false);
        gods2 = sPref.getBoolean("gods2", false);
        gods3 = sPref.getBoolean("gods3", false);
        if(gods1){
            listText1.add(getString(R.string.godsAtt1));
            listText2.add(getString(R.string.godsAtt));
            listImage.add(R.drawable.gods_res);
        }
        if(gods2){
            listText1.add(getString(R.string.godsAtt2));
            listText2.add("Греческие боги");
            listImage.add(R.drawable.gods_res);
        }
        if(gods3){
            listText1.add(getString(R.string.godsAtt3));
            listText2.add("Греческие боги");
            listImage.add(R.drawable.gods_res);
        }
        famous1 = sPref.getBoolean("famous1", false);
        famous2 = sPref.getBoolean("famous2", false);
        famous3 = sPref.getBoolean("famous3", false);
        if(famous1){
            listText1.add(getString(R.string.famousAtt1));
            listText2.add(getString(R.string.famousAtt));
            listImage.add(R.drawable.famous_res1);
        }
        if(famous2){
            listText1.add(getString(R.string.famousAtt2));
            listText2.add(getString(R.string.famousAtt));
            listImage.add(R.drawable.famous_res1);
        }
        if(famous3){
            listText1.add(getString(R.string.famousAtt3));
            listText2.add(getString(R.string.famousAtt));
            listImage.add(R.drawable.famous_res1);
        }
        harry1 = sPref.getBoolean("harry1", false);
        harry2 = sPref.getBoolean("harry2", false);
        harry3 = sPref.getBoolean("harry3", false);
        if(harry1){
            listText1.add(getString(R.string.potterAtt1));
            listText2.add(getString(R.string.potterAtt));
            listImage.add(R.drawable.harry_back);
        }
        if(harry2){
            listText1.add(getString(R.string.potterAtt2));
            listText2.add(getString(R.string.potterAtt));
            listImage.add(R.drawable.harry_back);
        }
        if(harry3){
            listText1.add(getString(R.string.potterAtt3));
            listText2.add(getString(R.string.potterAtt));
            listImage.add(R.drawable.harry_back);
        }
        quotes1 = sPref.getBoolean("quotes1", false);
        quotes2 = sPref.getBoolean("quotes2", false);
        quotes3 = sPref.getBoolean("quotes3", false);
        if(quotes1){
            listText1.add(getString(R.string.quotesAtt1));
            listText2.add(getString(R.string.quotesAtt));
            listImage.add(R.drawable.quotes_res);
        }
        if(quotes2){
            listText1.add(getString(R.string.quotesAtt2));
            listText2.add(getString(R.string.quotesAtt));
            listImage.add(R.drawable.quotes_res);
        }
        if(quotes3){
            listText1.add(getString(R.string.quotesAtt3));
            listText2.add(getString(R.string.quotesAtt));
            listImage.add(R.drawable.quotes_res);
        }
        english1 = sPref.getBoolean("english1", false);
        english2 = sPref.getBoolean("english2", false);
        english3 = sPref.getBoolean("english3", false);
        if(english1){
            listText1.add("Bad");
            listText2.add("English");
            listImage.add(R.drawable.english_back);
        }
        if(english2){
            listText1.add("Good");
            listText2.add("English");
            listImage.add(R.drawable.english_back);
        }
        if(english3){
            listText1.add("Perfect");
            listText2.add("English");
            listImage.add(R.drawable.english_back);
        }
        laws1 = sPref.getBoolean("laws1", false);
        laws2 = sPref.getBoolean("laws2", false);
        laws3 = sPref.getBoolean("laws3", false);
        if(laws1){
            listText1.add(getString(R.string.lowsAtt1));
            listText2.add(getString(R.string.lowsAtt));
            listImage.add(R.drawable.the_laws_back);
        }
        if(laws2){
            listText1.add(getString(R.string.lowsAtt2));
            listText2.add(getString(R.string.lowsAtt));
            listImage.add(R.drawable.the_laws_back);
        }
        if(laws3){
            listText1.add(getString(R.string.lowsAtt3));
            listText2.add(getString(R.string.lowsAtt));
            listImage.add(R.drawable.the_laws_back);
        }
        opening1 = sPref.getBoolean("opening1", false);
        opening2 = sPref.getBoolean("opening2", false);
        opening3 = sPref.getBoolean("opening3", false);
        if(opening1){
            listText1.add(getString(R.string.bad));
            listText2.add(getString(R.string.opnAtt));
            listImage.add(R.drawable.opening_back);
        }
        if(opening2){
            listText1.add(getString(R.string.middleAtt));
            listText2.add(getString(R.string.opnAtt));
            listImage.add(R.drawable.opening_back);
        }
        if(opening3){
            listText1.add(getString(R.string.otlichno));
            listText2.add(getString(R.string.opnAtt));
            listImage.add(R.drawable.opening_back);
        }
        cats1 = sPref.getBoolean("cats1", false);
        cats2 = sPref.getBoolean("cats2", false);
        cats3 = sPref.getBoolean("cats3", false);
        if(cats1){
            listText1.add(getString(R.string.bad));
            listText2.add(getString(R.string.catsAtt));
            listImage.add(R.drawable.cats_back);
        }
        if(cats2){
            listText1.add(getString(R.string.middleAtt));
            listText2.add(getString(R.string.catsAtt));
            listImage.add(R.drawable.cats_back);
        }
        if(cats3){
            listText1.add(getString(R.string.otlichno));
            listText2.add(getString(R.string.catsAtt));
            listImage.add(R.drawable.cats_back);
        }
        kids1 = sPref.getBoolean("kids1", false);
        kids2 = sPref.getBoolean("kids2", false);
        kids3 = sPref.getBoolean("kids3", false);
        if(kids1){
            listText1.add(getString(R.string.bad));
            listText2.add(getString(R.string.kidsAtt));
            listImage.add(R.drawable.kids_back);
        }
        if(kids2){
            listText1.add(getString(R.string.middleAtt));
            listText2.add(getString(R.string.kidsAtt));
            listImage.add(R.drawable.kids_back);
        }
        if(kids3){
            listText1.add(getString(R.string.otlichno));
            listText2.add(getString(R.string.kidsAtt));
            listImage.add(R.drawable.kids_back);
        }
        big_size1 = sPref.getBoolean("big_size1", false);
        big_size2 = sPref.getBoolean("big_size2", false);
        big_size3 = sPref.getBoolean("big_size3", false);
        if(big_size1){
            listText1.add(getString(R.string.bad));
            listText2.add("Big Size");
            listImage.add(R.drawable.big_size_back);
        }
        if(big_size2){
            listText1.add(getString(R.string.middleAtt));
            listText2.add("Big Size");
            listImage.add(R.drawable.big_size_back);
        }
        if(big_size3){
            listText1.add(getString(R.string.otlichno));
            listText2.add("Big Size");
            listImage.add(R.drawable.big_size_back);
        }

        listView = findViewById(R.id.att_list);
        AttainmentActivity.Adapter adapter = new AttainmentActivity.Adapter(this, listText1, listText2, listImage);
        listView.setAdapter(adapter);
    }

    class Adapter extends ArrayAdapter<String>{
        Context context;
        ArrayList<String> listText1;
        ArrayList<String> listText2;
        ArrayList<Integer> listImage;
        Adapter (Context c, ArrayList<String> listText1, ArrayList<String> listText2, ArrayList<Integer> listImage){
            super(c, R.layout.row2, R.id.att_text1, listText1);
            this.context = c;
            this.listText1 = listText1;
            this.listText2 = listText2;
            this.listImage = listImage;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row2, parent, false);
            TextView text = row.findViewById(R.id.att_text1);
            text.setText(listText1.get(position));
            TextView text2 = row.findViewById(R.id.att_text2);
            text2.setText(listText2.get(position));
            ImageView image = row.findViewById(R.id.att_image);
            image.setImageResource(listImage.get(position));

            return row;
        }
    }
}
