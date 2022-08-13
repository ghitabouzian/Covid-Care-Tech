package com.thexcoders.covid_care;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TherapistActvity extends AppCompatActivity {

    private LinearLayout activeLayout;

    private LinearLayout btnMessages;
    private LinearLayout btnHome;
    private LinearLayout btnPharma;
    private LinearLayout btnTherapists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_actvity);

        LinearLayout activeLayout;

        LinearLayout btnMessages;
        LinearLayout btnHome;
        LinearLayout btnPharma;
        LinearLayout btnTherapists;

        activeLayout = findViewById(R.id.btnTherapists);
        btnMessages = findViewById(R.id.btnMessages);
        btnHome = findViewById(R.id.btnHome);
        btnPharma = findViewById(R.id.btnPharma);

        HelperClass.listenForNavigation(this, MainActivity.class, btnHome);
        HelperClass.listenForNavigation(this, MessagesActivity.class, btnMessages);
        HelperClass.listenForNavigation(this, PharmaActivity.class, btnPharma);

        ((ImageButton) activeLayout.getChildAt(0)).setImageResource(R.drawable.ic_smile_active);
        ((TextView) activeLayout.getChildAt(1)).setTextAppearance(this, R.style.BoldText);
        ((TextView) activeLayout.getChildAt(1)).setTextColor(Color.parseColor("#22D7FF"));


    }
}