package com.example.forensicanalyzer.ui.cloud.tasks

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import java.util.*
import kotlin.collections.ArrayList

class TasksAdapter () : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {
    private var taskList = ArrayList<TaskItem>()
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var service: TextView? = null
        var date: TextView? = null
        var statusView: ConstraintLayout? = null
        init {
            service = itemView.findViewById(R.id.taskService)
            date = itemView.findViewById(R.id.taskDate)
            statusView = itemView.findViewById(R.id.statusView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date?.text = taskList[position].date.toString()
        holder.service?.text = taskList[position].service
        if(taskList[position].status){
            holder.statusView?.setBackgroundResource(R.drawable.task_item_bg_green)
        } else{
            holder.statusView?.setBackgroundResource(R.drawable.task_item_bg)
        }
        Log.e("bind","tasks")

    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    fun setData(taskList: ArrayList<TaskItem>){
        this.taskList = taskList
        notifyDataSetChanged()
    }

}