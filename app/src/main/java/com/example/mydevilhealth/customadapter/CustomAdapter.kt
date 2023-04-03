package com.example.mydevilhealth.customadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mydevilhealth.databinding.ItemView3Binding
import com.example.mydevilhealth.datalist.DataList3

class CustomAdapter(val dataList: MutableList<DataList3>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemView3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binging
        binding.tvCategory.text = dataList.get(position).tvCategory.toString()
        binding.tvReviewNum.text = dataList.get(position).tvReview_num.toString()
        binding.tvPriceNum.text = dataList.get(position).tvPrice_num.toString()
        binding.tvBuyNum.text = dataList.get(position).tvBuy_num.toString()
        binding.tvDatesNum.text = dataList.get(position).tvDates_num.toString()
        binding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${dataList[position].toString()}", Toast.LENGTH_SHORT).show()
        }

        binding.root.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                val position = holder.adapterPosition
                val dataList = dataList.removeAt(position)

                Toast.makeText(binding.root.context, "${dataList.ivPicture} 삭제 완료",Toast.LENGTH_SHORT).show() // 사라지기 전에
                notifyDataSetChanged()  // 다시 시작하는 것
                return true
            }
        })
    }

    class CustomViewHolder(val binging: ItemView3Binding) : RecyclerView.ViewHolder(binging.root)
}