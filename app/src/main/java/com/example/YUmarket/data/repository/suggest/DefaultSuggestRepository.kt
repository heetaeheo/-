package com.example.YUmarket.data.repository.suggest

import com.example.YUmarket.R
import com.example.YUmarket.model.CellType
import com.example.YUmarket.model.homelist.SuggestItemModel
import com.example.YUmarket.model.homelist.category.SuggestCategory

class DefaultSuggestRepository : SuggestRepository {


    override fun seasonMarket(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                6,
                CellType.SUGGEST_CELL,
               "https://velog.velcdn.com/images/heetaeheo/post/92f2b5e7-55b0-4ad9-9d92-fdf617c3ce14/image.png",
                "봄",
                0f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/79cff16b-4e9a-456d-86d8-cc189a5fb6a0/image.jpg",
                "필터청소",
                0.7f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/8beb62c0-1455-467d-9411-b2b53c4502e9/image.jpg",
                "에어컨 수리",
                0.5F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/eb96be15-184e-494d-addb-16c84d4e8418/image.jpg",
                "방문 세차",
                1.2F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/4109fcdf-df3a-4e6c-9653-2d7df4da9554/image.jpg",
                "이사",
                2.5F,
                SuggestCategory.SEASON_SPRING
            )
        )
        return mockList
    }

    override fun fixMarket(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                6,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/92f2b5e7-55b0-4ad9-9d92-fdf617c3ce14/image.png",
                "봄",
                0f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/79cff16b-4e9a-456d-86d8-cc189a5fb6a0/image.jpg",
                "필터청소",
                0.7f,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/8beb62c0-1455-467d-9411-b2b53c4502e9/image.jpg",
                "에어컨 수리",
                0.5F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/eb96be15-184e-494d-addb-16c84d4e8418/image.jpg",
                "방문 세차",
                1.2F,
                SuggestCategory.SEASON_SPRING
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/4109fcdf-df3a-4e6c-9653-2d7df4da9554/image.jpg",
                "이사",
                2.5F,
                SuggestCategory.SEASON_SPRING
            )
        )
        return mockList
    }
/*
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
    } */

    override fun suggestHobby(): List<SuggestItemModel> {
        val mockList = listOf(
            SuggestItemModel(
                0,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/d39565b9-b914-4e4b-8a20-ba6bc891f72e/image.jpg",
                "노래 레슨",
                2.7f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                1,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/ffbfe8ea-c718-476e-a9bb-dc480d0b97dd/image.jpg",
                "골프",
                1.2f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                2,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/e4b188ef-97bd-42cf-8f10-a0a47a3a23df/image.jpg",
                "영상 편집",
                0.9f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                3,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/834ea989-a13d-4705-8ea0-d58b724c60ba/image.jpg",
                 "요리 교실",
                1.5f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                4,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/4b17ae0e-088a-41a3-9e2c-cb9e6775fef4/image.jpg",
                "헬스",
                3.5f,
                SuggestCategory.HOBBY
            ),
            SuggestItemModel(
                5,
                CellType.SUGGEST_CELL,
                "https://velog.velcdn.com/images/heetaeheo/post/f207d53b-3cff-4fb7-aeed-1d07fb2b65d7/image.jpg",
                "필라테스",
                0.4f,
                SuggestCategory.HOBBY
            ),
        )
        return mockList
    }
}