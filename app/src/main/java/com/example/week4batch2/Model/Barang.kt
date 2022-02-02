package com.example.week4batch2.Model

data class Barang (
    val id: Int,
    val nama : String,
    val kode : Int,
    val createdAt : String,
    val updateAt : String
        )

    data class ListResponse<T>(     //<T> digunakan untuk mengembalikan return yg berbeda dan bisa pakai huruf lain
        val msg : String,
        val status : Int,
        val data : MutableList<T>
    )

    data class SingleResponse<T>(
        val msg : String,
        val status : Int,
        val data : T
    )