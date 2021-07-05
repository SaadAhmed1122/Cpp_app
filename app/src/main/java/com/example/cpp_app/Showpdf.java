package com.example.cpp_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Showpdf extends AppCompatActivity {
    TextView heading;
    PDFView pdfView;
    String data;
    private AdView adView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpdf);
        heading = findViewById(R.id.toolbartext);
        pdfView = findViewById(R.id.pdfviewer);
        adView = (AdView) findViewById(R.id.ad_view2);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        data = getIntent().getExtras().getString("data");
        if(data.equals("Course intro_pre-requisites.pdf")){
            heading.setText("Course Introduction");
        }
        else if(data.equals("Octal To Binary & Binary To Octal.pdf")){
            heading.setText("Octal To Binary Conversion");
        }
        else if(data.equals("Assignment one.pdf")){
            heading.setText("Assignment Ooe");
        }
        else if(data.equals("Hex To Binary & Binary To Hex.pdf")){
            heading.setText("Hex to Binary Conversion");
        }
        else if(data.equals("Assignment two.pdf")){
            heading.setText("Assignment Two");
        }
        else if(data.equals("Octal To Hex & Hexadecimal To Octal.pdf")){
            heading.setText("Octal To Hex Conversion");
        }
        else if(data.equals("Assignment three.pdf")){
            heading.setText("Assignment Three");
        }
        else if(data.equals("Decimal To Other Bases.pdf")){
            heading.setText("Decimal To Other Bases");
        }
        else if(data.equals("Other Bases To Decimal.pdf")){
            heading.setText("Other Bases To Decimal");
        }

        showpdf(data);
    }

    private void showpdf(String data) {
        pdfView.fromAsset(data).load();
    }

    public void backcall(View view) {
        onBackPressed();
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
}