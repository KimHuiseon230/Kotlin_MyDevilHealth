package com.example.mydevilhealth.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydevilhealth.R
import com.example.mydevilhealth.customadapter.CustomAdapter
import com.example.mydevilhealth.customadapter.CustomDialog
import com.example.mydevilhealth.databinding.ActivityMain3Binding
import com.example.mydevilhealth.datalist.DataList3
import com.google.android.material.navigation.NavigationView

class MainActivity3 : AppCompatActivity() , View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{
    val binding: ActivityMain3Binding by lazy { ActivityMain3Binding.inflate(layoutInflater) }
    lateinit var dataList: MutableList<DataList3>
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataList = mutableListOf<DataList3>()
        dataList.add(DataList3("복근 운동 기구", "36000", 73, 55, "2023.03.24", R.drawable.android_24dp))
        dataList.add(DataList3("팔 운동 기구", "16000", 41, 13, "2023.04.17", R.drawable.android_24dp))
        dataList.add(DataList3("다리 운동 기구", "56000", 0, 8, "2023.02.29", R.drawable.android_24dp))
        dataList.add(DataList3("허리 운동 기구", "50000", 14, 4, "2023.01.17", R.drawable.android_24dp))

        binding.btnFAB.setOnClickListener(this)
        binding.recyclerView.adapter = CustomAdapter(dataList)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        binding.navigationView.setNavigationItemSelectedListener(this)
        //+++ toolbar
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open, R.string.drawer_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        //+++ toolbar

    } //on Create end
    fun refreshRecyclerView(DataList3: DataList3){
        dataList.add(DataList3)
        binding.recyclerView.adapter?.notifyDataSetChanged()
        Toast.makeText(applicationContext,"해당 물품이 이 추가되었어요!",Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_info ->  {
                val intent: Intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)}
            R.id.item_buy -> { val intent: Intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)}
            R.id.item_q ->{ val intent: Intent = Intent(this, MainActivity4::class.java)
                startActivity(intent)}
            R.id.item_as ->{ val intent: Intent = Intent(this, MainActivity5::class.java)
                startActivity(intent)}
        }
        return false
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnFAB ->{
                val dialog = CustomDialog(this,binding)
                dialog.showDialog()

            }

        }
    }
}