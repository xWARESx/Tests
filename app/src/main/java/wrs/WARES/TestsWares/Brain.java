package wrs.WARES.TestsWares;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.WARES.tests.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Brain extends AppCompatActivity {
    ListView listView;
    String[] namesOfTests;
    String[] namesOfTests2;
    boolean checked1 = KosmosTest.checked;
    boolean checked11;
    boolean checked2 = SlangTest.checked;
    boolean checked22;
    boolean checked3 = ClassicTest.checked;
    boolean checked33;
    boolean checked4 = RussianTest.checked;
    boolean checked44;
    boolean checked5 = WildNatureTest.checked;
    boolean checked55;
    boolean checked6 = MathTest.checked;
    boolean checked66;
    boolean checked7 = PhysicsTest.checked;
    boolean checked77;
    boolean checked8 = EvolutionTest.checked;
    boolean checked88;
    boolean checked9 = OrganismTest.checked;
    boolean checked99;
    boolean checked10 = MithTest.checked;
    boolean checked1010;
    boolean checked111 = Mith2Test.checked;
    boolean checked1111;
    boolean checked12 = GodsTest.checked;
    boolean checked1212;
    boolean checked13 = EnglishTest.checked;
    boolean checked1313;
    boolean checked14 = OpeningTest.checked;
    boolean checked1414;
    boolean checked15 = CatsTest.checked;
    boolean checked1515;
    boolean checked16 = KidsTest.checked;
    boolean checked1616;

    boolean unblock = Donate.unblock;
    boolean unblock1;
    boolean unblock2;


    public InterstitialAd mInterstitialAd;
    private static final String TAG = "WHAT";


    String check="test passed";
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain);


        namesOfTests = getResources().getStringArray(R.array.namesBrain);
        namesOfTests2 = getResources().getStringArray(R.array.namesBrain2);

        sPref = getPreferences(MODE_PRIVATE);
        //sPref.edit().clear().apply();
        unblock1 = sPref.getBoolean("unblock", false);
        if(unblock1) unblock2 = true;


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        loadAd();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }
        //sPref = getPreferences(MODE_PRIVATE);
        //sPref.edit().clear().apply();
        checked11 = sPref.getBoolean("тест пройден", false);
        if(checked11) namesOfTests2[0] = check;
        checked22 = sPref.getBoolean("сленг пройден", false);
        if(checked22) namesOfTests2[1] = check;
        checked33 = sPref.getBoolean("классика пройдена", false);
        if(checked33) namesOfTests2[2] = check;
        checked44 = sPref.getBoolean("русский пройден", false);
        if(checked44) namesOfTests2[3] = check;
        checked55 = sPref.getBoolean("дикая природа пройдена", false);
        if(checked55) namesOfTests2[4] = check;
        checked66 = sPref.getBoolean("матеша пройдена", false);
        if(checked66) namesOfTests2[5] = check;
        checked77 = sPref.getBoolean("физика пройдена", false);
        if(checked77) namesOfTests2[6] = check;
        checked88 = sPref.getBoolean("эволюция пройдена", false);
        if(checked88) namesOfTests2[7] = check;
        checked99 = sPref.getBoolean("организм пройден", false);
        if(checked99) namesOfTests2[8] = check;
        checked1010 = sPref.getBoolean("мифы1 пройдены", false);
        if(checked1010) namesOfTests2[9] = check;
        checked1111 = sPref.getBoolean("мифы2 пройдены", false);
        if(checked1111) namesOfTests2[10] = check;
        checked1212 = sPref.getBoolean("боги пройдены", false);
        if(checked1212) namesOfTests2[11] = check;
        checked1313 = sPref.getBoolean("английский пройден", false);
        if(checked1313) namesOfTests2[12] = check;
        checked1414 = sPref.getBoolean("открытия пройдены", false);
        if(checked1414) namesOfTests2[13] = check;
        checked1515 = sPref.getBoolean("кошки пройдены", false);
        if(checked1515) namesOfTests2[14] = check;
        checked1616 = sPref.getBoolean("дети пройдены", false);
        if(checked1616) namesOfTests2[15] = check;
        listView = findViewById(R.id.brain);
        Adapter adapter = new Adapter(this, namesOfTests, namesOfTests2);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent = new Intent(parent.getContext(), Kosmos.class);
                        startActivity(intent);}
                        return;
                    case 1:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent1 = new Intent(parent.getContext(), Slang.class);
                        startActivity(intent1);}
                        return;
                    case 2:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent2 = new Intent(parent.getContext(), Classic.class);
                        startActivity(intent2);}
                        return;
                    case 3:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent3 = new Intent(parent.getContext(), Russian.class);
                        startActivity(intent3);}
                        return;
                    case 4:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent4 = new Intent(parent.getContext(), WildNature.class);
                        startActivity(intent4);}
                        return;
                    case 5:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent5 = new Intent(parent.getContext(), Math.class);
                        startActivity(intent5);}
                        return;
                    case 6:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent6 = new Intent(parent.getContext(), Physics.class);
                        startActivity(intent6);}
                        return;
                    case 7:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent7 = new Intent(parent.getContext(), Evolution.class);
                        startActivity(intent7);}
                        return;
                    case 8:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent8 = new Intent(parent.getContext(), Organism.class);
                        startActivity(intent8);}
                        return;
                    case 9:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent9 = new Intent(parent.getContext(), Mith.class);
                        startActivity(intent9);}
                        return;
                    case 10:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent10 = new Intent(parent.getContext(), Mith2.class);
                        startActivity(intent10);}
                        return;
                    case 11:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent11 = new Intent(parent.getContext(), Gods.class);
                        startActivity(intent11);}
                        return;
                    case 12:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent12 = new Intent(parent.getContext(), English.class);
                        startActivity(intent12);}
                        return;
                    case 13:
                        if (mInterstitialAd != null&&!unblock2) {
                            mInterstitialAd.show(Brain.this);
                            Toast.makeText(Brain.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent13 = new Intent(parent.getContext(), Opening.class);
                        startActivity(intent13);}
                        return;
                    case 14:
                        if (!unblock2) {
                            Toast.makeText(Brain.this, getString(R.string.buyExpl), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent14 = new Intent(parent.getContext(), Cats.class);
                        startActivity(intent14);}
                        return;
                    case 15:
                        if (!unblock2) {
                            Toast.makeText(Brain.this, getString(R.string.buyExpl), Toast.LENGTH_LONG).show();
                        } else {
                        Intent intent15 = new Intent(parent.getContext(), Kids.class);
                        startActivity(intent15);}
                    default:
                }
            }
        });
    }

    public void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-6767263794498743/2969444277", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.i(TAG, "onAdLoaded");
                interstitialAd.setFullScreenContentCallback(
                        new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when fullscreen content is dismissed.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                Brain.this.mInterstitialAd = null;
                                Log.d("TAG", "The ad was dismissed.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                Brain.this.mInterstitialAd = null;
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when fullscreen content is shown.
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        if(unblock){
            ed.putBoolean("unblock", true);
            ed.apply();
        }
        if(checked1){
            ed.putBoolean("тест пройден", true);
            ed.apply();
        }
        if(checked2){
            ed.putBoolean("сленг пройден", true);
            ed.apply();
        }
        if(checked3){
            ed.putBoolean("классика пройдена", true);
            ed.apply();
        }
        if(checked4){
            ed.putBoolean("русский пройден", true);
            ed.apply();
        }
        if(checked5){
            ed.putBoolean("дикая природа пройдена", true);
            ed.apply();
        }
        if(checked6){
            ed.putBoolean("матеша пройдена", true);
            ed.apply();
        }
        if(checked7){
            ed.putBoolean("физика пройдена", true);
            ed.apply();
        }
        if(checked8){
            ed.putBoolean("эволюция пройдена", true);
            ed.apply();
        }
        if(checked9){
            ed.putBoolean("организм пройден", true);
            ed.apply();
        }
        if(checked10){
            ed.putBoolean("мифы1 пройдены", true);
            ed.apply();
        }
        if(checked111){
            ed.putBoolean("мифы2 пройдены", true);
            ed.apply();
        }
        if(checked12){
            ed.putBoolean("боги пройдены", true);
            ed.apply();
        }
        if(checked13){
            ed.putBoolean("английский пройден", true);
            ed.apply();
        }
        if(checked14){
            ed.putBoolean("открытия пройдены", true);
            ed.apply();
        }
        if(checked15){
            ed.putBoolean("кошки пройдены", true);
            ed.apply();
        }
        if(checked16){
            ed.putBoolean("дети пройдены", true);
            ed.apply();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_explanation:
                if(unblock2){
                Intent intent = new Intent(this, ExplanationActivity.class);
                startActivity(intent);}
                else {
                    AlertDialog.Builder b1 = new AlertDialog.Builder(this);
                    b1.setTitle(getString(R.string.info_unblock)).setCancelable(false).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog al1 = b1.create();
                    al1.show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    class Adapter extends ArrayAdapter<String> {
        Context context;
        String namesOfTests[];
        String namesOfTests2[];

        Adapter(Context c, String names[], String names2[]) {
            super(c, R.layout.row, R.id.text_view, names);
            this.context = c;
            this.namesOfTests = names;
            this.namesOfTests2 = names2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView text = row.findViewById(R.id.text_view);
            text.setText(namesOfTests[position]);
            TextView text2 = row.findViewById(R.id.text_view2);
            text2.setText(namesOfTests2[position]);
            if(text2.getText()=="test passed") {
                text2.setTextColor(Color.RED);
                text2.setTextSize(16);
            }

            return row;
        }
    }
}
