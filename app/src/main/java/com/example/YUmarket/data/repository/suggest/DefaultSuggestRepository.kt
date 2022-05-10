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
                "https://picsum.photos/200",
                "필터청소",
                0.7f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "에어컨 수리",
                0.5F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "방문 세차",
                1.2F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
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
                "https://picsum.photos/200",
                "향수",
                0.7F,
                SuggestCategory.BIRTH
                ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "건강",
                0.5F,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "리셀 매장(명품)",
                1.2F,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "IT매장",
                2.5F,
                SuggestCategory.BIRTH
            )
        )
        return mockList
    }

    override fun suggestAnniversary(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "꽃집",
                2.7f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "케이크",
                1.2f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                2,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "파티룸",
                0.9f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "장난감 가게",
                1.5f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "레스토랑",
                1.2f,
                SuggestCategory.ANNIVERSARY
            ),
            SuggestItemModel(
                5,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "쥬얼리",
                1.5f,
                SuggestCategory.ANNIVERSARY
            )
        )
        return mockList
    }

    override fun suggestHobby(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "향수",
                2.7f,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "리셀 매장",
                1.2f,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                2,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                "전자기기",
                0.9f,
                SuggestCategory.BIRTH
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://picsum.photos/200",
                 "건강",
                1.5f,
                SuggestCategory.BIRTH
            ),
        )
        return mockList
    }
}