package com.example.todosapp.ui.viewmodel

import android.R.attr.name
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todosapp.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(var toDosRepository: ToDosRepository)  : ViewModel() {


    fun save(name: String, image: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.save(name, image)
        }
    }





}


