package com.boss.cuncis.bukatoko.data.retrofit;

import com.boss.cuncis.bukatoko.data.model.rajaongkir.City;
import com.boss.cuncis.bukatoko.data.model.rajaongkir.Cost;
import com.boss.cuncis.bukatoko.data.model.Detail;
import com.boss.cuncis.bukatoko.data.model.Product;
import com.boss.cuncis.bukatoko.data.model.User;
import com.boss.cuncis.bukatoko.data.model.transaction.TransPost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @FormUrlEncoded
    @POST("auth/update/{id}")
    Call<User> updateUser(@Path("id") String id,
                          @Field("name") String name,
                          @Field("email") String email,
                          @Field("password") String password);

    @POST("transaction")
    Call<TransPost> insertTrans(@Body TransPost transPost);

    // Raja ongkir - end Point

    @GET("city")
    Call<City> getCities(@Query("key") String key);

    @FormUrlEncoded
    @POST("cost")
    Call<Cost> getCost(@Field("key") String key,
                       @Field("origin") String origin,
                       @Field("destination") String destination,
                       @Field("weight") String weight,
                       @Field("courier") String courier);

}























