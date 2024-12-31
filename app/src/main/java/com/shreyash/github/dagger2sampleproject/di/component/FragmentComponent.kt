package me.amitshekhar.dagger.learning.di.component

import com.shreyash.github.dagger2sampleproject.di.FragmentScope
import com.shreyash.github.dagger2sampleproject.di.module.FragmentModule
import com.shreyash.github.dagger2sampleproject.ui.fragment.BottomFragment
import com.shreyash.github.dagger2sampleproject.ui.fragment.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)

    fun inject(fragment: BottomFragment)

}
