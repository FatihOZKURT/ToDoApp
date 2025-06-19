package com.example.todosapp.room

import androidx.room.Dao
import androidx.room.Query
import com.example.todosapp.data.entity.ToDos

@Dao
interface ToDosDao { // Dao : Data Access Object

    @Query("SELECT * FROM toDos")
    suspend fun loadToDos() : List<ToDos>




}