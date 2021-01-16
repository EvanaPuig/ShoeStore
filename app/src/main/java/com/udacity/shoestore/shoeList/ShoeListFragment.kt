package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
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

        binding.lifecycleOwner = this

        viewModel.listOfShoes.observe(viewLifecycleOwner, { listOfShoes ->
            for( shoe in listOfShoes) {
                val myLayout: LinearLayout = binding.shoeListLinearLayout

                val newShoeView = TextView(context)
                newShoeView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )

                newShoeView.text = getString(R.string.shoe_item, shoe.name, shoe.company, shoe.size.toString(), shoe.description)

                myLayout.addView(newShoeView)
            }
        })

        val activity = activity as AppCompatActivity
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToDetailFragment(view: View) {
        val navigationAction = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        view.findNavController().navigate(navigationAction)
    }

}
