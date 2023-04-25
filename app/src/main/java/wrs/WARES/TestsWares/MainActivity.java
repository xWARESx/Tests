package wrs.WARES.TestsWares;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.WARES.tests.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    public static String psycho;
    public static String brain;
    public static String pciho;
    public static String explanation;
    public static String explanationBuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        psycho = getString(R.string.psycho);
        brain = getString(R.string.brain);
        pciho = getString(R.string.pciho);
        explanation = getString(R.string.explanation);
        explanationBuy = getString(R.string.expl);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        Context context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] names = new String[Categories.cats.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Categories.cats[i].getName();
        }
        int[] images = new int[Categories.cats.length];
        for (int i = 0; i < names.length; i++) {
            images[i] = Categories.cats[i].getImageId();
        }


        final Adapter adapter = new Adapter(names, images, context);
        recyclerView.setAdapter(adapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }

    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_attainment:
                    Intent intent = new Intent(this, AttainmentActivity.class);
                    startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
