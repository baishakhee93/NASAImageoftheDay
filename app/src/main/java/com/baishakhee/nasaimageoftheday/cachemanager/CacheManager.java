package com.baishakhee.nasaimageoftheday.cachemanager;

import android.content.Context;
import android.content.SharedPreferences;

import com.baishakhee.nasaimageoftheday.model.MainModelResponse;

public class CacheManager {
    private static final String PREF_NAME = "nasa_api_cache";
    private static final String KEY_JSON_RESPONSE = "json_response";

    private final SharedPreferences preferences;
    private static final String PREFS_NAME = "nasa_image_cache";
    private static final String CACHE_KEY_COPYRIGHT = "copyright";
    private static final String CACHE_KEY_TITLE = "cached_title";
    private static final String CACHE_KEY_DATE = "cached_date";
    private static final String CACHE_KEY_DESCRIPTION = "cached_description";
    private static final String CACHE_KEY_URL = "cached_url";
    private static final String CACHE_KEY_MEDIA_TYPE = "cached_media_type";


    public CacheManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveApiResponse(String jsonResponse) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_JSON_RESPONSE, jsonResponse);
        editor.apply();
    }
    public void saveDataToCache(MainModelResponse mainModelResponse) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CACHE_KEY_TITLE, mainModelResponse.getTitle());
        editor.putString(CACHE_KEY_DATE, mainModelResponse.getDate());
        editor.putString(CACHE_KEY_DESCRIPTION, mainModelResponse.getExplanation());
        editor.putString(CACHE_KEY_URL, mainModelResponse.getUrl());
        editor.putString(CACHE_KEY_MEDIA_TYPE, mainModelResponse.getMediaType());
        editor.apply();
    }
    public MainModelResponse getCacheData() {
        String cachedCopy = preferences.getString(CACHE_KEY_COPYRIGHT, "");
        String cachedTitle = preferences.getString(CACHE_KEY_TITLE, "");
        String cachedDate = preferences.getString(CACHE_KEY_DATE, "");
        String cachedDescription = preferences.getString(CACHE_KEY_DESCRIPTION, "");
        String cachedUrl = preferences.getString(CACHE_KEY_URL, "");
        String cachedMediaType = preferences.getString(CACHE_KEY_MEDIA_TYPE, "");

        return new MainModelResponse(cachedCopy,cachedDate,cachedDescription,"", cachedMediaType,"",cachedTitle,cachedUrl);
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

