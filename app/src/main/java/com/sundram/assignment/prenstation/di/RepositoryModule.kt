package com.sundram.assignment.prenstation.di

import com.sundram.assignment.data.repository.datasource.GetPostRemoteDataSource
import com.sundram.assignment.data.repository.repositoryimpl.RepositoryImpl
import com.sundram.assignment.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        getPostRemoteDataSource: GetPostRemoteDataSource
    ): Repository {
        return RepositoryImpl(
            getPostRemoteDataSource
        )
    }

}














