package com.shreyash.github.dagger2sampleproject.ui.viewmodel

import com.shreyash.github.dagger2sampleproject.data.local.DatabaseService
import com.shreyash.github.dagger2sampleproject.data.remote.NetworkService
import javax.inject.Inject

class MainActivityViewmodel @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {
    fun getSomeData(): String {
        return "MainActivityViewmodel \n" +
                "dsHashCode: " +
                databaseService.hashCode() + "\n" +
                "nsHashCode: " + networkService.hashCode()
    }

}