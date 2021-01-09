package com.batch.kmm_sample_app.androidApp

import android.app.Application
import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.sharedModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.provider

class MyApplication  : Application(), DIAware{
    override val di by DI.lazy {
        import(sharedModule)
        bind<DatabaseDriverFactory>() with provider { DatabaseDriverFactory(this@MyApplication) }
    }
}