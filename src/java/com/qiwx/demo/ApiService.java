package com.qiwx.demo;


import io.reactivex.Observable;

public interface ApiService {
    @GET("http://wcf.open.cnblogs.com/news/hot/2")
    Observable<String> getNews(@Query("version") String version);

}
