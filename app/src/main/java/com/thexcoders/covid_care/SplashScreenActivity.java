package com.thexcoders.covid_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {


    private LinearLayout layout;
    private TextView txtLogo;
    private ImageView imageLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        layout = findViewById(R.id.layoutParent);
        imageLogo = (ImageView) layout.getChildAt(0);
        txtLogo = (TextView) layout.getChildAt(1);

        Animation zoomAnimation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.zoom_in_out);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(SplashScreenActivity.this, R.anim.fade_in);

        imageLogo.setAnimation(zoomAnimation);
        txtLogo.setAnimation(fadeInAnimation);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            overridePendingTransition(android.R.transition.explode, android.R.transition.explode);
                        }
                    }
                });
            }
        }).start();

    }
}