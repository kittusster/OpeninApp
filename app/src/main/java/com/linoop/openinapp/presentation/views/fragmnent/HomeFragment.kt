package com.linoop.openinapp.presentation.views.fragmnent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.linoop.openinapp.R
import com.linoop.openinapp.data.DashboardData
import com.linoop.openinapp.databinding.HomeFragmentBinding
import com.linoop.openinapp.presentation.viewmodel.MainViewModel
import com.linoop.openinapp.presentation.views.MainActivity
import com.linoop.openinapp.presentation.views.adapter.RecentLinkAdapter
import com.linoop.openinapp.presentation.views.adapter.TopLinkAdapter
import com.linoop.openinapp.utils.Resource

class HomeFragment : Fragment(R.layout.home_fragment) {
    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var context: MainActivity
    private val topLinkAdapter = TopLinkAdapter()
    private val recentLinkAdapter = RecentLinkAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(view)
        context = activity as MainActivity
        viewModel = context.viewModel
        binding.loadingView.visibility = View.GONE
        binding.errorView.visibility = View.GONE
        setupFragment()
    }

    private fun setupFragment() {
        binding.topLink.setOnClickListener { setupTopLink(viewModel.getData.value?.data) }
        binding.recentLink.setOnClickListener { setupRecentLink(viewModel.getData.value?.data) }
        viewModel.getData.observe(context) {
            when (it) {
                is Resource.Error -> {
                    context.showMessage("Error", it.message.toString())
                    binding.loadingView.visibility = View.GONE
                    binding.errorView.visibility = View.VISIBLE
                }
                is Resource.Loading -> {
                    binding.loadingView.visibility = View.VISIBLE
                    binding.errorView.visibility = View.GONE
                }
                is Resource.Success -> {
                    setupRecentLink(it.data)
                    binding.loadingView.visibility = View.GONE
                    binding.errorView.visibility = View.GONE
                }
            }
        }
    }

    private fun setupTopLink(it: DashboardData?) {
        binding.topLink.alpha = 1f
        binding.recentLink.alpha = .5f
        binding.urlList.layoutManager = LinearLayoutManager(requireContext())
        it?.data?.topLinks?.let { list -> topLinkAdapter.setData(list) }
        binding.urlList.hasFixedSize()
        binding.urlList.adapter = topLinkAdapter
    }

    private fun setupRecentLink(it: DashboardData?) {
        binding.topLink.alpha = .5f
        binding.recentLink.alpha = 1f
        binding.urlList.layoutManager = LinearLayoutManager(requireContext())
        it?.data?.recentLinks?.let { list -> recentLinkAdapter.setData(list) }
        binding.urlList.hasFixedSize()
        binding.urlList.adapter = recentLinkAdapter
    }
}