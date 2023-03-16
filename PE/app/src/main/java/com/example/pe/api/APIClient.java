package com.example.pe.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static String baseURl = "https://636e5dac182793016f3ec699.mockapi.io/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseURl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
