package com.example.YUmarket.screen.home.suggest

import androidx.navigation.Navigation
import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentSuggestBinding
import com.example.YUmarket.screen.base.BaseFragment

class HomeSuggestFragement : BaseFragment<FragmentSuggestBinding>() {


    override fun getViewBinding(): FragmentSuggestBinding =
        FragmentSuggestBinding.inflate(layoutInflater)

    override fun observeData() {}


    override fun initViews() = with(binding) {
        super.initViews()

        val nameData = arguments?.getString("data")
        name.text = nameData?.toString()


        binding.back.setOnClickListener {
            view?.let { it ->
                Navigation.findNavController(it)
                    .navigate(R.id.action_homeSuggestFragement_to_homeMainFragment)
            }
        }
    }



    private fun backStack() {
        view?.let { it1 ->
            Navigation.findNavController(it1).popBackStack()
        }

    }
}