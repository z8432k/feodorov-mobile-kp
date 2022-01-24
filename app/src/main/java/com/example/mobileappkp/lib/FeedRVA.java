package com.example.mobileappkp.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileappkp.R;
import com.example.mobileappkp.feed.Article;
import com.example.mobileappkp.feed.Feed;

public class FeedRVA extends RecyclerView.Adapter<FeedRVA.FeedViewHolder> {
    private Feed feed;
    private final ImageSetter imageSetter;

    public FeedRVA() {
        imageSetter = new ImageSetter();
    }

    public void setCommits(Feed data) {
        feed = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.aricle;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);

        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        if(feed != null) holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return feed != null ? feed.articleList.size() : 0;
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView pub_date;
        ImageView image;
        Article article;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            pub_date = itemView.findViewById(R.id.pub_date);
            image = itemView.findViewById(R.id.image);
        }

        void bind(int position) {
            // Put data to element fields
            article = feed.articleList.get(position);

            title.setText(article.title);
            description.setText(article.description);
            pub_date.setText(article.pubDate);
            if (article.enclosure != null && article.enclosure.url != null) {
                imageSetter.setImage(article.enclosure.url, image);
            }
        }
    }
}
