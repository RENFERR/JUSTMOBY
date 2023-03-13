package com.example.application.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.application.R
import com.example.domain.models.CardInfo

@Composable
fun HomeCard(cardInfo: CardInfo) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier.size(128.dp),
            model = cardInfo.imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null
        ) {
            when(painter.state) {
                is AsyncImagePainter.State.Loading -> CircularProgressIndicator()
                is AsyncImagePainter.State.Error -> Icon(
                    painter = painterResource(id = R.drawable.round_error_outline),
                    tint = MaterialTheme.colorScheme.error,
                    contentDescription = null
                )
                else -> SubcomposeAsyncImageContent()
            }
        }
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            model = cardInfo.iconUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null
        ) {
            when(painter.state) {
                is AsyncImagePainter.State.Loading -> CircularProgressIndicator()
                else -> SubcomposeAsyncImageContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeCardPreview() {
    val cardInfo = CardInfo(
        imageUrl = "https://st.myideasoft.com/idea/eo/89/myassets/products/330/ruyada-gubre-gormek.jpg?revision=1570023966",
        iconUrl = null//"https://avatars.mds.yandex.net/i?id=d1a8a9ac3c0c528803f65ceb9a746ac0f1320b4a-8526247-images-thumbs&n=13"
    )
    HomeCard(cardInfo)
}