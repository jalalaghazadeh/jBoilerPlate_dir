package com.jboilerplate.data.http_call.listener;

import retrofit2.Response;

/**
 * Created by Android on 12/1/2017.
 */

public interface RetrofitResponseListenerAsObject<T> {
    public void onSuccess(Response<T> response);
    public void onFailure(String error);
}
