package com.batch.kmm_sample_app.shared.data.local

import com.batch.kmmsampleapp.shared.local.Launch
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

internal class LocalDataSource(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(driver = databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getAllLaunches(): Flow<List<Launch>> =
        dbQuery.selectAllLaunches().asFlow().mapToList()
}