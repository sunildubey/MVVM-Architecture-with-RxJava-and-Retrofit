package com.mvvm.mvvmcleanarchitecture.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.mvvm.mvvmcleanarchitecture.model.UserContactResponse;

public class AllContactItemViewModel extends BaseObservable {

    private UserContactResponse.PayloadBean.PatientListBean user;
    private Context context;

    public AllContactItemViewModel(UserContactResponse.PayloadBean.PatientListBean user, Context context){
        this.user = user;
        this.context = context;
    }


    public String getHealthScore() { return String.valueOf(user.getHealthScore()); }

    public String getAddress() { return user.getAddress(); }

    public String getName() {

        String fullName = user.getFirstName();

        return fullName;

    }

    public void setUser(UserContactResponse.PayloadBean.PatientListBean user) {
        this.user = user;
        notifyChange();
    }
}