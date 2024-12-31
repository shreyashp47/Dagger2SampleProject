package com.shreyash.github.dagger2sampleproject.data.remote

import android.content.Context
import com.shreyash.github.dagger2sampleproject.di.ApplicationContext
import com.shreyash.github.dagger2sampleproject.di.NetworkApiKey
import javax.inject.Inject

class NetworkService @Inject constructor(
    private val httpClient: HttpClient,
    @ApplicationContext private val context: Context,
    @NetworkApiKey private val apiKey: String
) {

    fun getDummyData(): String {
        return "NETWORK_DUMMY_DATA"
    }
}