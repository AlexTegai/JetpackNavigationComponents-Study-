package com.example.graphcomponents.screens

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            openGreenBoxButton.setOnClickListener {
                openBox(Color.rgb(200, 255, 200), getString(R.string.green_box))
            }

            openYellowBoxButton.setOnClickListener {
                openBox(Color.rgb(255, 255, 200), getString(R.string.yellow_box))
            }
        }

        val liveData = findNavController().currentBackStackEntry?.savedStateHandle
            ?.getLiveData<Int>(BoxFragment.EXTRA_RANDOM_NUMBER)

        liveData?.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.generated_number, it),
                    Toast.LENGTH_SHORT
                ).show()

                liveData.value = null
            }
        }

        return binding.root
    }

    private fun openBox(color: Int, boxName: String) {
        val directions = RootFragmentDirections.actionRootFragmentToBoxFragment(color, boxName)

        findNavController().navigate(directions)
    }

}