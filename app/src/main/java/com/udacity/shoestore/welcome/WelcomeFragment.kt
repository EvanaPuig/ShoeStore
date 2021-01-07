package com.udacity.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.login.LoginFragmentDirections

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.instructionsButton.setOnClickListener {
            navigateToInstructionsFragment(it)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToInstructionsFragment(view: View) {
        val navigationAction = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        view.findNavController().navigate(navigationAction)
    }

}
