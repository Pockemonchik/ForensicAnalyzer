package com.example.forensicanalyzer.ui.cloud.tasks

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import java.util.*
import kotlin.collections.ArrayList


class TasksFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tasks, container, false)
        var taskList = ArrayList<TaskItem>()
        Log.e("taskFrag","createview")
        taskList.add(TaskItem("Сервис по картинке", Date(12),true))
        taskList.add(TaskItem("Сервис по картинке", Date(12),true))
        taskList.add(TaskItem("Сервис по картинке", Date(12),true))
        taskList.add(TaskItem("Сервис по картинке", Date(12),true))
        taskList.add(TaskItem("Сервис по картинке", Date(12),false))
        taskList.add(TaskItem("Сервис по картинке", Date(12),false))
        taskList.add(TaskItem("Сервис по картинке", Date(12),false))
        taskList.add(TaskItem("Сервис по картинке", Date(12),false))

        var taskListView: RecyclerView = root.findViewById(R.id.tasksRecyclerView)
        taskListView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        var adapter = TasksAdapter()
        taskListView.adapter = adapter
        adapter.setData(taskList)
        return root
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("deattachFrag","taskFrag")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("attachFrag","taskFrag")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("destFrag","taskFrag")
    }

    override fun onPause() {
        super.onPause()
        Log.e("pauseFrag","taskFrag")
    }

    override fun onResume() {
        super.onResume()
        Log.e("resumeFrag","taskFrag")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("saveState","taskFrag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("destView","taskFrag")
    }
}