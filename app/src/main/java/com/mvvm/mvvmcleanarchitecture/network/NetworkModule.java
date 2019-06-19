package com.mvvm.mvvmcleanarchitecture.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mvvm.mvvmcleanarchitecture.utils.Constant.BASE_URL;

public class NetworkModule {

    public static WebService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(WebService.class);
    }

}
