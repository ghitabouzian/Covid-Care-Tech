package com.thexcoders.covid_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thexcoders.covid_care.adaptes.ChatAdapter;
import com.thexcoders.covid_care.cards.RecentChat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MessagesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ChatAdapter chatAdapter;
    LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        initViews();

        fillMessages();
    }

    private void fillMessages() {
        List<RecentChat> list = new ArrayList<>();
        RecentChat recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to their post: University is so hard",
                "I feel the exact same way! Math is soo hard",
                true,
                false
        );

        list.add(recentChat);


        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to their post: Who else hates school",
                "I go to school in Canada, not Morocco but we have a lot of similarities. ",
                true,
                false
        );

        list.add(recentChat);


        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Support Session",
                "Hello! Are you available to call tomorrow night on Zoom? I can paste the link here.",
                false,
                true,
                2
        );

        list.add(recentChat);

        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to your post: Easiest cat...",
                "Okay, Thank you!",
                false,
                false
        );

        list.add(recentChat);

        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to your post: Easiest cat...",
                "I have a dog.",
                false,
                false
        );

        list.add(recentChat);

        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to your post: Easiest cat...",
                "Okay, Thank you!",
                false,
                false
        );

        list.add(recentChat);

        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to your post: Easiest cat...",
                "I have a dog.",
                false,
                false
        );

        list.add(recentChat);

        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to your post: Easiest cat...",
                "Okay, Thank you!",
                false,
                false
        );

        list.add(recentChat);

        recentChat = new RecentChat(Date.valueOf("2021-07-30"),
                "Replied to your post: Easiest cat...",
                "I have a dog.",
                false,
                false
        );

        list.add(recentChat);

        chatAdapter = new ChatAdapter(list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(chatAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayout activeLayout;

        LinearLayout btnHome;
        LinearLayout btnPharma;
        LinearLayout btnTherapists;

        activeLayout = findViewById(R.id.btnMessages);
        btnHome = findViewById(R.id.btnHome);
        btnPharma = findViewById(R.id.btnPharma);
        btnTherapists = findViewById(R.id.btnTherapists);

        HelperClass.listenForNavigation(this, MainActivity.class, btnHome);
        HelperClass.listenForNavigation(this, PharmaActivity.class, btnPharma);
        HelperClass.listenForNavigation(this, TherapistActvity.class, btnTherapists);

        ((ImageButton) activeLayout.getChildAt(0)).setImageResource(R.drawable.ic_messages_active);
        ((TextView) activeLayout.getChildAt(1)).setTextAppearance(this, R.style.BoldText);
        ((TextView) activeLayout.getChildAt(1)).setTextColor(Color.parseColor("#22D7FF"));

    }


}