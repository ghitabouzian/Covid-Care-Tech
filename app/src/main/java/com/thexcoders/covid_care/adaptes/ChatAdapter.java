package com.thexcoders.covid_care.adaptes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thexcoders.covid_care.R;
import com.thexcoders.covid_care.cards.RecentChat;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private final List<RecentChat> chatList;

    public ChatAdapter(List<RecentChat> homePosts) {
        this.chatList = homePosts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_card, parent, false);
        return new ViewHolder(v, chatList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecentChat chat = chatList.get(position);
        holder.txtBody.setText(chat.getContent());
        holder.txtDate.setText(chat.getFormattedDate());
        holder.title.setText(chat.getTitle());
        if (chat.isSeen()) {
            holder.seenImage.setVisibility(View.VISIBLE);
        }
        if (chat.isReceived()) {
            holder.receivedMessages.setText("" + chat.getMessagesCount());
            holder.receivedMessages.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView txtBody;
        private TextView txtDate;
        private ImageView seenImage;
        private TextView receivedMessages;

        public ViewHolder(@NonNull View itemView, List<RecentChat> chatList) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            txtBody = itemView.findViewById(R.id.txtBody);
            txtDate = itemView.findViewById(R.id.txtDate);
            seenImage = itemView.findViewById(R.id.seenImage);
            receivedMessages = itemView.findViewById(R.id.receivedMessages);

        }
    }
}
