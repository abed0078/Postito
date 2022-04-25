package com.example.postito

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


public interface Service{
    @GET("/posts")
   // suspend fun getPosts( @Query("{userId}") userId:Int): Response<ResponseBody>
    fun getPosts(): Call<List<PostDetail>>

    @GET("/posts/10")
    fun getPostDetails(): Call<List<PostDetail>>


}