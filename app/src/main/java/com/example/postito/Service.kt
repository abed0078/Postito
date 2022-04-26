package com.example.postito

import retrofit2.Call
import retrofit2.http.*


public interface Service {
    @GET("/posts")
    // suspend fun getPosts( @Query("{userId}") userId:Int): Response<ResponseBody>
    fun getPosts(): Call<List<PostDetail>>

     @POST("posts")
     //on below line we are creating a method to post our data.
    fun  createPost(@Body dataModal: MutableMap<String, String>): Call<PostDetail?>?



}