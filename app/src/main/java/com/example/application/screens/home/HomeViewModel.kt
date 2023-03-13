package com.example.application.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.FetchGoodsByPage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: FetchGoodsByPage,
) : ViewModel() {

    fun getGoods(callback: (HomeModel) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            callback.invoke(
                HomeModel(
                    bannerUrl = "https://elitextile.ru/image/cache/catalog/import_files/25/25ffce6d-9e66-4d02-bb40-3098612f5708_70d6c3e0-bada-11e7-b039-00155d01f001-700x700.png",
                    goods = useCase.getGoods()
                )
            )
        }
    }
}