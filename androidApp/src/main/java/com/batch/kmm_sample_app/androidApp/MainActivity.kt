package com.batch.kmm_sample_app.androidApp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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

        binding.mainToolbar.inflateMenu(R.menu.search)
        val searchView =
            binding.mainToolbar.menu.findItem(R.id.menu_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                Log.d("activityMain", "Change${p0}")
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (!p0.isNullOrEmpty()) {
                    viewModel.searchActress(p0)
                }
                return true
            }
        })
        lifecycleScope.launchWhenStarted {
            viewModel.actresses.collect {
                binding.textView.text = it.toString()
            }
        }
    }
}
