package com.example.mydevilhealth.customadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hometrainingapp2.datalist.DataList
import com.example.mydevilhealth.databinding.ItemViewBinding

class CustomRecycleAdapter(val dataList: MutableList<DataList>) :
    RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHodler {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHodler(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHodler, position: Int) {
        val binding = holder.binding
        binding.tvHeader.text = dataList.get(position).tvHeader
        binding.tvSub.text = dataList.get(position).tvSub
        binding.tvTime.text= dataList.get(position).tvTime.toString()
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

            binding.root.setOnLongClickListener(object : View.OnLongClickListener {
                override fun onLongClick(p0: View?): Boolean {
                    val position = holder.adapterPosition
                    val dataVO = dataList.removeAt(position)

                    Toast.makeText(binding.root.context, " ${dataVO.toString()}", Toast.LENGTH_SHORT)
                        .show()
                    notifyDataSetChanged() // 변경 점이 있다...
                    return true
                }
            })
        }

    }

    class CustomViewHodler(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)
}