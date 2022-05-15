package com.example.graphcomponents.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.graphcomponents.R
import com.example.graphcomponents.databinding.FragmentSecretBinding

class SecretFragment: Fragment() {
    private lateinit var binding: FragmentSecretBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecretBinding.inflate(inflater, container, false)

        with(binding) {
            closeBoxButton.setOnClickListener {
                findNavController().popBackStack(R.id.rootFragment, false)
            }

            goBackButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        return binding.root
    }
}