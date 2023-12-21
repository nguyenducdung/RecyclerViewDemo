package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var rvPhoto: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPhoto = findViewById(R.id.rvPhoto)
        rvPhoto?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        getPhotos()
    }

    private fun getPhotos() {
        RetrofitClient.getRetrofitClient().getPhotos().enqueue(object: Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val adapter = PhotoAdapter(response.body() ?: listOf())
                rvPhoto?.adapter = adapter
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}