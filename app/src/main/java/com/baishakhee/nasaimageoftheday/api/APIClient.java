package com.baishakhee.nasaimageoftheday.api;

import com.baishakhee.nasaimageoftheday.cachemanager.CacheManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;

import okhttp3.Request;
import okhttp3.Response;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient{

    private static final String BASE_URL = "https://api.nasa.gov/";
    private static Retrofit retrofit = null;

    private final Context context;
    private final CacheManager cacheManager;

    public APIClient(Context context) {
        this.context = context;
        this.cacheManager = new CacheManager(context);
    }

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Use RxJava3CallAdapterFactory
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public String getCachedApiResponse() {
        return cacheManager.getApiResponse();
    }

    public void clearCache() {
        cacheManager.clearCache();
    }
}

