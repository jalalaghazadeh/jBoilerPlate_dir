package com.jboilerplate.ui.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Locale;

import de.greenrobot.event.EventBus;

/**
 * Created by user on 12/3/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        setLocaleFa(this);
//        forceLayoutToRTL();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setLocaleFa(Context context) {
        if (!Locale.getDefault().toString().equals("fa_IR")) {
            Locale locale = new Locale("fa", "IR");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                config.setLayoutDirection(locale);
                config.setLocale(locale);
            } else {
                config.locale = locale;
            }
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        }
    }

    private void forceLayoutToRTL(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (getWindow().getDecorView().getLayoutDirection() == View.LAYOUT_DIRECTION_LTR) {
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }
        }
    }
}
