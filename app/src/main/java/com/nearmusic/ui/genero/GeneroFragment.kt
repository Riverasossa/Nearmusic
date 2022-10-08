package com.nearmusic.ui.genero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nearmusic.R
import com.nearmusic.databinding.FragmentGeneroBinding
import com.nearmusic.viewmodel.GeneroViewModel

class GeneroFragment : Fragment() {

private var _binding: FragmentGeneroBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val generoViewModel =
            ViewModelProvider(this).get(GeneroViewModel::class.java)

    _binding = FragmentGeneroBinding.inflate(inflater, container, false)

    binding.addGeneroFabButton.setOnClickListener{

        findNavController().navigate(R.id.action_nav_genero_to_addGeneroFragment)

    }

    return binding.root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}