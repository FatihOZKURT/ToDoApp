package com.example.todosapp.data.datasource

import android.R
import android.R.attr.name
import android.util.Log
import android.util.Log.w
import com.example.todosapp.data.entity.ToDos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource {


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
        val toDosList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport","araba")
        val toDo2 = ToDos(2,"Work","yildiz")
        val toDo3 = ToDos(3,"Holiday","semsiye")
        toDosList.add(toDo1,)
        toDosList.add(toDo2)
        toDosList.add(toDo3)

        return@withContext toDosList
    }

    suspend fun search(searchText :String): List<ToDos> = withContext(Dispatchers.IO){
        val toDosList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport","araba")
        toDosList.add(toDo1,)


        return@withContext toDosList
    }


}