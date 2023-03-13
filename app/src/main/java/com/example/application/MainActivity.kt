package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.application.screens.home.HomeModel
import com.example.application.ui.components.HomeBanner
import com.example.application.ui.components.HomeCard
import com.example.application.ui.components.HomeCategory
import com.example.application.ui.theme.JUSTMOBYTheme
import com.example.application.screens.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JUSTMOBYTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    var homeModel by remember {
        mutableStateOf(HomeModel())
    }
    homeViewModel.getGoods {
        homeModel = it
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,

        ) {
        if (homeModel.bannerUrl == null) {
            CircularProgressIndicator(
                modifier = Modifier.padding(128.dp)
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                HomeBanner()
                Spacer(modifier = Modifier.size(16.dp))
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(homeModel.goods ?: arrayListOf()) { goods ->
                        HomeCategory(
                            categoryName = goods.category,
                            onClick = { /*TODO: Some action*/ }
                        ) {
                            LazyRow(modifier = Modifier.fillMaxWidth()) {
                                items(goods.cards) { cardInfo ->
                                    HomeCard(cardInfo = cardInfo)
                                    Spacer(modifier = Modifier.size(8.dp))
                                }
                            }
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
            }
        }
    }
}