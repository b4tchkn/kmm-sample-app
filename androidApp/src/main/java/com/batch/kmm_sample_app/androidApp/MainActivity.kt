package com.batch.kmm_sample_app.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.batch.kmm_sample_app.shared.Greeting
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.data.repository.TestRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val testRepository = TestRepositoryImpl(DatabaseDriverFactory(this))

    @ExperimentalCoroutinesApi
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(testRepository)
    }

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        viewModel.searchActress("佐々木")
        lifecycleScope.launchWhenStarted {
            viewModel.actresses.collect {
                tv.text = it.toString()
                Log.d("faaaaaaaa", it.toString())
            }
        }
    }
}
