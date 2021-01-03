package com.batch.kmm_sample_app.shared.data.repository

import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.data.local.LocalDataSource
import com.batch.kmmsampleapp.shared.local.Launch
import kotlinx.coroutines.flow.Flow

class TestRepositoryImpl(databaseDriverFactory: DatabaseDriverFactory) : TestRepository {
    private val localDataSource = LocalDataSource(databaseDriverFactory = databaseDriverFactory)

    override suspend fun getAllLaunches(): Flow<List<Launch>> = localDataSource.getAllLaunches()
}