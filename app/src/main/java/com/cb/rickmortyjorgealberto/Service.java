package com.cb.rickmortyjorgealberto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("api/character")
    Call<Character> getCharacters(
            @Query("page") int page
    );

}
