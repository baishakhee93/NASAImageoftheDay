package com.baishakhee.nasaimageoftheday.cachemanager;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheManager {
    private static final String PREF_NAME = "nasa_api_cache";
    private static final String KEY_JSON_RESPONSE = "json_response";

    private final SharedPreferences preferences;

    public CacheManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveApiResponse(String jsonResponse) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_JSON_RESPONSE, jsonResponse);
        editor.apply();
    }

    public String getApiResponse() {
        return preferences.getString(KEY_JSON_RESPONSE, null);
    }

    public void clearCache() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(KEY_JSON_RESPONSE);
        editor.apply();
    }
}

