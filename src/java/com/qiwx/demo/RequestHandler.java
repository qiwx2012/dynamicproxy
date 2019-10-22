package com.qiwx.demo;

import com.google.gson.Gson;
import com.qiwx.demo.bean.User;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class RequestHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Annotation[] annotations=method.getAnnotations();
        if(annotations!=null&&annotations.length>0){
            Annotation annotation=annotations[0];
            if(annotation instanceof GET){
                GET get=(GET) annotation;
                return handleGetRequest(method,get,args);

            }else if(annotation instanceof POST){

            }
        }
        return null;
    }

    private Observable handleGetRequest(Method method,GET get,Object[] params){
        String url=get.value();
        Type genericType=method.getGenericReturnType();
        Parameter[] parameters = method.getParameters();
        ParameterizedType parameterizedType= (ParameterizedType) genericType;
        Class returnGenericClazz=null;
        //解析方法返回值等参数类型
        if(parameterizedType!=null){
            Type[] types=parameterizedType.getActualTypeArguments();
            for (int i = 0; i < types.length; i++) {
                Class cls=(Class) types[i];
                returnGenericClazz=cls;
                break;
            }

        }
        //解析请求参数，然后拼接到url
//        if(params!=null){
//            url+="?";
//            for (int i = 0; i < params.length; i++) {
//               Query query=parameters[i].getAnnotation(Query.class);
//               url+=query.value()+"="+params[i].toString();
//               if(i<params.length-1){
//                   url+="$";
//               }
//            }
//
//        }
        if(params!=null){
            for (int i = 0; i < params.length; i++) {
               Query query=parameters[i].getAnnotation(Query.class);
              url= String.format(url,params[i].toString());
            }

        }
        String ab=null;

        final String getUrl=url;
        final Class returnClazz=returnGenericClazz;
        return Observable.create(observableEmitter->{
            Request request=new Request.Builder()
                    .url(getUrl)
                    .build();
            Response response=new OkHttpClient()
                    .newCall(request)
                    .execute();
            System.out.println("请求地址是："+getUrl);
            if(response.isSuccessful()){
                String responseStr=new String(response.body().bytes());
                observableEmitter.onNext(new Gson().fromJson(responseStr,User.class));
            }else {
                observableEmitter.onError(new IllegalAccessException("http request failed"));
            }
            observableEmitter.onComplete();
        });

    }



}
