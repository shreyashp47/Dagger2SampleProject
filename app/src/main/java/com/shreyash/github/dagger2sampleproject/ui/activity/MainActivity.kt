package com.shreyash.github.dagger2sampleproject.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shreyash.github.dagger2sampleproject.R
import com.shreyash.github.dagger2sampleproject.ui.fragment.BottomFragment
import com.shreyash.github.dagger2sampleproject.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
}