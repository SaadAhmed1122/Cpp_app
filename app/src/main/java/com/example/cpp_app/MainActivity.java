package com.example.cpp_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;
    private InterstitialAd mInterstitialAd;

    private AdView adView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Instatial Ads
       finalshowad();

//        End OVer here

        adView = (AdView) findViewById(R.id.ad_view);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        // add data for displaying in expandable list view
        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(MainActivity.this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
       // expandAll();
//Collapse All
        collapseAll();
        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                finalshowad();
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
//                  Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
//                        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                  String aa=headerInfo.getName()+"."+detailInfo.getName();

                if(aa.equals("Course Introduction & Revising Pre-Requisities.Slides")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Course intro_pre-requisites.pdf");
                    startActivity(ii);
                } else if(aa.equals("Octal to Binary & Binary to Octal.Slides")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Octal To Binary & Binary To Octal.pdf");
                    startActivity(ii);
                }
                else if(aa.equals("Hex to Binary & Binary to Hex.Slides")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Hex To Binary & Binary To Hex.pdf");
                    startActivity(ii);
                }else if(aa.equals("Hex to Binary & Binary to Hex.Assignment")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Assignment one.pdf");
                    startActivity(ii);
                }else if(aa.equals("Octal to Hex & Hex to Octal Conversion.Slides")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Octal To Hex & Hexadecimal To Octal.pdf");
                    startActivity(ii);
                }else if(aa.equals("Decimal to Other Bases.Assignment")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Assignment two.pdf");
                    startActivity(ii);
                }else if(aa.equals("Decimal to Other Bases.Slides")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Decimal To Other Bases.pdf");
                    startActivity(ii);
                }
                else if(aa.equals("Other Bases To Decimal.Assignment")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Assignment three.pdf");
                    startActivity(ii);
                }
               else if(aa.equals("Other Bases To Decimal.Slides")){
                    Intent ii = new Intent(MainActivity.this,Showpdf.class);
                    ii.putExtra("data","Other Bases To Decimal.pdf");
                    startActivity(ii);
                }

                else {

                    Intent ss = new Intent(MainActivity.this, Youtube_act.class);
                    ss.putExtra("data", detailInfo.getName());
                    startActivity(ss);
                }
                //display it or do something with it
              //  Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
                //        + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                Log.d("TAG",detailInfo.getName());

                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it

//                Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
//                        Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }

    private void finalshowad() {
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                createpersolizead();
            }
        });
        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }

    }

    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.expandGroup(i);
        }
    }
    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.collapseGroup(i);
        }
    }
    //load some initial data into out list
    private void loadData() {

        addProduct("Course Introduction & Revising Pre-Requisities", "Short Promo");
        addProduct("Course Introduction & Revising Pre-Requisities", "Course Introduction");
        addProduct("Course Introduction & Revising Pre-Requisities", "Units of Data");
        addProduct("Course Introduction & Revising Pre-Requisities", "Types of Number System");
        addProduct("Course Introduction & Revising Pre-Requisities", "Slides");


        addProduct("Conversions", "Conversion RoadMap");

        addProduct("Octal to Binary & Binary to Octal","Table Making for Octal to Binary And Binary to Octal Conversion");
        addProduct("Octal to Binary & Binary to Octal","Octal to Binary(Whole)");
        addProduct("Octal to Binary & Binary to Octal","Octal to Binary(Floating Point)");
        addProduct("Octal to Binary & Binary to Octal","Binary to Octal(Whole)");
        addProduct("Octal to Binary & Binary to Octal","Binary to Octal(Floating Point)");
        addProduct("Octal to Binary & Binary to Octal","Slides");


        addProduct("Hex to Binary & Binary to Hex","Table Making");
        addProduct("Hex to Binary & Binary to Hex","Hex to Binary(Whole Number)");
        addProduct("Hex to Binary & Binary to Hex","Hex to Binary(Floats)");
        addProduct("Hex to Binary & Binary to Hex","Binary to Hex(Whole)");
        addProduct("Hex to Binary & Binary to Hex","Binary to Hex(Floats)");
        addProduct("Hex to Binary & Binary to Hex","Slides");
        addProduct("Hex to Binary & Binary to Hex","Assignment");
        addProduct("Hex to Binary & Binary to Hex","Solution #1");

//        Updated

        addProduct("Octal to Hex & Hex to Octal Conversion","Octal to Hex & Hex to Octal Conversion Introduction");
        addProduct("Octal to Hex & Hex to Octal Conversion","Octal to Hex");
        addProduct("Octal to Hex & Hex to Octal Conversion","Hex to Octal");
        addProduct("Octal to Hex & Hex to Octal Conversion","Slides");

        addProduct("Decimal to Other Bases","Decimal to Other Bases Introuduction");
        addProduct("Decimal to Other Bases","Decimal to Binary(Whole)");
        addProduct("Decimal to Other Bases","Decimal to Octal(Whole)");
        addProduct("Decimal to Other Bases","Decimal to Hex(Whole)");
        addProduct("Decimal to Other Bases","Decimal to Other(Float)");
        addProduct("Decimal to Other Bases","Decimal to Binary(Float)");
        addProduct("Decimal to Other Bases","Decimal to Octal(Float)");
        addProduct("Decimal to Other Bases","Decimal to Hex(Float)");
        addProduct("Decimal to Other Bases","Decimal to Binary(Combined)");
        addProduct("Decimal to Other Bases","Decimal to Octal(Combined)");
        addProduct("Decimal to Other Bases","Decimal to Hex(Combined)");
        addProduct("Decimal to Other Bases","Slides");
        addProduct("Decimal to Other Bases","Assignment");
        addProduct("Decimal to Other Bases","Solution #2");


        addProduct("Other Bases To Decimal", "Other Bases To Decimal Introduction");
        addProduct("Other Bases To Decimal", "Binary to Decimal(Combined)");
        addProduct("Other Bases To Decimal", "Octal to Decimal(Combined)");
        addProduct("Other Bases To Decimal", "Hex to Decimal(Combined)");
        addProduct("Other Bases To Decimal", "Slides");
        addProduct("Other Bases To Decimal", "Assignment");
        addProduct("Other Bases To Decimal", "Solution #3");

        addProduct("Course Summary", "Course Summary");

        addProduct("Number Conversion All-In-One-Video", "Number Conversion All-In-One-Video");
    }


    //here we maintain our products in various departments
    private int addProduct(String department, String product) {

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }


    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
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
                        Intent mainIntent = new Intent(MainActivity.this,MainActivity.class);
                        MainActivity.this.startActivity(mainIntent);
                        //Splashscreen.this.finish();
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
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}