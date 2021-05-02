package com.example.healtyapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.healtyapp.Helper.SharedPref
import com.example.healtyapp.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    lateinit var s: SharedPref
    lateinit var btn_logout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_account, container, false)
        btn_logout = view.findViewById(R.id.btn_logout)

        s = SharedPref(requireActivity())

        btn_logout.setOnClickListener{
            s.setStatusLogin(false)
        }

        return view

    }

}