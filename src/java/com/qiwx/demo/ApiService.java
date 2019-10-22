package com.qiwx.demo;


import com.qiwx.demo.bean.User;
import io.reactivex.Observable;

public interface ApiService {
    @GET("http://wcf.open.cnblogs.com/news/hot/2")
    Observable<String> getNews(@Query("version") String version);

    @GET("https://www.zhihu.com/api/v4/members/%s")
    Observable<User> getUser(@Query("username")String username);

}
