package com.example.domain.repository

import com.example.domain.models.Goods

interface IRepository {
    suspend fun getGoods(): ArrayList<Goods>
}