package com.shreyash.github.dagger2sampleproject

import android.app.Application
import com.shreyash.github.dagger2sampleproject.data.remote.NetworkService
import com.shreyash.github.dagger2sampleproject.di.module.ApplicationModule
import me.amitshekhar.dagger.learning.di.component.ApplicationComponent
import me.amitshekhar.dagger.learning.di.component.DaggerApplicationComponent

import javax.inject.Inject

class MyApplication : Application() {


    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var networkService: NetworkService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}