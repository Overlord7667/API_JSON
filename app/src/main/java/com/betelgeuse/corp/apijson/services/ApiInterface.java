package com.betelgeuse.corp.apijson.services;

import com.betelgeuse.corp.apijson.moduls.ResApiResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //    "https://omdbapi.com/?s=Spiderman&apikey=5b9b7798"
    //    "https://omdbapi.com/movies/search?s=Spiderman&apikey=5b9b7798"
    //    @GET("movies/search?")
    @GET("?")
    Call<ResApiResponce> getMoveByName(@Query("s") String title , @Query("apikey") String apiKey,  @Query("page") int page);
}
