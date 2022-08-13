package com.thexcoders.covid_care.adaptes;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thexcoders.covid_care.R;
import com.thexcoders.covid_care.cards.PharmaPos;

import java.util.List;

public class PharmaAdapter extends RecyclerView.Adapter<PharmaAdapter.ViewHolder> {
    private final List<PharmaPos> list;

    public PharmaAdapter(List<PharmaPos> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pharma_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PharmaPos pharma = list.get(position);
        holder.distance.setText(pharma.getDistance());
        holder.location.setText(pharma.getLocation());
        holder.saturday.setText(pharma.getSaturday());
        holder.sunday.setText(pharma.getSunday());
        holder.name.setText(pharma.getName());
        holder.starsAvg.setText(pharma.getStarsAvg());
        holder.starsNmber.setText(pharma.getStarsCount());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.color.setBackgroundTintList(ColorStateList.valueOf(pharma.getColor()));
        }else{
            holder.color.setBackgroundColor(pharma.getColor());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends TagAdapter.ViewHolder {
        private TextView name;
        private TextView distance;
        private TextView location;
        private TextView starsAvg;
        private TextView starsNmber;
        private TextView saturday;
        private TextView sunday;
        private TextView color;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            distance = itemView.findViewById(R.id.distance);
            location = itemView.findViewById(R.id.location);
            starsAvg = itemView.findViewById(R.id.starsAverage);
            starsNmber = itemView.findViewById(R.id.starsCount);
            saturday = itemView.findViewById(R.id.dateSaturday);
            sunday = itemView.findViewById(R.id.daySunday);
            color = itemView.findViewById(R.id.color);
        }
    }
}
