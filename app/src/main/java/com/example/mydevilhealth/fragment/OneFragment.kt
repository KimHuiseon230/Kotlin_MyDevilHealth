package com.example.mydevilhealth.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hometrainingapp2.datalist.DataList
import com.example.mydevilhealth.MainActivity
import com.example.mydevilhealth.R
import com.example.mydevilhealth.customadapter.CustomRecycleAdapter
import com.example.mydevilhealth.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var dataList: MutableList<DataList>
    lateinit var binding: FragmentOneBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var binding = FragmentOneBinding.inflate(inflater)
        dataList = mutableListOf()
        // ++++ dataList 설정해서 리사이클러 뷰에 값 넣기 start
        with(dataList) {
            add(DataList("전신 운동 3분", "", "3분", R.drawable.img001))
            add(DataList("취짐 전 스트레칭 5분", "", "5분", R.drawable.img002))
            add(DataList("건강한 복근 만들기 5분", "필요한 장비", "5분", R.drawable.img003))
            add(DataList("신체 강화 플랜1", "필요한 장비", "7분", R.drawable.img004))
            add(DataList("신체 강화 플랜2", "필요한 장비", "7분", R.drawable.img004))
            add(DataList("건강한 팔 만들기 5분", "", "5분", R.drawable.img005))
            add(DataList("다리 운동 10분", "", "10분", R.drawable.img006))
            add(DataList("엉덩이 운동 10분", "", "10분", R.drawable.android_24dp))
            add(DataList("하체 운동 5분", "", "5분", R.drawable.android_24dp))
        }
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = CustomRecycleAdapter(dataList)
        binding.recyclerview.layoutManager = layoutManager
        return binding.root
    }

}