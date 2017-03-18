package com.cdev.showtracker.injection

import android.content.Context
import com.cdev.showtracker.BuildConfig
import com.cdev.showtracker.network.ApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(var baseUrl: String) {

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
        client.interceptors().add(Interceptor {
            chain ->
            var request: Request = chain.request()
            val httpUrl: HttpUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build()
            request = request.newBuilder().url(httpUrl).build()
            chain.proceed(request)
        })
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): ApiService {
        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()

        return retrofit.create(ApiService::class.java)
    }
}
