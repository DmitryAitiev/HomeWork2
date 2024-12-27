package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.homework.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchSecondFragment()
    }

    private fun launchSecondFragment() {
        with(binding) {
            btnNext.setOnClickListener {
                if (checkInputText())
                    navigateSecondFragment(editTextWord.text.trim().toString())
            }
        }
    }

    private fun navigateSecondFragment(text: String) {
        findNavController().navigate(
            FirstFragmentDirections.actionFirstFragmentToSecondFragment(text)
        )
    }

    private fun checkInputText(): Boolean {
        with(binding) {
            if (editTextWord.text.isBlank()) {
                Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                return false
            }
            else
                return true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}