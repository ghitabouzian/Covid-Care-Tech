package com.thexcoders.covid_care;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

public class HelperClass {
    public static void listenForNavigation(Context context, Class<?> className, LinearLayout listener1){

        listener1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,className));
                ((Activity) context).overridePendingTransition(android.R.transition.explode, android.R.transition.explode);
            }
        });


        listener1.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,className));
                ((Activity) context).overridePendingTransition(android.R.transition.explode, android.R.transition.explode);
            }
        });

    }
}
