package com.cdev.showtracker.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
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
    fun provideTvShowRemoteDataSource(retrofit: Retrofit): TvShowRemoteDataSource {
        return TvShowRemoteDataSource(retrofit)
    }
}