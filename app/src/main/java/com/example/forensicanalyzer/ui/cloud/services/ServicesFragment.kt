package com.example.forensicanalyzer.ui.cloud.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R



class ServicesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_services, container, false)
        var serviceList = ArrayList<ServiceItem>()
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))
        serviceList.add(ServiceItem(R.drawable.services_overflow,R.drawable.services_icon,"title"))


        var serviceListView : RecyclerView = root.findViewById(R.id.servicesRecyclerView)

        serviceListView.layoutManager = GridLayoutManager(activity,2)
        var adapter = ServicesAdapter()
        serviceListView.adapter =adapter
        adapter.setData(serviceList)
        return root
    }

    
}