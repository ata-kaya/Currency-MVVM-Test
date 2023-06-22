package com.kaya.currency.view.ui.fragments

import android.os.Build
import com.kaya.currency.core.api.models.responses.Coins
import com.kaya.currency.databinding.FragmentDetailBinding
import com.kaya.currency.view_model.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {


    override fun initObservers() {

    }

    override fun getViewModelClass() = DetailViewModel::class.java
    override fun setupViews() {
        binding.textDashboard.text = arguments?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable("coin", Coins::class.java)?.name
            } else {
                @Suppress("DEPRECATION")
                (it.getSerializable("coin") as Coins).name
            }
        }
    }


}