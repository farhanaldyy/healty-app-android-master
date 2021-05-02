package com.example.healtyapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healtyapp.Helper.SharedPref
import com.example.healtyapp.R
import kotlinx.android.synthetic.main.activity_masuk.*

class MasukActivity : AppCompatActivity() {

    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)

        mainButton()

    }

    private fun mainButton() {
        btn_login.setOnClickListener{
            s.setStatusLogin(true)
        }

        btn_register.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

}