package com.sundram.assignment.prenstation.di

import com.sundram.assignment.domain.repository.Repository
import com.sundram.assignment.domain.usecases.GetPostUsesCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetPostUseCase(
        newsRepository: Repository
    ): GetPostUsesCases {
        return GetPostUsesCases(newsRepository)
    }

}


















