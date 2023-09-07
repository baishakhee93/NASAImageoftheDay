package com.baishakhee.nasaimageoftheday.api;

import com.baishakhee.nasaimageoftheday.model.MainModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("planetary/apod")
    Call<MainModelResponse> getData(@Query("api_key") String nasaApiKey);
}

