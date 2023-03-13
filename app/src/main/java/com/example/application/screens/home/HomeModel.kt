package com.example.application.screens.home

import com.example.domain.models.Goods

data class HomeModel(
    val bannerUrl: String? = null,
    val goods: ArrayList<Goods>? = arrayListOf()
)
