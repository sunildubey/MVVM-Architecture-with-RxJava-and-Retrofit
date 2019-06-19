package com.mvvm.mvvmcleanarchitecture.app;

import android.app.Application;
import android.content.Context;

import com.mvvm.mvvmcleanarchitecture.network.NetworkModule;
import com.mvvm.mvvmcleanarchitecture.network.WebService;


import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class AppController extends Application {

    private WebService webService;
    private Scheduler scheduler;

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    public WebService getUserService() {
        if (webService == null) {
            webService = NetworkModule.create();
        }

        return webService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    public void setUserService(WebService webService) {
        this.webService = webService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

}
