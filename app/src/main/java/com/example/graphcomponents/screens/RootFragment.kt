package com.example.graphcomponents.screens

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.graphcomponents.R
import com.example.graphcomponents.databinding.FragmentRootBinding

class RootFragment : Fragment() {
    private lateinit var binding: FragmentRootBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRootBinding.inflate(inflater, container, false)

        with(binding) {
            openLagoonBoxButton.setOnClickListener {
                openBox(Color.rgb(200,255,200))
            }

            openSandBoxButton.setOnClickListener {
                openBox(Color.rgb(255,255,200))
            }
        }

        parentFragmentManager.setFragmentResultListener(
            BoxFragment.REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(
                requireContext(),
                "Generated Number: $number",
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }

    private fun openBox(color: Int) {
        findNavController().navigate(
            R.id.action_rootFragment_to_boxFragment,
            bundleOf(BoxFragment.ARG_COLOR to color)
        )
    }


}