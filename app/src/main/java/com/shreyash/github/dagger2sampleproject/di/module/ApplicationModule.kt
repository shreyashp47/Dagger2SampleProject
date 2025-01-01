package com.shreyash.github.dagger2sampleproject.di.module

import android.content.Context
import com.shreyash.github.dagger2sampleproject.MyApplication
import com.shreyash.github.dagger2sampleproject.data.local.FileStorageService
import com.shreyash.github.dagger2sampleproject.data.remote.HttpClient
import com.shreyash.github.dagger2sampleproject.di.ApplicationContext
import com.shreyash.github.dagger2sampleproject.di.DatabaseName
import com.shreyash.github.dagger2sampleproject.di.DatabaseVersion
import com.shreyash.github.dagger2sampleproject.di.NetworkApiKey
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext() : Context{
        return application
    }

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient()
    }

    @Provides
    @DatabaseName
    fun provideDatabaseName(): String = "dummy_db"

    @Provides
    @DatabaseVersion
    fun provideDatabaseVersion(): Int = 1

    @Provides
    @NetworkApiKey
    fun provideApiKey(): String = "SOME_API_KEY"

    @Singleton
    @Provides
    fun provideFileStorageService() : FileStorageService {
        return FileStorageService()
    }
}