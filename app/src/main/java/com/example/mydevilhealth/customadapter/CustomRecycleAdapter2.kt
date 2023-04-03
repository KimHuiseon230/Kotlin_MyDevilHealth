package com.example.mydevilhealth.customadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hometrainingapp2.datalist.DataList2
import com.example.mydevilhealth.databinding.ItemView2Binding

class CustomRecycleAdapter2(val dataList: MutableList<DataList2>) :
    RecyclerView.Adapter<CustomRecycleAdapter2.CustomViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHodler {
        val binding = ItemView2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHodler(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHodler, position: Int) {
        val binding = holder.binding
        binding.tvBox.text = dataList.get(position).tvBox
        binding.ivPicture.setImageResource(dataList.get(position).ivPicture)

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${dataList.get(position).toString()}",
                Toast.LENGTH_SHORT
            ).show()

            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "${dataList[position]}", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    class CustomViewHodler(val binding: ItemView2Binding) : RecyclerView.ViewHolder(binding.root)
}