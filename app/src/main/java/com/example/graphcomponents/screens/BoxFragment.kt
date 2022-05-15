package com.example.graphcomponents.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.graphcomponents.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment() {
    private lateinit var binding: FragmentBoxBinding

    private val args: BoxFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoxBinding.inflate(inflater, container, false)

        with(binding) {
            val color = args.color
            root.setBackgroundColor(color)

            goBackButton.setOnClickListener {
                findNavController().popBackStack()
            }

            openSecretButton.setOnClickListener {
                findNavController().navigate(BoxFragmentDirections.actionBoxFragmentToSecretFragment())
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

        findNavController().previousBackStackEntry?.savedStateHandle?.set(
            EXTRA_RANDOM_NUMBER,
            number
        )
    }

    companion object {
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}

