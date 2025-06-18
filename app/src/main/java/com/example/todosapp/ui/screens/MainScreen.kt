package com.example.todosapp.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.todosapp.R
import com.example.todosapp.databinding.MainScreenBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todosapp.data.entity.ToDos
import com.example.todosapp.ui.adapter.ToDosAdapter
import com.example.todosapp.ui.viewmodel.MainViewModel
import kotlin.getValue

class MainScreen : Fragment() {
    private lateinit var binding: MainScreenBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenBinding.inflate(inflater, container, false)

        val toDosList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport","araba")
        val toDo2 = ToDos(2,"Work","yildiz")
        val toDo3 = ToDos(3,"Holiday","semsiye")
        toDosList.add(toDo1,)
        toDosList.add(toDo2)
        toDosList.add(toDo3)

        val toDosAdapter = ToDosAdapter(requireContext(), toDosList)
        binding.recyclerViewToDos.adapter = toDosAdapter

        binding.recyclerViewToDos.layoutManager = LinearLayoutManager(requireContext())



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })


        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.toSaveScreen)
        }


        return binding.root

    }
    fun search(searchText :String){
        Log.e("Search Result",searchText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainScreen Result","Geri dönüldü")

    }
}

