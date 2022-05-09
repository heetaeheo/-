package com.example.YUmarket.data.repository.suggest

import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.homelist.SuggestItemModel
import com.example.YUmarket.model.homelist.category.SuggestCategory

class DefaultSuggestRepository : SuggestRepository {


    override fun seasonMarket(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "봄",
                0.7F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "건강",
                0.5F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "리셀 매장(명품)",
                1.2F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "IT매장",
                2.5F,
                SuggestCategory.SEASON_SPRING
            )
        )
        return mockList
    }

    override fun suggestBirth(): List<SuggestItemModel> {

        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "향수",
                0.7F,
                SuggestCategory.BIRTH
                ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "건강",
                0.5F,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "리셀 매장(명품)",
                1.2F,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "IT매장",
                2.5F,
                SuggestCategory.BIRTH
            )
        )
        return mockList
    }

    override fun findItemByCategory(suggestCategory: SuggestCategory): List<SuggestItemModel> {
        TODO("Not yet implemented")
    }

    override fun suggestAnniversary(): List<SuggestItemModel> {
        TODO("Not yet implemented")
    }

    override fun suggestHobby(): List<SuggestItemModel> {
        TODO("Not yet implemented")
    }
}