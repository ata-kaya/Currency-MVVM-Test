package com.kaya.currency.view.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaya.currency.R
import com.kaya.currency.core.api.models.responses.Coins
import com.kaya.currency.databinding.FragmentDashboardBinding
import com.kaya.currency.view.adapter.CoinListAdapter
import com.kaya.currency.view_model.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>(
    FragmentDashboardBinding::inflate
) {
    override fun initObservers() {
        viewModel.getCoins(viewLifecycleOwner)
    }

    override fun getViewModelClass() = DashboardViewModel::class.java

    override fun setupViews() {
        viewModel.coins.observe(viewLifecycleOwner) {
            Log.w("atakaya", " list is ${it[0].name}")
            fillRecyclerView(it)
        }
    }

    private fun fillRecyclerView(coinList: ArrayList<Coins>?) {
        coinList?.let {
            val lp = LinearLayoutManager(
                context
            )
            lp.orientation = LinearLayoutManager.VERTICAL
            binding.recyclerViewCoinList.apply {
                isNestedScrollingEnabled = true
                adapter = CoinListAdapter(it) { view, coin ->
                    Log.w("atakaya", "item clicked!! ${coin.name}")
                    view.findNavController().apply {
                        val bundle = Bundle().apply {
                            putSerializable("coin", coin)
                        }
                        navigate(
                            R.id.navigation_detail, bundle
                        )
                    }
                }
                setHasFixedSize(false)
                layoutManager = lp
            }
        }
    }

}