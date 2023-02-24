package com.example.pagingexample.api

import com.example.pagingexample.Util.Constants
import com.example.pagingexample.model.RAMResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ) : Response<RAMResponse>
}