package com.example.mydevilhealth.customadapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.mydevilhealth.databinding.ActivityMain3Binding
import com.example.mydevilhealth.databinding.DialogCustomBinding
import com.example.mydevilhealth.datalist.DataList3
import com.example.mydevilhealth.intent.MainActivity3

class CustomDialog(val context: Context, val main3Binding: ActivityMain3Binding) {
    val dialog = Dialog(context)

    fun showDialog() {
        val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnSave.setOnClickListener {
            val tvCategoryR= binding.tvCategoryR.text.toString()
            val tvPrice_num = binding.tvPriceNum.text.toString()
            val tvDates_num= binding.tvDatesNum.text.toString()
            var dataList3: DataList3? = null
            dataList3 = DataList3(tvCategoryR, tvPrice_num,0,0,tvDates_num,0)
            (context as MainActivity3).refreshRecyclerView(dataList3)
            dialog.dismiss()
        }
    }
}