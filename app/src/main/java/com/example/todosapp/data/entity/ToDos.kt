package com.example.todosapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class ToDos(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo("id") @NotNull var id: Int,
                 @ColumnInfo("name") @NotNull var name: String,
                 @ColumnInfo("image") @NotNull var image: String
) : Serializable {}