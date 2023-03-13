package com.example.di

import com.example.domain.usecases.FetchGoodsByPage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideFetchGoodsByPage() = FetchGoodsByPage()
}