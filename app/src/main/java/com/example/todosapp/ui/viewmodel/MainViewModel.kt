package com.example.todosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todosapp.data.repo.ToDosRepository

class MainViewModel: ViewModel() {

    var toDosRepository = ToDosRepository()


}