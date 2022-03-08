package com.example.forensicanalyzer.ui.overview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import com.example.forensicanalyzer.db.reports.ReportViewModel
import java.util.*
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class OverviewFragment : Fragment() {

  private lateinit var overviewViewModel: ReportViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    overviewViewModel =
            ViewModelProvider(this).get(ReportViewModel::class.java)

    val root = inflater.inflate(R.layout.fragment_overview, container, false)



    var reportListView : RecyclerView = root.findViewById(R.id.reportListView)
    reportListView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
    var adapter = ReportAdapter()
    reportListView.adapter = adapter
    overviewViewModel.getAll().observe(viewLifecycleOwner, Observer {report ->
      adapter?.setData(report)
    })


    return root
  }
}