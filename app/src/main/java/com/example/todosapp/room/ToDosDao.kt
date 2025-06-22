package com.example.todosapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todosapp.data.entity.ToDos

@Dao
interface ToDosDao { // Dao : Data Access Object

    @Query("SELECT * FROM ToDos")
    suspend fun loadToDos() : List<ToDos>


    @Insert
    suspend fun save(toDo : ToDos)

    @Query("UPDATE ToDos SET name = :name  WHERE id = :id")
    suspend fun update(id: Int, name: String)

    @Delete
    suspend fun delete(toDo : ToDos)

    @Query("SELECT * FROM ToDos WHERE name LIKE '%' || :searchText || '%'")
    suspend fun search(searchText: String) : List<ToDos>



}