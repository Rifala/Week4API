package com.example.week4batch2.WebService

import com.example.week4batch2.Model.Barang
import com.example.week4batch2.Model.ListResponse
import com.example.week4batch2.Model.SingleResponse
import retrofit2.Call
import retrofit2.http.*

interface APIEndPoint {

    @GET("barang")
    fun getData(): Call<ListResponse<Barang>>

    @GET("barang/{id}")
    fun getDataById(@Path("id")id : Int): Call <ListResponse<Barang>>

    @FormUrlEncoded                     //untuk ngirim data bentuk teks itn/string
    @POST("barang")
    fun PostData(@Field("nama")nama : String,
                 @Field("kode")kode : Int): Call<SingleResponse<Barang>>

}      //untuk post dengan gambar menggunakan multipart