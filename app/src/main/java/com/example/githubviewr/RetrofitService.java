package com.example.githubviewr;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/repos/{user}/{repo}/commits")
    Observable<List<Commit>> getCommits(@Path("user") String user, @Path("repo") String repo);
}
