package com.jboilerplate.data.http_call;

import android.content.Context;
import android.provider.Settings;
import android.support.v4.BuildConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jboilerplate.data.DataManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Client {

    private final String TAG = getClass().getSimpleName();
    public static String BASE_URL = "";

    private Context context;

    public Retrofit2Client(Context context) {
        this.context = context;
    }

    public Api getApi() {
        return getClient().create(Api.class);
    }

    /**
     * get Retrofit obj
     *
     * @return
     */

    private Retrofit getClient() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttp())
                .build();
    }

    /**
     * get OkHttpClient obj
     *
     * @return
     */
    private OkHttpClient getOkHttp() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.readTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.addInterceptor(getInterceptor());

//        if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addNetworkInterceptor(loggingInterceptor);
//        }

        return okHttpBuilder.build();
    }

    /**
     * get Interceptor obj
     *
     * @return
     */
    private Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder builder = original.newBuilder();
                if (getToken() != null) {
                    builder.addHeader("Authorization", getToken());
                }

//                String deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                Request request = builder
                        .addHeader("Content-Type", "application/json")
//                        .addHeader("DeviceId", deviceId)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        };
    }

    /**
     * get token from shared-preferences
     *
     * @return
     */
    private String getToken() {
        return new DataManager(context).getToken();
    }

}
