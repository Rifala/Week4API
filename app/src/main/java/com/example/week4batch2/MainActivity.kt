package com.example.week4batch2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week4batch2.Adapter.MainAdapter
import com.example.week4batch2.Model.Barang
import com.example.week4batch2.Model.ListResponse
import com.example.week4batch2.WebService.APIService
import com.example.week4batch2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()



    }

    private fun getData (){
        APIService.ApiEndPoint().getData().enqueue(object :Callback<ListResponse<Barang>>{
            override fun onResponse(
                call: Call<ListResponse<Barang>>,
                response: Response<ListResponse<Barang>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body!= null) {
                        showRecycler(body.data)

                    }
                }
            }

            override fun onFailure(call: Call<ListResponse<Barang>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal Terhubung", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showRecycler(data:MutableList<Barang>){
        mainAdapter= MainAdapter(data,object :MainAdapter.OnClick{
            override fun OnRead(barang: Barang) {
                startActivity(Intent(this@MainActivity,DetailActivity::class.java).also {
                    it.putExtra("id",barang.id)
                })
            }


        })
        binding.RecyclerView.apply {
            adapter= mainAdapter
            layoutManager= LinearLayoutManager(this@MainActivity)
        }
    }
}