package com.boss.cuncis.bukatoko.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.1.108/onlineshop/public/api/";
    private static Retrofit retrofit = null;

    public Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
    // KURANG PRODUK TIDAK MUNCUL
}
