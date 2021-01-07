package com.batch.kmm_sample_app.androidApp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.batch.kmm_sample_app.androidApp.databinding.ActivityMainBinding
import com.batch.kmm_sample_app.shared.data.local.DatabaseDriverFactory
import com.batch.kmm_sample_app.shared.data.repository.TestRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val testRepository = TestRepositoryImpl(DatabaseDriverFactory(this))

    @ExperimentalCoroutinesApi
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(testRepository)
    }
    private lateinit var binding: ActivityMainBinding

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.searchActress("佐々木")

        lifecycleScope.launchWhenStarted {
            viewModel.actresses.collect {
                binding.textView.text = it.toString()
            }
        }
    }
}
