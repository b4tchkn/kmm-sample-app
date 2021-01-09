package com.batch.kmm_sample_app.shared

import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.data.repository.TestRepository
import com.batch.kmm_sample_app.shared.data.usecase.SearchActressUseCase
import org.kodein.di.*

class Injector {
    private val container = DI.lazy {
        import(sharedModule)
        import(iosModule)
    }

    private val iosModule = DI.Module("iosModule") {
        bind<DatabaseDriverFactory>() with provider { DatabaseDriverFactory() }
    }

    fun testRepository(): TestRepository = container.direct.instance()
    fun searchActressUseCase(): SearchActressUseCase = container.direct.instance()
}