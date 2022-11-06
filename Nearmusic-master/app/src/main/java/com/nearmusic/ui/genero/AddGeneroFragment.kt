package com.nearmusic.ui.genero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.nearmusic.databinding.FragmentAddGeneroBinding
import com.nearmusic.databinding.FragmentGeneroBinding
import com.nearmusic.viewmodel.GeneroViewModel

class AddGeneroFragment : Fragment() {

    private var _binding: FragmentAddGeneroBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val generoViewModel =
            ViewModelProvider(this).get(GeneroViewModel::class.java)

        _binding = FragmentAddGeneroBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}