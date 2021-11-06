package com.example.forensicanalyzer.ui.overview.detail_report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import com.example.forensicanalyzer.ui.overview.ReportListItem


class DetailReportAdapter() : RecyclerView.Adapter<DetailReportAdapter.ViewHolder>(){

    // private var reportList = emptyList<ReportListItem>()
    private var fileList = ArrayList<DetailReportListItem>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var fileImage : ImageView? = null
        var fileName : TextView? = null
        init {
            itemView.setOnClickListener{
                itemView.findNavController().navigate(R.id.navigation_detail_report)
            }
            fileImage = itemView.findViewById(R.id.fileImage)
            fileName = itemView.findViewById(R.id.fileName)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.detail_report_list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fileImage?.setImageResource(fileList[position].fileImageId)
        holder.fileName?.text = fileList[position].fileName

    }

    override fun getItemCount(): Int {
        return fileList.size
    }

    fun setData(fileList: ArrayList<DetailReportListItem>){
        this.fileList = fileList
        notifyDataSetChanged()
    }
}