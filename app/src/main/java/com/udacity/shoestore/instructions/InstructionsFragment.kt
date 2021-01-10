package com.udacity.shoestore.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
  private var _binding: FragmentInstructionsBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentInstructionsBinding.inflate(inflater, container, false)
    val view = binding.root

    binding.instructionsGoShoppingButton.setOnClickListener {
      navigateToShoeListScreen(it)
    }

    return view
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun navigateToShoeListScreen(view: View) {
    val navigationAction = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment(null)
    view.findNavController().navigate(navigationAction)
  }
}
