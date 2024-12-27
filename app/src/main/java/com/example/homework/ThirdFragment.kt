package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    var _binding: FragmentThirdBinding? = null
    val binding
        get() = _binding ?: throw RuntimeException("Binding = null")

    private val args by navArgs<ThirdFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewText.text = args.text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}