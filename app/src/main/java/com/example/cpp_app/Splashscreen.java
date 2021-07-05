package com.example.cpp_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Splashscreen extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    private InterstitialAd mInterstitialAd;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                createpersolizead();
            }
        });



        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(Splashscreen.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    Intent mainIntent = new Intent(Splashscreen.this,MainActivity.class);
                    Splashscreen.this.startActivity(mainIntent);
                    Splashscreen.this.finish();
                }
//                Intent mainIntent = new Intent(Splashscreen.this,MainActivity.class);
//                Splashscreen.this.startActivity(mainIntent);
//                Splashscreen.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    public void createpersolizead(){
        AdRequest adRequest = new AdRequest.Builder().build();
        intesads(adRequest);
    }
    public void intesads(AdRequest adRequest){

        InterstitialAd.load(this,String.valueOf(R.string.interstitial_ad_unit_id), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        Log.d("TAG", "The ad was dismissed.");
//                        createpersolizead();
                        Intent mainIntent = new Intent(Splashscreen.this,MainActivity.class);
                        Splashscreen.this.startActivity(mainIntent);
                        Splashscreen.this.finish();
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        Log.d("TAG", "The ad failed to show.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                mInterstitialAd = null;
            }
        });
    }

}