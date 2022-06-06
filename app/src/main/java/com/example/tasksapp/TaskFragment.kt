package com.example.tasksapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tasksapp.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {

private   var _binding:FragmentTaskBinding?=null
private  val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentTaskBinding.inflate(inflater, container, false)
        val view=binding.root
        //Room
        val application= requireNotNull(this.activity ).application
        val dao=TaskDatabase.getInstance(application).taskDao
        val viewModelFactory=TaskViewModelFactory(dao)
        val viewModel=ViewModelProvider(this ,viewModelFactory).get(TaskViewModel::class.java)

        binding.viewModel=viewModel
        //Para hacer actualizaciones automaticas
        binding.lifecycleOwner=viewLifecycleOwner

        val adapter=TaskItemAdapter()
        binding.taskList.adapter=adapter

        //RecyclerView
        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data=it
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}