package com.batch.kmm_sample_app.shared.data.repository

import com.batch.kmm_sample_app.shared.CFlow
import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.data.local.LocalDataSource
import com.batch.kmm_sample_app.shared.data.model.SearchActressResponse
import com.batch.kmm_sample_app.shared.data.remote.ActressDataSourceImpl
import com.batch.kmm_sample_app.shared.wrap
import com.batch.kmmsampleapp.shared.local.Launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestRepositoryImpl(databaseDriverFactory: DatabaseDriverFactory) : TestRepository {
    private val localDataSource = LocalDataSource(databaseDriverFactory = databaseDriverFactory)
    private val actressDataSource = ActressDataSourceImpl()

    override suspend fun getAllLaunches(): CFlow<List<Launch>> = localDataSource.getAllLaunches()
    override suspend fun searchActress(searchedKeyWord: String): CFlow<SearchActressResponse> {
        return flow {
            emit(actressDataSource.searchActress(searchedKeyWord))
        }.wrap()
    }
}