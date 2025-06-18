package com.example.todosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todosapp.data.repo.ToDosRepository

class SaveViewModel: ViewModel() {

    var toDosRepository = ToDosRepository()

}