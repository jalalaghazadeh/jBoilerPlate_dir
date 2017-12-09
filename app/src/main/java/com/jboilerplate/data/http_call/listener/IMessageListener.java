package com.jboilerplate.data.http_call.listener;

/**
 * Created by Android on 12/1/2017.
 */

public interface IMessageListener {


    public void onSuccess(String response);

    public void onFailure(String error);


}
