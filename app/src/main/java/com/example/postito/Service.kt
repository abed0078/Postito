package com.example.postito

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


public interface Service{
    @GET("/posts")
   // suspend fun getPosts( @Query("{userId}") userId:Int): Response<ResponseBody>
    fun getPosts(): Call<List<PostDetail>>

    @POST("posts")
    fun  //on below line we are creating a method to post our data.
            createPost(@Body dataModal: PostDetail?): Call<PostDetail?>?


}