package com.example.forensicanalyzer.ui.cloud.services

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R

class ServicesAdapter () : RecyclerView.Adapter<ServicesAdapter.ViewHolder>(){
    private var serviceList = ArrayList<ServiceItem>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var serviceIcon : ImageView ? = null
        var serviceOverflow : ImageView ? = null
        init {

            serviceIcon = itemView.findViewById(R.id.serviceIcon)
            serviceOverflow = itemView.findViewById(R.id.serviceOverflow)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.services_list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.serviceIcon?.setImageResource(serviceList[position].serviceIconId)
        holder.serviceOverflow?.setImageResource(serviceList[position].overflowId)
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    fun setData(serviceList : ArrayList<ServiceItem>){
        this.serviceList = serviceList
        notifyDataSetChanged()
    }
}