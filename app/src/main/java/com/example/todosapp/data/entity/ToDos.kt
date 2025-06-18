package com.example.todosapp.data.entity

import java.io.Serializable

data class ToDos(var id: Int,
                 var name: String,
                 var image: String) : Serializable {
}