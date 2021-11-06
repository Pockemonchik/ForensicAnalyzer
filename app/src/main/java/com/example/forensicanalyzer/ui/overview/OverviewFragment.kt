package com.example.forensicanalyzer.ui.overview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import java.util.*
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class OverviewFragment : Fragment() {

  private lateinit var overviewViewModel: OverviewViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    overviewViewModel =
            ViewModelProvider(this).get(OverviewViewModel::class.java)

    val root = inflater.inflate(R.layout.fragment_overview, container, false)

    var reportList = ArrayList<ReportListItem>()
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1a", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1aaa", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1aaaaaa", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1aaaaaaaaaaa", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1aaaaaaaaa", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1aaaaaaaaaaa", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))
    reportList.add(ReportListItem(R.drawable.report_icon,"Исследование НЖМД #1", Date(2018, 12, 31)))


    var reportListView : RecyclerView = root.findViewById(R.id.reportListView)
    reportListView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
    var adapter = ReportAdapter()
    reportListView.adapter = adapter
    adapter.setData(reportList)




    return root
  }
}