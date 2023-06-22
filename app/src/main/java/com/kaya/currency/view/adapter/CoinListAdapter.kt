package com.kaya.currency.view.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaya.currency.core.api.models.responses.Coins
import com.kaya.currency.view.view_holder.CoinListViewHolder

class CoinListAdapter(
    private val data: ArrayList<Coins>,
    private val clickListener: ClickListener,
) : RecyclerView.Adapter<CoinListViewHolder>() {

    fun interface ClickListener {
        fun onClickedItem(view: View, coins: Coins)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        Log.d("atakaya", "onCreateViewHolder viewType= $viewType")
        return CoinListViewHolder.onCreate(parent)
    }

    override fun getItemCount(): Int {
        Log.d("atakaya", "getItemCount ${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        Log.d("atakaya", "onBindViewHolder position= $position")
        when (holder) {
            is CoinListViewHolder -> {
                holder.bindView(data[position], clickListener)
            }
        }
    }
}