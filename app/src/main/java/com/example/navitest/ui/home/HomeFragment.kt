package com.example.navitest.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navitest.R
import com.example.navitest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TAG", "HomeFragment onCreateView")
        val fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "HomeFragment onViewCreated")


        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = homeViewModel
            homeFragment = this@HomeFragment
        }
        Log.d("TAG", "HomeFragment onViewCreated2")
    }

    fun goToNextScreen(position: Int){

        setFragmentResult("REQUEST_KEY", bundleOf("KEY" to position))
        Log.d("TAG", "HomeFragment position: $position")
        findNavController().navigate(R.id.action_nav_home_to_homeFragment2)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "HomeFragment onDestroyView")
        binding = null
    }
}