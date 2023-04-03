package com.example.mydevilhealth.fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hometrainingapp2.datalist.DataList
import com.example.mydevilhealth.MainActivity
import com.example.mydevilhealth.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var dataList: MutableList<DataList>
    lateinit var binding: FragmentTwoBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity // 형변환
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var binding = FragmentTwoBinding.inflate(inflater)
        dataList = mutableListOf()

        return binding.root
    }
}