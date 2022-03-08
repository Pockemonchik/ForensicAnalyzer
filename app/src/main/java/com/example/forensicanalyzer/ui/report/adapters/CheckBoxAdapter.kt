package com.example.forensicanalyzer.ui.report.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import com.example.forensicanalyzer.ui.report.CheckBoxItem

class CheckBoxAdapter () :RecyclerView.Adapter<CheckBoxAdapter.ViewHolder>(){
    private var checkBoxList = ArrayList<CheckBoxItem>()
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var checkBoxView : CheckBox? = null

        init {
            checkBoxView = itemView.findViewById(R.id.checkBox)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.check_box_list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBoxView?.text = checkBoxList[position].name
        holder.checkBoxView?.isChecked = checkBoxList[position].status
    }

    override fun getItemCount(): Int {
        return checkBoxList.size
    }

    fun setData(checkBoxList: ArrayList<CheckBoxItem>){
        this.checkBoxList= checkBoxList
        notifyDataSetChanged()
    }

}