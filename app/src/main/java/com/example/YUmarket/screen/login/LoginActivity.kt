package com.example.YUmarket.screen.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.YUmarket.R
import com.example.YUmarket.databinding.ActivityLoginBinding
import com.example.YUmarket.screen.base.BaseActivity

class LoginActivity :BaseActivity<ActivityLoginBinding>(){


    private lateinit var bindings : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = DataBindingUtil.setContentView(this, R.layout.activity_login)
    }


    override fun getViewBinding(): ActivityLoginBinding  =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun observeData() {}











}