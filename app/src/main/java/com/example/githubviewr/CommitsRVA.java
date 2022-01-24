package com.example.githubviewr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommitsRVA extends RecyclerView.Adapter<CommitsRVA.CommitViewHolder> {
    private List<Commit> commits;
    private final AvatarSetter avatarSetter;

    public CommitsRVA() {
        avatarSetter = new AvatarSetter();
    }

    public void setCommits(List<Commit> elements) {
        commits = elements;
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
        if(commits != null) holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return commits != null ? commits.size() : 0;
    }

    class CommitViewHolder extends RecyclerView.ViewHolder {
        TextView user;
        TextView email;
        TextView hash;
        ImageView avatar;
        Commit commit;

        public CommitViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user_field);
            email = itemView.findViewById(R.id.email_field);
            hash = itemView.findViewById(R.id.hash_field);
            avatar = itemView.findViewById(R.id.avatar);
        }

        void bind(int position) {
            // Put data to element fields
            commit = commits.get(position);

            user.setText(commit.author.login);
            email.setText(commit.commit.author.email);
            hash.setText(commit.hash);
            avatarSetter.setImage(commit.author.avatarUrl, avatar);
        }
    }
}
