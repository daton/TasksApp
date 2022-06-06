package com.example.tasksapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert
  suspend  fun insert(task:Task)

    @Update
  suspend  fun update(task:Task)

    @Delete
  suspend  fun delete(task: Task)

    @Query("SELECT * FROM task_table  where taskId= :taskId")
   fun get(taskId:Long):LiveData<Task>
    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
   fun getAll():LiveData<List<Task>>
}