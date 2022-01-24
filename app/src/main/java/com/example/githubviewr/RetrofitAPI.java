package com.example.githubviewr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {
    private final String baseUrl = "https://api.github.com";
    private final RetrofitService api;

    public RetrofitAPI() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        OkHttpClient client = new OkHttpClient.Builder().build();

        api = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);
    }

    public Observable<List<Commit>> requestServer(String user, String repo) {
        return api.getCommits(user, repo)
                .subscribeOn(Schedulers.io());
    }
}