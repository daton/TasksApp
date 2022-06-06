package com.example.tasksapp

import androidx.recyclerview.widget.DiffUtil

class TaskItemDiffCallback: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =(oldItem.taskId==newItem.taskId)



    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =(oldItem==newItem)


}