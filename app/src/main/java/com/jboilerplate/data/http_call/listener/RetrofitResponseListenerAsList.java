package com.jboilerplate.data.http_call.listener;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Android on 12/1/2017.
 */

public interface RetrofitResponseListenerAsList<T> {
    public void onSuccess(Response<List<T>> response);
    public void onFailure(String error);
}
