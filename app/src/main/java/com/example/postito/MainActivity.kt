package com.example.postito

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postito.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "MainActivity"
private const val BaseUrl = "https://jsonplaceholder.typicode.com"

class MainActivity : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    lateinit var postlist: ArrayList<PostDetail>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getMethod()

        binding.open.setOnClickListener {

            // on below line we are creating a new bottom sheet dialog.
            val dialog = BottomSheetDialog(this)

            // on below line we are inflating a layout file which we have created.
            val view = layoutInflater.inflate(R.layout.bottomsheet, null)


            val btnClose = view.findViewById<Button>(R.id.btnClose)


            btnClose.setOnClickListener {

                dialog.dismiss()
            }

            dialog.setCancelable(false)


            dialog.setContentView(view)


            dialog.show()
        }
    }


    private fun showData(body: List<PostDetail>) {
        binding.rvPosts.apply {
            //val listOfPosts = mutableListOf<PostDetail>()
            var adapter = PostAdapter(this@MainActivity, body)
            binding.rvPosts.adapter = adapter
            binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)

            adapter.setOnItemClickListener(object : PostAdapter.onItemClickListener {
                override fun onItemClicked(position: Int) {
                    val intent = Intent(this@MainActivity, PostDetailsActivity::class.java)
                    intent.putExtra("POST_TITLE", id)
                    startActivity(intent)


                }


            })
        }
    }


    fun getMethod() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postService = retrofit.create(Service::class.java)
        postService.getPosts()
            .enqueue(object : Callback<List<PostDetail>> {
                override fun onResponse(
                    call: Call<List<PostDetail>>,
                    response: Response<List<PostDetail>>
                ) {
                    showData(response.body()!!)
                }

                override fun onFailure(call: Call<List<PostDetail>>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }

            })
    }

    fun postMethod(UserId:Int ,id:Int ,title:String, body:String ) {
    }

}




