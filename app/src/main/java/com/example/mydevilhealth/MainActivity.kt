package com.example.mydevilhealth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.mydevilhealth.customadapter.CustomViewpagerAdapter
import com.example.mydevilhealth.databinding.ActivityMainBinding
import com.example.mydevilhealth.databinding.UsertabButtonBinding
import com.example.mydevilhealth.fragment.OneFragment
import com.example.mydevilhealth.fragment.ThreeFragment
import com.example.mydevilhealth.fragment.TwoFragment
import com.example.mydevilhealth.intent.MainActivity2
import com.example.mydevilhealth.intent.MainActivity3
import com.example.mydevilhealth.intent.MainActivity4
import com.example.mydevilhealth.intent.MainActivity5
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var customViewpagerAdapter: CustomViewpagerAdapter
    lateinit var tabTitleList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navigation.setNavigationItemSelectedListener(this)
        //+++ toolbar
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.drawer_open,
            R.string.drawer_close
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        //+++ toolbar

        //+++ RecyclerView (Adapter setting) Start
        customViewpagerAdapter = CustomViewpagerAdapter(this)
        customViewpagerAdapter.addListFragment(OneFragment())
        customViewpagerAdapter.addListFragment(TwoFragment())
        customViewpagerAdapter.addListFragment(ThreeFragment())

        tabTitleList = mutableListOf("훈련", "리포트", "설정")
        binding.viewPager2.adapter = customViewpagerAdapter
        //+++ RecyclerView (Adapter setting) End

        //+++ tabLayout 와 viewPager2를 연결  : binding.tabLayout.addTab(tab1)
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tap, position ->
            tap.setCustomView(tabCustomView(position))
        }.attach()
        //+++ tabLayout 와 viewPager2 연결 End*/

        binding.navigation.setNavigationItemSelectedListener(this)



    } // MainActivity End

    // 메뉴에서 토글 버튼을 눌렀을 때 네비게이션 바를 활성화 시켜서 오른쪽, 왼쪽으로 움직일 수 있도록 한다.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_info -> {
                val intent: Intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.item_buy -> {
                val intent: Intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }
            R.id.item_q -> {
                val intent: Intent = Intent(this, MainActivity4::class.java)
                startActivity(intent)
            }
            R.id.item_as -> {
                val intent: Intent = Intent(this, MainActivity5::class.java)
                startActivity(intent)
            }
        }
        return false
    }

    fun tabCustomView(position: Int): View {
        val binding = UsertabButtonBinding.inflate(layoutInflater) // 뷰 바인딩 진행 . 객체가 되었음.
        when (position) {
            0 -> binding.ivICon.setImageResource(R.drawable.excercise)
            1 -> binding.ivICon.setImageResource(R.drawable.statistic)
            2 -> binding.ivICon.setImageResource(R.drawable.user)
        }
        binding.tvTabName.text = tabTitleList.get(position)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.navi_menu, menu)
        val searchMenuItem = menu?.findItem(R.id.menu_search)
        val searchView = searchMenuItem?.actionView as SearchView
        //메뉴에 있는 서치 뷰 가져옴
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 검색 창에 검색 글을 입력하고 엔터를 쳤을 때 콜백함수
                Toast.makeText(applicationContext,"${query}", Toast.LENGTH_SHORT).show()
                return true
            }
            // 검색 창에 검색 글을 입력할 때 마다 콜백발생
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("MainActivity", "${newText}")
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }// oncreate end

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}