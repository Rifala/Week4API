package com.example.week4batch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week4batch2.Model.Barang
import com.example.week4batch2.Model.ListResponse
import com.example.week4batch2.WebService.APIService
import com.example.week4batch2.databinding.ActivityDetailBinding
import com.example.week4batch2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData(){
        APIService.ApiEndPoint().getDataById(intent.getIntExtra("id", 0)).
        enqueue(object :Callback<ListResponse<Barang>>{
            override fun onResponse(
                call: Call<ListResponse<Barang>>,
                response: Response<ListResponse<Barang>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body!= null){
                        setData(body.data)
                    }
                }
            }

            override fun onFailure(call: Call<ListResponse<Barang>>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "Gagal Terhubung", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setData(data :MutableList<Barang>){
        binding.tvNama.text= data[0].nama
        binding.tvCode.text= data[0].kode.toString()

    }
}