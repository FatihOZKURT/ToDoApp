package com.example.todosapp.data.datasource

import android.R
import android.R.attr.name
import android.util.Log
import android.util.Log.w
import com.example.todosapp.data.entity.ToDos
import com.example.todosapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {


    suspend fun save(name:String,image:String){
        Log.e("Save Result","$name - $image")
    }

    suspend fun update(id: Int, name: String){
        Log.e("Update Result","$id - $name")
    }

    suspend fun delete(id : Int){
        Log.e("Delete Result",id.toString())

    }

    suspend fun loadToDos() : List<ToDos> = withContext(Dispatchers.IO){
        return@withContext toDosDao.loadToDos()
    }

    suspend fun search(searchText :String): List<ToDos> = withContext(Dispatchers.IO){
        val toDosList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport","araba")
        toDosList.add(toDo1,)


        return@withContext toDosList
    }


}