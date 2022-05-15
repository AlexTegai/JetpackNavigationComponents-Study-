package com.example.graphcomponents.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.graphcomponents.R
import com.example.graphcomponents.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment() {
    private lateinit var binding: FragmentBoxBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoxBinding.inflate(inflater, container, false)

        with(binding) {
            val color = requireArguments().getInt(ARG_COLOR)
            root.setBackgroundColor(color)

            goBackButton.setOnClickListener {
                findNavController().popBackStack()
            }

            openSecretButton.setOnClickListener {
                findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
            }

            generateNumberButton.setOnClickListener {
                getRandomNumber()
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    private fun getRandomNumber() {
        val number = Random.nextInt(100)

        parentFragmentManager.setFragmentResult(
            REQUEST_CODE,
            bundleOf(EXTRA_RANDOM_NUMBER to number)
        )
    }

    companion object {
        const val ARG_COLOR = "color"

        const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}

