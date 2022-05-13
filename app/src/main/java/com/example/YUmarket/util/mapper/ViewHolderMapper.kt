package com.example.YUmarket.util.mapper

import com.example.YUmarket.util.provider.ResoucesProvider
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.YUmarket.databinding.*
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.Model
import com.example.YUmarket.screen.base.BaseViewModel
import com.example.YUmarket.widget.adapter.viewholder.ModelViewHolder

import com.example.YUmarket.widget.adapter.viewholder.cs.CSViewHolder
import com.example.YUmarket.widget.adapter.viewholder.home.HomeItemModelViewHolder
import com.example.YUmarket.widget.adapter.viewholder.home.TownMarketViewHolder
import com.example.YUmarket.widget.adapter.viewholder.homemain.NearbyMarketViewHolder
import com.example.YUmarket.widget.adapter.viewholder.homemain.NewSaleItemViewHolder
import com.example.YUmarket.widget.adapter.viewholder.restaurant.RestaurantViewHolder
import com.example.YUmarket.widget.adapter.viewholder.suggest.SuggestViewHolder

object ViewHolderMapper {
    @Suppress("UNCHECKED_CAST")
    fun <M : Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResoucesProvider
    ): ModelViewHolder<M> {

        val inflater = LayoutInflater.from(parent.context)

        return when (type) {
            CellType.HOME_MAIN_MARKET_CELL -> {
                NearbyMarketViewHolder(
                    ViewholderNearbyMarketBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                )
            }

            CellType.HOME_MAIN_ITEM_CELL -> {
                NewSaleItemViewHolder(
                    ViewholderNewSaleItemBinding.inflate(inflater),
                    viewModel, resourcesProvider
                )
            }

            CellType.HOME_TOWN_MARKET_CELL -> {
                TownMarketViewHolder(
                    ViewholderTownMarketBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                )
            }

            CellType.HOME_ITEM_CELL -> {
                HomeItemModelViewHolder(
                    ViewholderHomeItemBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                )
            }

            CellType.CUSTOMER_SERVICE_CELL -> {
                CSViewHolder(
                    ViewholderCsItemBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                )
            }
            CellType.SUGGEST_CELL -> {
                SuggestViewHolder(
                    ViewholderSuggestSeasonBinding.inflate(inflater),
                    viewModel,
                    resourcesProvider
                )
            }



        } as ModelViewHolder<M>

    }



}