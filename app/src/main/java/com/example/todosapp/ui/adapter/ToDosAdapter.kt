package com.example.todosapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todosapp.data.entity.ToDos
import com.example.todosapp.databinding.CardDesignBinding
import com.example.todosapp.databinding.SaveScreenBinding
import com.example.todosapp.ui.screens.MainScreenDirections
import com.example.todosapp.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import java.nio.file.Files.delete


class ToDosAdapter(
    var mContext: Context,
    var toDosList: List<ToDos>,
    var viewModel: MainViewModel
) :
    RecyclerView.Adapter<ToDosAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding: CardDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }


    override fun onBindViewHolder(
        holder: CardDesignHolder,
        position: Int
    ) {
        val toDo = toDosList[position]
        val design = holder.binding

        design.imageViewToDo.setImageResource(
            mContext.resources.getIdentifier(toDo.image, "drawable", mContext.packageName)
        )

        design.textViewName.text = toDo.name

        design.cardViewToDo.setOnClickListener {

            val toUpdateScreen = MainScreenDirections.toUpdateScreen(toDo = toDo)
            it.findNavController().navigate(toUpdateScreen)
        }
        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "Do you want to delete ${toDo.name} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.delete(toDo.id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return toDosList.size
    }


}