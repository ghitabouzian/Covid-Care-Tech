package com.thexcoders.covid_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thexcoders.covid_care.adaptes.PharmaAdapter;
import com.thexcoders.covid_care.cards.PharmaPos;

import java.util.ArrayList;
import java.util.List;

public class PharmaActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private LayoutManager layoutManager;
    private PharmaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharma);

        initViews();

    }

    private void initViews() {
        List<PharmaPos> list = new ArrayList<>();

        PharmaPos pharmaPos = new PharmaPos("Pharmacy Sample",
                "1 kilometer away",
                "95 Shrader St.  - Pharmacy and doctor’s office",
                "4.9",
                "12",
                "Saturday 8am-2pm",
                "Closed Sunday",
                Color.rgb(255, 168, 167));
        list.add(pharmaPos);
        pharmaPos = new PharmaPos("Pharmacy Sample 2",
                "1.2 kilometer away",
                "5 Anass St.  - Pharmaceutical services",
                "4",
                "2",
                "Saturday 10am-7pm",
                "Sunday 2pm - 10 pm",
                Color.rgb(221, 243, 255));
        list.add(pharmaPos);
        pharmaPos = new PharmaPos("Pharmacy Sample 3",
                "1.6 kilometer away",
                "90 Ghita St.  - Pharmacy and doctor’s office",
                "5",
                "1",
                "Saturday 8am-2pm",
                "Sunday 1pm - 8 pm",
                Color.rgb(248, 247, 247));
        list.add(pharmaPos);
        pharmaPos = new PharmaPos("Pharmacy Sample 4",
                "2 kilometer away",
                "Aileen St.  - Pharmacy and doctor’s office",
                "4.7",
                "11",
                "Saturday 8am-2pm",
                "Closed Sunday",
                Color.rgb(248, 179, 44));
        list.add(pharmaPos);



        adapter = new PharmaAdapter(list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);


        LinearLayout activeLayout;

        LinearLayout btnMessages;
        LinearLayout btnHome;
        LinearLayout btnTherapists;

        activeLayout = findViewById(R.id.btnPharma);
        btnMessages = findViewById(R.id.btnMessages);
        btnHome = findViewById(R.id.btnHome);
        btnTherapists = findViewById(R.id.btnTherapists);

        HelperClass.listenForNavigation(this, MainActivity.class, btnHome);
        HelperClass.listenForNavigation(this, MessagesActivity.class, btnMessages);
        HelperClass.listenForNavigation(this, TherapistActvity.class, btnTherapists);

        ((ImageButton) activeLayout.getChildAt(0)).setImageResource(R.drawable.ic_pharma_active);
        ((TextView) activeLayout.getChildAt(1)).setTextAppearance(this, R.style.BoldText);
        ((TextView) activeLayout.getChildAt(1)).setTextColor(Color.parseColor("#22D7FF"));
    }
}