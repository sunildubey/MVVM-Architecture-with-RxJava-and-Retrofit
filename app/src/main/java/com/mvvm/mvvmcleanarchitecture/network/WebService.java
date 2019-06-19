package com.mvvm.mvvmcleanarchitecture.network;

import com.mvvm.mvvmcleanarchitecture.model.UserContactResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface WebService {

    @GET("v1/clients/3/users/13/chronicpatients?duration=30&timezone=Asia%2FKolkata")
    Observable<UserContactResponse> fetchUsers();
}
