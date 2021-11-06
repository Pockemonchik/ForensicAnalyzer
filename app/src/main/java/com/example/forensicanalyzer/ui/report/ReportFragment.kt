package com.example.forensicanalyzer.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.forensicanalyzer.R

class ReportFragment : Fragment() {

  private lateinit var reportViewModel: ReportViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    reportViewModel =
            ViewModelProvider(this).get(ReportViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_report, container, false)

    return root
  }
}