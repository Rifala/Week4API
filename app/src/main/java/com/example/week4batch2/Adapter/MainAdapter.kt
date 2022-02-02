package com.example.week4batch2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week4batch2.Model.Barang
import com.example.week4batch2.databinding.ListitemBinding

class MainAdapter (val barang: MutableList<Barang>,val listener: MainAdapter.OnClick):RecyclerView.Adapter<MainAdapter.BarangViewHolder>(){

    inner class BarangViewHolder(val Binding: ListitemBinding):RecyclerView.ViewHolder(Binding.root)
    interface OnClick {
        fun OnRead(barang: Barang)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        return BarangViewHolder(ListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        holder.Binding.apply {
            tvTittle.text = barang[position].nama
            tvTittle.setOnClickListener {
                listener.OnRead(barang[position])
            }                                                            //menggabungkan textview dengan 'nama'
        }
    }

    override fun getItemCount(): Int {
        return barang.size
    }
}