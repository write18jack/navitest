package com.example.navitest.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.navitest.R
import com.example.navitest.databinding.FragmentHome2Binding

class HomeFragment2 : Fragment() {

    private var binding: FragmentHome2Binding? = null
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentHome2Binding.inflate(inflater, container, false)
        binding = fragmentBinding
        // Inflate the layout for this fragment
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(
            "REQUEST_KEY"
        ){_, bundle ->
            val id = bundle.getInt("KEY")
            Log.d("TAG",  "HomeFragment2 id: $id")
            homeViewModel.setPosiId(id)
        }

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = homeViewModel
            homeFragment2 = this@HomeFragment2
        }
    }

    fun backToHomeFragment(player:Int){

        homeViewModel.setUserId(player.toString())
        Log.d("TAG", "HomeFragment2 player: $player")
        findNavController().navigate(R.id.action_homeFragment2_to_nav_home)
        homeViewModel.positionSelect()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG","HomeFragment2 onDestroyView" )
        binding= null
    }

}