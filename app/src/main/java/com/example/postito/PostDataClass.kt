package com.example.postito

import com.google.gson.annotations.SerializedName
/*data class PostResult(
    @SerializedName("posts")val posts:List<PostDetail>
)*/

data class PostDetail(
    val userId:Int,
    val id: Int,
    val title: String,
    val body: String
)