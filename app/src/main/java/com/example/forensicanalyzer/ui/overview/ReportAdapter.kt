package com.example.forensicanalyzer.ui.overview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R

class ReportAdapter() : RecyclerView.Adapter<ReportAdapter.ViewHolder>(){

   // private var reportList = emptyList<ReportListItem>()
    private var reportList = ArrayList<ReportListItem>()

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var reportImage : ImageView ? = null
        var reportName :TextView ? = null
        var reportDate :TextView ? = null
        init {
            itemView.setOnClickListener{
                itemView.findNavController().navigate(R.id.navigation_detail_report)
            }
            reportImage = itemView.findViewById(R.id.reportImage)
            reportName = itemView.findViewById(R.id.reportName)
            reportDate = itemView.findViewById(R.id.reportDate)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.report_list_item,parent,false)
       return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.reportImage?.setImageResource(reportList[position].reportImageId)
        holder.reportName?.text = reportList[position].reportName
        holder.reportDate?.text = reportList[position].reportDate.toString()
    }

    override fun getItemCount(): Int {
        return reportList.size
    }

    fun setData(reportList: ArrayList<ReportListItem>){
        this.reportList = reportList
        notifyDataSetChanged()
    }
}