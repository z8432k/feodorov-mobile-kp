package com.example.mobileappkp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileappkp.feed.Article;
import com.example.mobileappkp.feed.Feed;

public class CommitsRVA extends RecyclerView.Adapter<CommitsRVA.CommitViewHolder> {
    private Feed feed;
    private final AvatarSetter avatarSetter;

    public CommitsRVA() {
        avatarSetter = new AvatarSetter();
    }

    public void setCommits(Feed data) {
        feed = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.commit;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);

        return new CommitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommitViewHolder holder, int position) {
        if(feed != null) holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return feed != null ? feed.articleList.size() : 0;
    }

    class CommitViewHolder extends RecyclerView.ViewHolder {
        TextView user;
        TextView email;
        TextView hash;
        ImageView avatar;
        Article article;

        public CommitViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user_field);
            email = itemView.findViewById(R.id.email_field);
            hash = itemView.findViewById(R.id.hash_field);
            avatar = itemView.findViewById(R.id.avatar);
        }

        void bind(int position) {
            // Put data to element fields
            article = feed.articleList.get(position);

            user.setText(article.title);
            email.setText(article.title);
            hash.setText(article.title);
            avatarSetter.setImage(article.title, avatar);
        }
    }
}
