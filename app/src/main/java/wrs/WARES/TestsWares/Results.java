package wrs.WARES.TestsWares;

import android.content.Intent;

import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

public class Results extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    int image;
    String text;

    public InterstitialAd mInterstitialAd;
    private static final String TAG = "WHAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

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
        image = (int) getIntent().getSerializableExtra("image");
        text = (String) getIntent().getSerializableExtra("text");
        imageView = (ImageView) findViewById(R.id.resultsImage);
        textView = (TextView) findViewById(R.id.resultsText);
        imageView.setImageResource(image);
        textView.setText(text);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setBackgroundResource(R.drawable.result_form_toolbar);
        }
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
                                Results.this.mInterstitialAd = null;
                                Log.d("TAG", "The ad was dismissed.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                Results.this.mInterstitialAd = null;
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



    public void toTests(View view){
        if (mInterstitialAd != null) {
            mInterstitialAd.show(Results.this);
            Toast.makeText(Results.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
        } else {
        Intent intent = new Intent(this, Pciho.class);
        startActivity(intent);}
    }

    public void openAtt(View view){
        if (mInterstitialAd != null) {
            mInterstitialAd.show(Results.this);
            Toast.makeText(Results.this, getString(R.string.watchAdd), Toast.LENGTH_LONG).show();
        } else {
        Intent intent = new Intent(this, AttainmentActivity.class);
        startActivity(intent);}
    }
}
