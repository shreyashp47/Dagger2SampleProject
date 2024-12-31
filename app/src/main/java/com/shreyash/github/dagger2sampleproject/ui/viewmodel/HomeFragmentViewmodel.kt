package com.shreyash.github.dagger2sampleproject.ui.viewmodel

import com.shreyash.github.dagger2sampleproject.data.local.FileStorageService
import com.shreyash.github.dagger2sampleproject.data.remote.NetworkService
import com.shreyash.github.dagger2sampleproject.di.FragmentScope
import javax.inject.Inject


@FragmentScope
class HomeFragmentViewmodel @Inject constructor(
    //private val databaseService: DatabaseService,
    private val networkService: NetworkService,
    private val fileStorageService1: FileStorageService,
    private val fileStorageService2: FileStorageService,
) {

    fun getSomeData(): String {
        return "HomeFragmentViewmodel\n"+
        //" databaseService : " + databaseService.getDummyData() + "\n" +
               // " databaseServiceHashCode : " + databaseService.hashCode() + "\n" +
                " networkService : " + networkService.getDummyData() + "\n" +
                " networkServiceHashCode : " + networkService.hashCode() + "\n" +
                " fileStorageService1HashCode : " + fileStorageService1.hashCode() + "\n" +
                " fileStorageService2HashCode : " + fileStorageService2.hashCode()
    }

}