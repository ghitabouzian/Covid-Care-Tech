package com.thexcoders.covid_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thexcoders.covid_care.adaptes.HomePostAdapter;
import com.thexcoders.covid_care.cards.HomePost;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private HomePostAdapter homePostAdapter;
    private RecyclerView recyclerView;
    private List<HomePost> homePostList;

    private LinearLayout btnMessages;
    private LinearLayout activeLayout;
    private LinearLayout btnPharma;
    private LinearLayout btnTherapists;

    private ImageButton btnHomeContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();


        initAndFillList();

        setupRecycler();

    }

    private void initAndFillList() {
        homePostList = new ArrayList<>();


        List<HomePost.Tag> tagList = new ArrayList<>();

        HomePost.Tag tag = new HomePost.Tag();
        tag.setContent("Welcome");
        tag.setBackgroundColor(Color.parseColor("#AEE7FF"));
        tagList.add(tag);

        HomePost hp = new HomePost(Date.valueOf("2021-07-31"),
                "Hi, welcome to COVID Care \uD83D\uDC4B",
                "Welcome to the COVID Care community—we’re glad you’re here. This is a safe space for everyone, whether you have or don’t have COVID. If you violate our rules, you will be permanently banned.",
                12, 4, tagList, true);

        homePostList.add(hp);

        tagList = new ArrayList<>();
        tag = new HomePost.Tag();
        tag.setContent("Therapy");
        tag.setBackgroundColor(Color.parseColor("#FCC7AC"));
        tagList.add(tag);

        tag = new HomePost.Tag();
        tag.setContent("Loved Ones");
        tag.setBackgroundColor(Color.rgb(255, 236, 254));
        tagList.add(tag);


        hp = new HomePost(Date.valueOf("2021-07-26"),
                "My grandma is 70 years old, has cancer, and now COVID.",
                "I’m looking for someone to talk to in a similar situtation (you don’t need to be a therapist). How do you cope and stay hopeful? ",
                300, 50, tagList);

        homePostList.add(hp);


        tagList = new ArrayList<>();
        tag = new HomePost.Tag();
        tag.setContent("Welcome");
        tag.setBackgroundColor(Color.rgb(174, 231, 255));
        tagList.add(tag);

        hp = new HomePost(Date.valueOf("2021-07-15"),
                "I am a child therapist and want to give out free counseling sessions",
                "Disclaimer- this is not affiliated with the app. If you think you need this- please reach out to me letting me know your age, situation, and availability.",
                312, 6, new ArrayList<>());

        homePostList.add(hp);

        hp = new HomePost(Date.valueOf("2021-07-15"),
                "I am a child therapist and want to give out free counseling sessions",
                "Disclaimer- this is not affiliated with the app. If you think you need this- please reach out to me letting me know your age, situation, and availability.",
                312, 6, new ArrayList<>());

        homePostList.add(hp);

        hp = new HomePost(Date.valueOf("2021-07-15"),
                "I am a child therapist and want to give out free counseling sessions",
                "Disclaimer- this is not affiliated with the app. If you think you need this- please reach out to me letting me know your age, situation, and availability.",
                312, 6, new ArrayList<>());

        homePostList.add(hp);

        hp = new HomePost(Date.valueOf("2021-07-15"),
                "I am a child therapist and want to give out free counseling sessions",
                "Disclaimer- this is not affiliated with the app. If you think you need this- please reach out to me letting me know your age, situation, and availability.",
                312, 6, new ArrayList<>());

        homePostList.add(hp);
    }

    private void findViewsByIds() {
        recyclerView = findViewById(R.id.recyclerView);


        LinearLayout activeLayout;

        LinearLayout btnMessages;
        LinearLayout btnHome;
        LinearLayout btnPharma;
        LinearLayout btnTherapists;

        activeLayout = findViewById(R.id.btnHome);
        btnMessages = findViewById(R.id.btnMessages);
        btnPharma = findViewById(R.id.btnPharma);
        btnTherapists = findViewById(R.id.btnTherapists);

        HelperClass.listenForNavigation(this, MessagesActivity.class, btnMessages);
        HelperClass.listenForNavigation(this, PharmaActivity.class, btnPharma);
        HelperClass.listenForNavigation(this, TherapistActvity.class, btnTherapists);

        ((ImageButton) activeLayout.getChildAt(0)).setImageResource(R.drawable.ic_home_active);
        ((TextView) activeLayout.getChildAt(1)).setTextAppearance(this, R.style.BoldText);
        ((TextView) activeLayout.getChildAt(1)).setTextColor(Color.parseColor("#22D7FF"));



        Animation animUpDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.up_down);
        animUpDown.setRepeatMode(Animation.INFINITE);
        animUpDown.setRepeatCount(Animation.INFINITE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            findViewById(R.id.image).startAnimation(animUpDown);

                        }
                    });
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();


    }

    private void setupRecycler() {
        layoutManager = new LinearLayoutManager(MainActivity.this);

        homePostAdapter = new HomePostAdapter(homePostList, getApplicationContext());
        recyclerView.setAdapter(homePostAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }
}