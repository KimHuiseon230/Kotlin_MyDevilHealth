package com.example.mydevilhealth.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hometrainingapp2.datalist.DataList2
import com.example.mydevilhealth.MainActivity
import com.example.mydevilhealth.R
import com.example.mydevilhealth.customadapter.CustomRecycleAdapter2
import com.example.mydevilhealth.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var dataList: MutableList<DataList2>
    lateinit var binding: FragmentThreeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity // 형변환
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dataList = mutableListOf()
        var binding = FragmentThreeBinding.inflate(inflater)
        val layoutManager = LinearLayoutManager(context)

        // ++++ dataList 설정해서 리사이클러 뷰에 값 넣기 start
        with(dataList) {
            add(DataList2("개인 정보",0))
            add(DataList2("이름", R.drawable.android_24dp))
            add(DataList2("성별", R.drawable.android_24dp))
            add(DataList2("일반 설정",0))
            add(DataList2("훈련 휴식", R.drawable.android_24dp))
            add(DataList2("Google 동기화", R.drawable.android_24dp))
            add(DataList2("매일 운동 시간 설정", R.drawable.android_24dp))
            add(DataList2("언어 설정", R.drawable.android_24dp))
            add(DataList2("고객지원", 0))
            add(DataList2("평가하기", R.drawable.android_24dp))
            add(DataList2("피드백", R.drawable.android_24dp))
            add(DataList2("광고배너 삭제", R.drawable.android_24dp))
            add(DataList2("개인정보 정책", R.drawable.android_24dp))
            add(DataList2("탈퇴하기", 0))
            add(DataList2("", 0))
        }
        binding.recyclerview3.adapter = CustomRecycleAdapter2(dataList)
        binding.recyclerview3.layoutManager = layoutManager

        return binding.root
    }
}