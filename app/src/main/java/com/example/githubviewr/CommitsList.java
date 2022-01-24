package com.example.githubviewr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.githubviewr.databinding.ActivityCommitsListBinding;

import java.util.Arrays;

public class CommitsList extends AppCompatActivity {
    private ActivityCommitsListBinding bindings;
    private CommitsRVA commitsRVA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commits_list);

        bindings = ActivityCommitsListBinding.inflate(getLayoutInflater());
        setContentView(bindings.getRoot());

        String user = getData("USER_NAME");
        String repo = getData("REPO");

        initRecycler();
        commitsRVA.setCommits(Arrays.asList("aaaa", "bbbb", "cccc"));
    }

    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        bindings.commitsRV.setLayoutManager(layoutManager);

        commitsRVA = new CommitsRVA();
        bindings.commitsRV.setAdapter(commitsRVA);
    }

    private String getData(String field) {
        Bundle args = getIntent().getExtras();
        return args.get(field).toString();
    }
}