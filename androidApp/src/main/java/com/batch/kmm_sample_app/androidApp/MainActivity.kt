package com.batch.kmm_sample_app.androidApp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.kmm_sample_app.androidApp.databinding.ActivityMainBinding
import com.batch.kmm_sample_app.shared.data.repository.TestRepository
import com.batch.kmm_sample_app.shared.data.usecase.SearchActressUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.android.di
import org.kodein.di.instance

class MainActivity : AppCompatActivity(R.layout.activity_main), DIAware {
    override val di: DI by closestDI()

    private val testRepository: TestRepository by instance()
    private val searchActressUseCase: SearchActressUseCase by instance()

    @ExperimentalCoroutinesApi
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(testRepository, searchActressUseCase)
    }
    private lateinit var binding: ActivityMainBinding
    private val actressesRecyclerViewAdapter = ActressesRecyclerViewAdapter(listOf(), this)

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainToolbar.inflateMenu(R.menu.search)
        val searchView =
            binding.mainToolbar.menu.findItem(R.id.menu_search).actionView as SearchView
        searchView.setQuery("上原", false)
        viewModel.searchActress("上原")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (!p0.isNullOrEmpty()) {
                    viewModel.searchActress(p0)
                }
                return true
            }
        })
        binding.mainRecyclerView.adapter = actressesRecyclerViewAdapter
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launchWhenStarted {
            viewModel.actresses.collect {
                actressesRecyclerViewAdapter.actresses = it
                actressesRecyclerViewAdapter.notifyDataSetChanged()
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect {
                binding.mainProgressBar.isVisible = it
            }
        }
    }
}
