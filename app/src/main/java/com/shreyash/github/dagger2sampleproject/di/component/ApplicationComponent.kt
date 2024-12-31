package me.amitshekhar.dagger.learning.di.component

import android.content.Context
import com.shreyash.github.dagger2sampleproject.MyApplication
import com.shreyash.github.dagger2sampleproject.data.local.FileStorageService
import com.shreyash.github.dagger2sampleproject.data.remote.NetworkService
import com.shreyash.github.dagger2sampleproject.di.ApplicationContext
import com.shreyash.github.dagger2sampleproject.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

   // fun getDatabaseService(): DatabaseService

    fun getFileStorageService(): FileStorageService

}
