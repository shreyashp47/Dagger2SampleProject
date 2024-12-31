package com.shreyash.github.dagger2sampleproject.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DatabaseName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DatabaseVersion

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkApiKey