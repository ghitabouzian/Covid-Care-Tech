package com.thexcoders.covid_care.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.thexcoders.covid_care.R;
import com.thexcoders.covid_care.cards.HomePost;

import java.util.List;

public class HomePostAdapter extends RecyclerView.Adapter<HomePostAdapter.ViewHolder> {

    private final List<HomePost> homePosts;
    private final Context context;

    public HomePostAdapter(List<HomePost> homePosts, Context context) {
        this.homePosts = homePosts;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_post_card_item, parent, false);
        return new ViewHolder(v, homePosts, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomePost homePost = homePosts.get(position);
        holder.txtBody.setText(homePost.getLikes()+" "+homePost.getBody());
        holder.txtTitle.setText(homePost.getTitle());
        holder.txtDate.setText(homePost.getFormattedDate());
        holder.tagAdapter = new TagAdapter(homePost.getTagList());
        holder.tagsRecycler.setAdapter(holder.tagAdapter);

        holder.txtLikes.setText(""+homePost.getLikes());

        holder.txtComments.setText(""+homePost.getComments());
        if (homePost.isUserLiked()) {
            holder.btnLike.setImageResource(R.drawable.ic_like_active);
        }

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePost.setUserLiked(!homePost.isUserLiked());

                if (homePost.isUserLiked()) {
                    homePost.like();
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(1)
                            .playOn(holder.btnLike);
                    holder.btnLike.setImageResource(R.drawable.ic_like_active);
                } else {
                    homePost.dislike();
                    holder.btnLike.setImageResource(R.drawable.ic_like);
                }

                holder.txtLikes.setText(""+homePost.getLikes());

            }
        });
    }

    @Override
    public int getItemCount() {
        return homePosts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton btnBookmark;
        private ImageButton btnMessage;
        private ImageButton btnLike;
        private ImageButton btnComment;

        private TextView txtTitle;
        private TextView txtBody;
        private TextView txtLikes;
        private TextView txtComments;
        private TextView txtDate;

        private RecyclerView tagsRecycler;

        private LinearLayoutManager layoutManager;
        private TagAdapter tagAdapter;


        public ViewHolder(@NonNull View itemView, List<HomePost> homePosts, Context context) {
            super(itemView);
            btnBookmark = itemView.findViewById(R.id.btnBookmark);
            btnMessage = itemView.findViewById(R.id.btnMessage);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnComment = itemView.findViewById(R.id.btnComment);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
            txtLikes = itemView.findViewById(R.id.tvLikes);
            txtComments = itemView.findViewById(R.id.txtComments);
            txtDate = itemView.findViewById(R.id.txtDate);

            tagsRecycler = itemView.findViewById(R.id.tagsRecyclerView);

            layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, true);
            tagsRecycler.setLayoutManager(layoutManager);
        }
    }
}
