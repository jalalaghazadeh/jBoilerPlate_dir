package com.jboilerplate.data.http_call;

import android.support.v4.BuildConfig;
import android.view.View;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bs156 on 23-Dec-16.
 */

public class CustomRetrofit2CallBack<T> implements Callback<T> {

    private View view;

    public CustomRetrofit2CallBack() {
        // no loading
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.body() != null) {
            EventBus.getDefault().post(response.body());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (BuildConfig.DEBUG) {
            t.printStackTrace();
        }
        EventBus.getDefault().post(t.getMessage());
    }

}
