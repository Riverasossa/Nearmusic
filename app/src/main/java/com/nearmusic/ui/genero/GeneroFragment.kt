package com.nearmusic.ui.genero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nearmusic.databinding.FragmentGeneroBinding
import com.nearmusic.viewmodel.GeneroViewModel

class GeneroFragment : Fragment() {

private var _binding: FragmentGeneroBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val generoViewModel =
            ViewModelProvider(this).get(GeneroViewModel::class.java)

    _binding = FragmentGeneroBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textHome
    generoViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}