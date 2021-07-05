package com.example.cpp_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class Youtube_act extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_act);
        data = getIntent().getExtras().getString("data");

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtubeplayer);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            if(data.equals("Short Promo")){
            player.cueVideo("wWmzjzVnzvQ"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                 }
            else if(data.equals("Course Introduction")){
            player.cueVideo("VClkY_vKKWc"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                 }
            else if(data.equals("Units of Data")){
            player.cueVideo("vODtt4IR14Y"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                 }
            else if(data.equals("Types of Number System")){
            player.cueVideo("j1OU2Pi7R44"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                 }
            else if(data.equals("Conversion RoadMap")){
            player.cueVideo("FqH9Rfs_PiY"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                 }
             else if(data.equals("Table Making")) {
                player.cueVideo("zTN1eSJLrBM"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }
             else if(data.equals("Hex to Binary(Whole Number)")){
                 player.cueVideo("p6LAjJuAlFA"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Hex to Binary(Floats)")){
                 player.cueVideo("ah-RxcWwq2c"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Binary to Hex(Whole)")){
                 player.cueVideo("1k2u5NUee9s"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Binary to Hex(Floats)")){
                 player.cueVideo("0_9BlcFa6OY"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Solution #1")){
                 player.cueVideo("KFBtYk1-rqs"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Octal to Hex & Hex to Octal Conversion Introduction")){
                 player.cueVideo("ccFzT1IBRaY"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Octal to Hex")){
                 player.cueVideo("4_dFRcbCISo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
             else if(data.equals("Hex to Octal")){
                 player.cueVideo("xQd6B2DbAzQ"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }else if(data.equals("Decimal to Other Bases Introuduction")){
                 player.cueVideo("uWdDAQsvNMc"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
             }
            else if(data.equals("Decimal to Binary(Whole)")){
                player.cueVideo("q52vAVydUjk"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }
            else if(data.equals("Decimal to Octal(Whole)")){
                player.cueVideo("fea7VDhepuc"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }
            else if(data.equals("Decimal to Hex(Whole)")){
                player.cueVideo("Il6TOnyYJpE"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }
            else if(data.equals("Decimal to Other(Float)")){
                player.cueVideo("4pSIpxY3emE"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Decimal to Binary(Float)")){
                player.cueVideo("pR3jR3Co5Ew"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Decimal to Octal(Float)")){
                player.cueVideo("yczPgbDcEEY"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Decimal to Hex(Float)")){
                player.cueVideo("rlsXhNvL5XE"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Decimal to Binary(Combined)")){
                player.cueVideo("9p_lghpLRaU"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Decimal to Octal(Combined)")){
                player.cueVideo("OgiWzIxYE0c"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Decimal to Hex(Combined)")){
                player.cueVideo("RPqE1HJIa80"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Solution #2")){
                player.cueVideo("YfWL8oBC-78"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Other Bases To Decimal Introduction")){
                player.cueVideo("WB825UoHJds"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Binary to Decimal(Combined)")){
                player.cueVideo("gOtp0efqqSw"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Octal to Decimal(Combined)")){
                player.cueVideo("X5idk1FcWwY"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Hex to Decimal(Combined)")){
                player.cueVideo("vG8MdVoGnUE"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Solution #3")){
                player.cueVideo("CdPdHxh1WiI"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Course Summary")){
                player.cueVideo("y8alGtp_oIo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Number Conversion All-In-One-Video")){
                player.cueVideo("j_rvgsDMjkw"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Table Making for Octal to Binary And Binary to Octal Conversion")){
                player.cueVideo("zTN1eSJLrBM"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Octal to Binary(Whole)")){
                player.cueVideo("aEb8EYR2Dnw"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Octal to Binary(Floating Point)")){
                player.cueVideo("VcNVxtwfWf4"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Binary to Octal(Whole)")){
                player.cueVideo("35wXZvqViFs"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }else if(data.equals("Binary to Octal(Floating Point)")){
                player.cueVideo("918mjP2az9U"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
            }


        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
}