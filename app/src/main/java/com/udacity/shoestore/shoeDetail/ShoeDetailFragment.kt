package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoeList.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    private var _binding: FragmentShoeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View {
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        binding.viewModel = ShoeDetailViewModel()

        binding.saveButton.setOnClickListener {
            val newShoe = Shoe(
                binding.viewModel?.getName() ?: "",
                binding.viewModel?.getSize() ?: 0.0,
                binding.viewModel?.getCompany() ?: "",
                binding.viewModel?.getDescription() ?: ""
            )
            viewModel.addShoe(newShoe)
            navigateToShoeListScreen(it)
        }

        binding.cancelButton.setOnClickListener {
          view?.findNavController()?.navigateUp()
        }

        return binding.root
    }

    private fun navigateToShoeListScreen(view: View) {
        val navigationAction = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        view.findNavController().navigate(navigationAction)
    }
}
