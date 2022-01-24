package com.example.mobileappkp;

import com.example.mobileappkp.feed.Feed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitAPI {
    private final String baseUrl = "https://www.securitylab.ru";
    private final RetrofitService api;

    public RetrofitAPI() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        api = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    public Observable<Feed> requestServer() {
        return api.getRss()
                .subscribeOn(Schedulers.io());
    }
}