package com.shreyash.github.dagger2sampleproject.di.component

import com.shreyash.github.dagger2sampleproject.di.ActivityScope
import com.shreyash.github.dagger2sampleproject.di.module.ActivityModule
import com.shreyash.github.dagger2sampleproject.ui.activity.MainActivity
import dagger.Component
import me.amitshekhar.dagger.learning.di.component.ApplicationComponent

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}
