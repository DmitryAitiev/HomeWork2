package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("Binding = null")

    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchThirdFragment()
    }

    private fun launchThirdFragment() {
        with(binding) {
            textViewText.text = args.text
            btnNext.setOnClickListener {
                if (checkInputText())
                    navigateThirdFragment(editTextWord.text.trim().toString())
            }
        }
    }

    private fun navigateThirdFragment(text: String) {
        findNavController().navigate(
            SecondFragmentDirections.actionSecondFragmentToThirdFragment(text)
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