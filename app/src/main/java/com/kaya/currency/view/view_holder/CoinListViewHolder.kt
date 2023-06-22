package com.kaya.currency.view.view_holder

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaya.currency.core.api.models.responses.Coins
import com.kaya.currency.databinding.ItemCoinListBinding
import com.kaya.currency.view.adapter.CoinListAdapter
import kotlin.random.Random

class CoinListViewHolder(
    private val bind: ItemCoinListBinding
) : RecyclerView.ViewHolder(bind.root) {

    fun bindView(coinListModel: Coins, clickListener: CoinListAdapter.ClickListener) {
        Log.d("atakaya", "bindView coinListModel= ${coinListModel.name}")
        bind.apply {
            root.setOnClickListener { clickListener.onClickedItem(root, coinListModel) }
            textPrice.text = coinListModel.price?.substring(0, 8)
            textTitle.text = coinListModel.name
        }

        val color = if (coinListModel.color != null) {
            Color.parseColor(coinListModel.color)
        } else {
            Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        }
        bind.root.setBackgroundColor(color)
    }

    companion object {
        fun onCreate(parent: ViewGroup): CoinListViewHolder {
            Log.w("atakaya", "bindView onCreate")
            return CoinListViewHolder(
                ItemCoinListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                )
            )
        }
    }
}