package com.shreyash.github.dagger2sampleproject.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shreyash.github.dagger2sampleproject.MyApplication
import com.shreyash.github.dagger2sampleproject.R
import com.shreyash.github.dagger2sampleproject.di.component.DaggerActivityComponent
import com.shreyash.github.dagger2sampleproject.di.module.ActivityModule
import com.shreyash.github.dagger2sampleproject.ui.fragment.BottomFragment
import com.shreyash.github.dagger2sampleproject.ui.fragment.HomeFragment
import com.shreyash.github.dagger2sampleproject.ui.viewmodel.MainActivityViewmodel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = viewModel.getSomeData()

        addHomeFragment()
        addBottomFragment()

    }

    fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, HomeFragment.newInstance("", ""), HomeFragment.TAG)
                .commit()
        }

    }

    fun addBottomFragment() {
        if (supportFragmentManager.findFragmentByTag(BottomFragment.TAG) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.container_fragment2,
                    BottomFragment.newInstance("", ""),
                    BottomFragment.TAG
                )
                .commit()
        }

    }

    fun getDependencies() {
        DaggerActivityComponent
            .builder()
            .applicationComponent((applicationContext as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}