package com.example.application.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.application.R

@Composable
fun HomeBanner(
    title: String = "Try three days free trial",
    description: String = "You will get all outfit templates, special textures and details",
    imageUrl: String = "https://pngicon.ru/file/uploads/kofe.png"
) {
    val color1 = Color(0xFF9cffde)
    val color2 = Color(0xFF8e73ff)
    val colorList = arrayOf(
        0.5f to color1,
        1f to color2
    )
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(128.dp)
            .background(Brush.linearGradient(colorStops = colorList))
            .padding(vertical = 8.dp, horizontal = 16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1F),
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            SubcomposeAsyncImage(
                modifier = Modifier.size(112.dp),
                model = imageUrl,
                contentScale = ContentScale.FillWidth,
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBannerPreview() {
    HomeBanner()
}