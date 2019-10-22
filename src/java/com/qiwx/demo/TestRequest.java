package com.qiwx.demo;

import com.qiwx.demo.bean.User;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.Scanner;

public class TestRequest {
    public static void main(String[] args) {
        ApiService apiService=Retrofit.newProxy(ApiService.class);
        //调用getNews方法其实是调用了代理方法，代理方法根据注解组装成一个http请求
        Observable<User> checkUpdateObservable=apiService.getUser("qiwx2012");
        checkUpdateObservable.subscribeOn(Schedulers.io())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User s) throws Exception {
                     System.out.println("网络请求结果："+s.getName());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("网络请求异常"+throwable.getMessage());
                    }
                });
        //等待工作线程执行完成，在命令行输入任意字符结束线程
        Scanner scanner=new Scanner(System.in);
        if(scanner.next()!=null){

        }

    }
}
