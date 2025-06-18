package com.example.todosapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todosapp.R
import com.example.todosapp.databinding.UpdateScreenBinding
import com.example.todosapp.ui.viewmodel.UpdateViewModel

class UpdateScreen : Fragment() {
    private lateinit var binding: UpdateScreenBinding
    private lateinit var viewModel: UpdateViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UpdateScreenBinding.inflate(inflater, container, false)

        val bundle: UpdateScreenArgs by navArgs()
        val toDo = bundle.toDo

        binding.imageViewUpdateToDo.setImageResource(
            resources.getIdentifier(toDo.image,"drawable",requireContext().packageName)
        )

        binding.editTextName.setText(toDo.name)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateViewModel by viewModels()
        viewModel = tempViewModel
    }
}