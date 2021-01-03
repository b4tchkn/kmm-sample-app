package com.batch.kmm_sample_app.shared.data.local

internal class LocalDataSource(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(driver = databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getAll() {
        dbQuery
    }
}