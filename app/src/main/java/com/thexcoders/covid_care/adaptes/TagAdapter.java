package com.thexcoders.covid_care.adaptes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thexcoders.covid_care.R;
import com.thexcoders.covid_care.cards.HomePost;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {

    private final List<HomePost.Tag> tagList;

    public TagAdapter(List<HomePost.Tag> tagList) {
        this.tagList = tagList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomePost.Tag tag = tagList.get(position);
        holder.layout.setBackgroundColor(tag.getBackground());

        ((TextView)holder.layout.getChildAt(0)).setText(tag.getContent());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.txtTitle);

        }
    }
}
