package com.udacity.shoestore.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {
    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)

        binding.shoeListDetailButton.setOnClickListener {
            navigateToDetailFragment(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToDetailFragment(view: View) {
        // TODO
    }

}
