package com.example.YUmarket.screen.login

import com.example.YUmarket.databinding.FragmentSignupBinding
import com.example.YUmarket.screen.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignupBinding>() {





    override fun getViewBinding(): FragmentSignupBinding =
        FragmentSignupBinding.inflate(layoutInflater)

    override fun observeData() {}
}