package com.example.mydevilhealth.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hometrainingapp2.datalist.DataList2
import com.example.mydevilhealth.R
import com.example.mydevilhealth.customadapter.CustomRecycleAdapter2
import com.example.mydevilhealth.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    val binding: ActivityMain5Binding by lazy { ActivityMain5Binding.inflate(layoutInflater) }
    lateinit var dataList: MutableList<DataList2>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataList = mutableListOf<DataList2>()
        dataList.add(DataList2("데빌헬스에게 질문하기", R.drawable.devil))
        dataList.add(DataList2("데빌헬스에게 의견보내기", R.drawable.devil))
        dataList.add(DataList2("데빌헬스에게 버그 신고하기", R.drawable.devil))
        dataList.add(DataList2("데빌헬스 주변 매장 찾기", R.drawable.devil))
        dataList.add(DataList2("데빌헬스 회원되기", R.drawable.devil))

        binding.recyclerview.adapter = CustomRecycleAdapter2(dataList)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.setHasFixedSize(true)
    }
}