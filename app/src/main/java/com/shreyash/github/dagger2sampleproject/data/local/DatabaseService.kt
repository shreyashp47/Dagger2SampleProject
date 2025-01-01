package com.shreyash.github.dagger2sampleproject.data.local

import android.content.Context
import com.shreyash.github.dagger2sampleproject.di.ApplicationContext
import com.shreyash.github.dagger2sampleproject.di.DatabaseName
import com.shreyash.github.dagger2sampleproject.di.DatabaseVersion
import javax.inject.Inject

class DatabaseService @Inject constructor(
    @ApplicationContext private val context: Context,
    @DatabaseName private val databaseName: String,
    @DatabaseVersion private val databaseVersion: Int

) {

    fun getDummyData(): String {
        return "DATABASE_DUMMY_DATA"
    }
}