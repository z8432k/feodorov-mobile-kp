package com.example.githubviewr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.githubviewr.databinding.ActivityCommitsListBinding;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class CommitsList extends AppCompatActivity {
    private ActivityCommitsListBinding bindings;
    private CommitsRVA commitsRVA;
    private final RetrofitAPI restAPI = new RetrofitAPI();
    private Disposable asyncResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commits_list);

        bindings = ActivityCommitsListBinding.inflate(getLayoutInflater());
        setContentView(bindings.getRoot());

        String user = getData("USER_NAME");
        String repo = getData("REPO");

        initRecycler();

        requestFromServer(user, repo);
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

    public void requestFromServer(String user, String repo) {
        Observable<List<Commit>> single = restAPI.requestServer(user, repo);

        asyncResult = single.observeOn(AndroidSchedulers.mainThread()).subscribe(this::itemsToList, throwable -> {
            Log.e("REST_FAIL", "onError" + throwable);
        });
    }

    private void itemsToList(List<Commit> response) {
        if (response != null) {
            commitsRVA.setCommits(response);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        asyncResult.dispose();
    }
}