package br.com.lucaslr.taskapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.lucaslr.taskapp.data.model.Task
import br.com.lucaslr.taskapp.databinding.ItemTaskTopBinding

class TaskTopAdapter(
    private val context: Context,
    private val taskTopSelected: (Task, Int) -> Unit
) : ListAdapter<Task, TaskTopAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        val SELECT_REMOVE: Int = 2
        val SELECT_EDIT: Int = 3
        val SELECT_DETAILS: Int = 4

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id  && oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem && oldItem.description == newItem.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemTaskTopBinding.inflate(LayoutInflater.from((parent.context)), parent, false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = getItem(position)

        holder.binding.textDescription.text = task.description

        holder.binding.btnDelete.setOnClickListener{taskTopSelected(task, SELECT_REMOVE)}
        holder.binding.btnEdit.setOnClickListener{taskTopSelected(task, SELECT_EDIT)}
        holder.binding.btnDetail.setOnClickListener{taskTopSelected(task, SELECT_DETAILS)}

    }


    inner class MyViewHolder(val binding: ItemTaskTopBinding)
        : RecyclerView.ViewHolder(binding.root)

}