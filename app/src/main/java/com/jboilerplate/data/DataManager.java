package com.jboilerplate.data;

import android.content.Context;

import com.jboilerplate.data.http_call.Retrofit2Client;
import com.jboilerplate.data.http_call.listener.RetrofitResponseListenerAsList;
import com.jboilerplate.data.http_call.models.BaseModel;
import com.jboilerplate.data.shared_preference.SharedPrefsHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 12/4/2017.
 */

public class DataManager {
    private Context context;

    public DataManager(Context context) {
        this.context = context;
    }

    // shared-preferences
    public void saveToken(String token){
        new SharedPrefsHelper(context).put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, token);
    }

    public String getToken(){
        return new SharedPrefsHelper(context).get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    // data-base


    // http-call
    public void getAllCategories(final RetrofitResponseListenerAsList responseListener){
        new Retrofit2Client(context).getApi().getCategory().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                responseListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                responseListener.onFailure(t.getMessage());
            }
        });
    }
}
