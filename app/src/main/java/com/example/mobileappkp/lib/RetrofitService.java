package com.example.mobileappkp.lib;


import com.example.mobileappkp.feed.Feed;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/_services/export/rss/")
    Observable<Feed> getRss();
}
