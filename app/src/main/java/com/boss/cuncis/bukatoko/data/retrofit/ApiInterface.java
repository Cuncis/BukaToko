package com.boss.cuncis.bukatoko.data.retrofit;

import com.boss.cuncis.bukatoko.data.model.Detail;
import com.boss.cuncis.bukatoko.data.model.Product;
import com.boss.cuncis.bukatoko.data.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("products")
    Call<Product> getProducts();

    @GET("product/{id}")
    Call<Detail> getProducts(@Path("id") int id);

    @FormUrlEncoded
    @POST("auth/login")
    Call<User> authLogin(@Field("email") String email,
                         @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<User> authRegister(@Field("name") String name,
                            @Field("email") String email,
                            @Field("password") String password);

}























