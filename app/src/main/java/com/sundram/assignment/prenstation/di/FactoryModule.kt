package com.sundram.assignment.prenstation.di

import android.app.Application
import com.sundram.assignment.domain.usecases.GetPostUsesCases
import com.sundram.assignment.prenstation.viewmodel.PostViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getPostUsesCases: GetPostUsesCases
    ): PostViewModelFactory {
        return PostViewModelFactory(
            application,
            getPostUsesCases
        )
    }

}








