package com.jboilerplate;

import android.app.Application;

import com.orm.SugarContext;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by user on 12/3/2017.
 */

public class AppConfiguration extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize calligraphy config
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("font/IranSans.ttf").build());
        // init SugarOrm
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
