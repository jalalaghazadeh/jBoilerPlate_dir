package com.jboilerplate.data.http_call;


import com.jboilerplate.data.http_call.models.BaseModel;
import com.jboilerplate.data.http_call.models.CategoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    /**
     * API to get all main-categories
     * @return
     */
    @GET("categories")
    Call<BaseModel> getCategory();

}
