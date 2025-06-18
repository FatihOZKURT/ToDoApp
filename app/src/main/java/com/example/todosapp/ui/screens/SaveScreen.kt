package com.example.todosapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todosapp.R
import com.example.todosapp.databinding.SaveScreenBinding
import com.example.todosapp.ui.viewmodel.SaveViewModel
import com.example.todosapp.ui.viewmodel.UpdateViewModel
import kotlin.getValue

class SaveScreen : Fragment() {
    private lateinit var binding: SaveScreenBinding
    private lateinit var image: String
    private lateinit var viewModel: SaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SaveScreenBinding.inflate(inflater, container, false)

        //this - this@SaveScreen - requireContext() - applicationContext

        val images = listOf("agac","araba","cicek","damla","gezegen","gunes","roket","semsiye","simsek","yildiz")

        image = images.random()

        binding.imageViewSaveToDo.setImageResource(
            resources.getIdentifier(image,"drawable",requireContext().packageName)
        )

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            save(name,image)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun save(name:String,image:String){
        Log.e("Save Result","$name - $image")
    }
}

