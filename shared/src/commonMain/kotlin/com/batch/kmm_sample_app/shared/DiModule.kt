package com.batch.kmm_sample_app.shared

import com.batch.kmm_sample_app.shared.data.local.AppDatabase
import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.data.remote.ActressDataSource
import com.batch.kmm_sample_app.shared.data.remote.ActressDataSourceImpl
import com.batch.kmm_sample_app.shared.data.repository.ActressRepository
import com.batch.kmm_sample_app.shared.data.repository.ActressRepositoryImpl
import com.batch.kmm_sample_app.shared.data.repository.TestRepository
import com.batch.kmm_sample_app.shared.data.repository.TestRepositoryImpl
import com.batch.kmm_sample_app.shared.data.usecase.SearchActressUseCase
import com.squareup.sqldelight.db.SqlDriver
import org.kodein.di.*

val sharedModule = DI.Module("shared") {
    bind<SqlDriver>() with provider { instance<DatabaseDriverFactory>().createDriver() }
    bind<AppDatabase>() with singleton { AppDatabase(instance()) }

    bind<TestRepository>() with provider { TestRepositoryImpl(instance()) }

    bind<ActressDataSource>() with provider { ActressDataSourceImpl() }
    bind<ActressRepository>() with provider { ActressRepositoryImpl(instance()) }
    bind<SearchActressUseCase>() with provider { SearchActressUseCase(instance()) }
}