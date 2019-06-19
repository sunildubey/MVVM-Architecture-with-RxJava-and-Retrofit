package com.mvvm.mvvmcleanarchitecture;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.mvvm.mvvmcleanarchitecture.adapter.UserAdapter;
import com.mvvm.mvvmcleanarchitecture.databinding.ActivityMainBinding;
import com.mvvm.mvvmcleanarchitecture.viewModel.AllContactViewModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding userActivityBinding;
    private AllContactViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setSupportActionBar(userActivityBinding.toolbar);
        setUpListOfUsersView(userActivityBinding.listUser);
        setUpObserver(userViewModel);
    }

    private void initDataBinding() {
        userActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userViewModel = new AllContactViewModel(this);
        userActivityBinding.setContactViewModel(userViewModel);
    }

    // set up the list of user with recycler view
    private void setUpListOfUsersView(RecyclerView listUser) {
        UserAdapter userAdapter = new UserAdapter();
        listUser.setAdapter(userAdapter);
        listUser.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof  AllContactViewModel) {
            UserAdapter userAdapter = (UserAdapter) userActivityBinding.listUser.getAdapter();
            AllContactViewModel userViewModel = (AllContactViewModel) o;
            userAdapter.setUserList(userViewModel.getUserList());
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        userViewModel.reset();
    }


}
