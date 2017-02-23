package com.cdev.showtracker.data

import com.cdev.showtracker.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowRepositoryModule {

    @Provides
    @Singleton
    fun provideTvShowRepository(remoteDataSource: TvShowRemoteDataSource): TvShowRepository {
        return TvShowRepository(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideTvShowRemoteDataSource(apiService: ApiService): TvShowRemoteDataSource {
        return TvShowRemoteDataSource(apiService)
    }
}