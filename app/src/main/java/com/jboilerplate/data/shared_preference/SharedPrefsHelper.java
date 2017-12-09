package com.jboilerplate.data.shared_preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 11/15/2017.
 */

public class SharedPrefsHelper {
    public static String PREF_NAME = "access-token";
    public static String PREF_KEY_ACCESS_TOKEN = "access-token";

    private SharedPreferences mSharedPreferences;

    public SharedPrefsHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public SharedPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public void removeSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }
}
