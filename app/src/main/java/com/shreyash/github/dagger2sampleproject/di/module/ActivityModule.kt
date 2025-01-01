package com.shreyash.github.dagger2sampleproject.di.module

import android.app.Activity
import android.content.Context
import com.shreyash.github.dagger2sampleproject.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

}
