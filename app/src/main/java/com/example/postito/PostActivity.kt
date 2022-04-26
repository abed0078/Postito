package com.example.postito

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.postito.databinding.ActivityPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       // postMethod()
    }

    fun postMethod() {
        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build()

        // Create Service
        val post = PostDetail(1, 23, "New Title", "New Text")
        val fields: MutableMap<String, String> = HashMap()
        fields["userId"] = "25"
        fields["title"] = "New Title"
        val service = retrofit.create(Service::class.java)
        val call: Unit? = service.createPost(fields)
            ?.enqueue(object : Callback<List<PostDetail>> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<List<PostDetail>>,
                    response: Response<List<PostDetail>>
                ) {
                  binding.TVResponse.setText("Code: " + response.code())
                    val postResponse: List<PostDetail>? = response.body()


                  /*  var content = ""
                    content += """
                        Code: ${response.code()}

                        """.trimIndent()
                    content += """
                        ID: ${postResponse.getId().toString()}

                        """.trimIndent()
                    content += """
                        User ID: ${postResponse.getUserId().toString()}

                        """.trimIndent()
                    content += """
                        Title: ${postResponse.getTitle().toString()}

                        """.trimIndent()
                    content += """
                        Text: ${postResponse.getText().toString()}


                        """.trimIndent()

                    binding.TVResponse.setText(content)*/
                }


                override fun onFailure(call: Call<List<PostDetail>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }


}

private fun <T> Call<T>?.enqueue(callback: Callback<List<PostDetail>>) {

}




