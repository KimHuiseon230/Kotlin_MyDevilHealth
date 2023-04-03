package com.example.mydevilhealth.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.mydevilhealth.R
import com.example.mydevilhealth.databinding.ActivityMain2Binding
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val binding: ActivityMain2Binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.navigationView.setNavigationItemSelectedListener(this)
        //+++ toolbar
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open, R.string.drawer_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        //+++ toolbar
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
}


