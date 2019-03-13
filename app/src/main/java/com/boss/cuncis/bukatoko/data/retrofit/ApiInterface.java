package com.boss.cuncis.bukatoko.data.retrofit;

import com.boss.cuncis.bukatoko.data.model.Detail;
import com.boss.cuncis.bukatoko.data.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("products")
    Call<Product> getProducts();

    @GET("product/{id}")
    Call<Detail> getProducts(@Path("id") int id);

}























