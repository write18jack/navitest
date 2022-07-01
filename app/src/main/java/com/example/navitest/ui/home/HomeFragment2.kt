package com.example.navitest.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.navitest.R
import com.example.navitest.databinding.FragmentHome2Binding

class HomeFragment2 : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHome2Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHome2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageButton: ImageButton = binding.griezmann
        homeViewModel.griezmann.observe(viewLifecycleOwner, Observer {
            imageButton.setBackgroundResource(it)
        })

        // Inflate the layout for this fragment
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}