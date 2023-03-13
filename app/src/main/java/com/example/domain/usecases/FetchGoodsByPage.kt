package com.example.domain.usecases

import com.example.domain.models.CardInfo
import com.example.domain.models.Goods
import kotlinx.coroutines.delay

class FetchGoodsByPage(
    // TODO: private val repository: IRepository
) {
    private val cardUrl =
        "https://st.myideasoft.com/idea/eo/89/myassets/products/330/ruyada-gubre-gormek.jpg?revision=1570023966"
    private val iconUrl =
        "https://avatars.mds.yandex.net/i?id=d1a8a9ac3c0c528803f65ceb9a746ac0f1320b4a-8526247-images-thumbs&n=13"

    suspend fun getGoods(): ArrayList<Goods> {
        delay(1000L)
        return arrayListOf(
            Goods(
                category = "Category-1",
                cards = arrayListOf(
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    )
                )
            ),
            Goods(
                category = "Category-2",
                cards = arrayListOf(
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    )
                )
            ),
            Goods(
                category = "Category-3",
                cards = arrayListOf(
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    )
                )
            ),
            Goods(
                category = "Category-4",
                cards = arrayListOf(
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    )
                )
            ),
            Goods(
                category = "Category-5",
                cards = arrayListOf(
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    )
                )
            ),
            Goods(
                category = "Category-6",
                cards = arrayListOf(
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = iconUrl
                    ),
                    CardInfo(
                        imageUrl = cardUrl,
                        iconUrl = null
                    )
                )
            ),
        )
    }
}