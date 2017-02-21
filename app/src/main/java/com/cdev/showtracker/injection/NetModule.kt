package com.cdev.showtracker.injection

import android.content.Context
import com.cdev.showtracker.network.RestApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(baseUrl: String) {
    var baseUrl: String

    init {
        this.baseUrl = baseUrl
    }

    @Provides
    @Singleton
    fun provideHttpCache(context: Context): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        val cache: Cache = Cache(context.cacheDir, cacheSize)
        return cache
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder: GsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): RestApi {
        var retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()

        return retrofit.create(RestApi::class.java)
    }
}
