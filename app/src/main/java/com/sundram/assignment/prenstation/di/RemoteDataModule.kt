package com.sundram.assignment.prenstation.di

import com.sundram.assignment.data.api.ApiInterface
import com.sundram.assignment.data.repository.datasource.GetPostRemoteDataSource
import com.sundram.assignment.data.repository.datasourceimpl.GetPostRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun providePostRemoteDataSource(
        newsAPIService: ApiInterface
    ): GetPostRemoteDataSource {
        return GetPostRemoteDataSourceImpl(newsAPIService)
    }

}












