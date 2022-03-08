package com.example.forensicanalyzer.ui.report.adapters
import com.example.forensicanalyzer.ui.report.AnotherItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R

class AnotherAdapter () : RecyclerView.Adapter<AnotherAdapter.ViewHolder>(){
    private var anotherList = ArrayList<AnotherItem>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var anotherIcon : ImageView ? = null
        init {

            anotherIcon = itemView.findViewById(R.id.anotherIcon)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.another_analize_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.anotherIcon?.setImageResource(anotherList[position].anotherIconId)

    }

    override fun getItemCount(): Int {
        return anotherList.size
    }

    fun setData(anotherList : ArrayList<AnotherItem>){
        this.anotherList = anotherList
        notifyDataSetChanged()
    }
}