package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.instructions.InstructionsFragmentDirections
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailFragment : Fragment() {
  private var _binding: FragmentShoeDetailBinding? = null
  private val binding get() = _binding!!

  private lateinit var shoeName: String
  private var shoeSize = 0.0
  private lateinit var shoeCompany: String
  private lateinit var shoeDescription: String

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

    binding.saveButton.setOnClickListener {
      if (checkNotEmpty()) {
        val shoeToAdd = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription)

        navigateToShoeListScreen(it, shoeToAdd)
      }
    }

    binding.cancelButton.setOnClickListener {
      view?.findNavController()?.navigateUp()
    }

    return binding.root
  }

    private fun checkNotEmpty(): Boolean{
        if (!binding.detailShoeNameEditText.text.isNullOrEmpty()) {
          shoeName = binding.detailShoeNameEditText.text.toString()
        } else {
          Timber.d("Shoe name can't be null")
          return false
        }

        if (!binding.detailShoeSizeEditText.text.isNullOrEmpty()) {
          shoeSize = binding.detailShoeSizeEditText.text.toString().toDouble()
        } else {
          Timber.d("Shoe size can't be null")
          return false
        }

        if (!binding.detailShoeCompanyEditText.text.isNullOrEmpty()) {
          shoeCompany = binding.detailShoeCompanyEditText.text.toString()
        } else {
          Timber.d("Shoe size can't be null")
          return false
        }

        if (!binding.detailShoeDescriptionEditText.text.isNullOrEmpty()) {
          shoeDescription = binding.detailShoeDescriptionEditText.text.toString()
        } else {
          Timber.d("Shoe size can't be null")
          return false
        }

        return true
    }

  private fun navigateToShoeListScreen(view: View, shoe: Shoe) {
    val navigationAction = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoe)
    view.findNavController().navigate(navigationAction)
  }
}
