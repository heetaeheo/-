package com.example.YUmarket.screen.home.suggest

import android.content.Intent
import com.example.YUmarket.databinding.ActivitySuggestBinding
import com.example.YUmarket.screen.MainActivity
import com.example.YUmarket.screen.base.BaseActivity

class HomeSuggestActivity : BaseActivity<ActivitySuggestBinding>() {

    override fun getViewBinding(): ActivitySuggestBinding =
        ActivitySuggestBinding.inflate(layoutInflater)

    override fun observeData() {}


    override fun initViews() = with(binding) {
        super.initViews()

        val nameData = intent.getStringExtra("data")
        name.text = nameData?.toString()

        back.setOnClickListener {
            val mainIntent = Intent(this@HomeSuggestActivity,MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}