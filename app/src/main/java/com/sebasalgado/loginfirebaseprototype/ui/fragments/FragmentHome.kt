package com.sebasalgado.loginfirebaseprototype.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sebasalgado.loginfirebaseprototype.databinding.FragmentHomeBinding
class FragmentHome : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.includeHome.buttonLogin.setOnClickListener {
            val action = FragmentHomeDirections.actionFragmentHomeToFragmentLogin()
            findNavController().navigate(action)
        }

        binding.includeHome.buttonRegister.setOnClickListener {
            val action = FragmentHomeDirections.actionFragmentHomeToFragmentRegister()
            findNavController().navigate(action)
        }

    }
}