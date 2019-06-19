package com.mvvm.mvvmcleanarchitecture.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.mvvm.mvvmcleanarchitecture.R;
import com.mvvm.mvvmcleanarchitecture.app.AppController;
import com.mvvm.mvvmcleanarchitecture.model.UserContactResponse;
import com.mvvm.mvvmcleanarchitecture.network.WebService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class AllContactViewModel extends Observable {

    public ObservableInt progressBar;
    public ObservableInt userRecycler;
    public ObservableInt userLabel;
    public ObservableField<String> messageLabel;

    private List<UserContactResponse.PayloadBean.PatientListBean> userList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AllContactViewModel(@NonNull Context context) {
        this.context = context;
        this.userList = new ArrayList<>();
        progressBar = new ObservableInt(View.GONE);
        userRecycler = new ObservableInt(View.GONE);
        userLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_message_loading_users));
        initializeViews();
        fetchUsersList();
    }


    //It is "public" to show an example of test
    public void initializeViews() {
        userLabel.set(View.GONE);
        userRecycler.set(View.GONE);
        progressBar.set(View.VISIBLE);
    }

    private void fetchUsersList() {

        AppController appController = AppController.create(context);
        WebService webService = appController.getUserService();

        Disposable disposable = webService.fetchUsers()
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserContactResponse>() {
                    @Override public void accept(UserContactResponse userResponse) throws Exception {
                        updateUserDataList(userResponse.getPayload().getPatientList());
                        progressBar.set(View.GONE);
                        userLabel.set(View.GONE);
                        userRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) throws Exception {
                        messageLabel.set(context.getString(R.string.error_message_loading_users)+" "+throwable.getMessage());
                        progressBar.set(View.GONE);
                        userLabel.set(View.VISIBLE);
                        userRecycler.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void updateUserDataList(List<UserContactResponse.PayloadBean.PatientListBean> list) {
        userList.addAll(list);
        setChanged();
        notifyObservers();
    }

    public List<UserContactResponse.PayloadBean.PatientListBean> getUserList() {
        return userList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}

