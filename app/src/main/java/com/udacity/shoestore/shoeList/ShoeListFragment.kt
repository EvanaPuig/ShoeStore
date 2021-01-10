package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber


class ShoeListFragment : Fragment() {
    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!
    private val args: ShoeListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)

        binding.shoeListDetailButton.setOnClickListener {
            navigateToDetailFragment(it)
        }

        val activity = activity as AppCompatActivity
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val newShoe = args.shoe
        Timber.d("newShoe received: $newShoe")

        if (newShoe != null) {
            val myLayout: LinearLayout = binding.shoeListLinearLayout

            val newShoeView = TextView(context)
            newShoeView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

            newShoeView.text = getString(R.string.shoe_item, newShoe.name, newShoe.company, newShoe.size.toString(), newShoe.description)

            myLayout.addView(newShoeView)
        }

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
