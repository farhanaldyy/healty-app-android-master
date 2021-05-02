package com.example.healtyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.healtyapp.Activity.MasukActivity
import com.example.healtyapp.Fragment.AccountFragment
import com.example.healtyapp.Fragment.HomeFragment
import com.example.healtyapp.Fragment.PoliFragment
import com.example.healtyapp.Helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome : Fragment = HomeFragment()
    val fragmentPoli : Fragment = PoliFragment()
    val fragmentAccount : Fragment = AccountFragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem : MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var setStatusLogin = false

    // validasi sharedprefences
    private lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setBottomNav()

    }

    fun setBottomNav() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentPoli).show(fragmentPoli).commit()
        fm.beginTransaction().add(R.id.container, fragmentAccount).show(fragmentAccount).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_home -> {
                     callFragment(0, fragmentHome)
                }
                R.id.navigation_poli -> {
                    callFragment(1, fragmentPoli)
                }
                R.id.navigation_account -> {
                    if (s.getStatusLogin()) {
                        callFragment(2, fragmentAccount)
                    } else {
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }
            false
        }

    }

    fun callFragment(int : Int , fragment: Fragment){

        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }

}