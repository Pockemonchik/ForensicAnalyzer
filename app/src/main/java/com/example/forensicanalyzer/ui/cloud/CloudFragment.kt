package com.example.forensicanalyzer.ui.cloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.forensicanalyzer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class CloudFragment : Fragment() {

  private lateinit var cloudViewModel: CloudViewModel
  private lateinit var pieChart: PieChart

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    cloudViewModel =
            ViewModelProvider(this).get(CloudViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_cloud, container, false)
    return root
  }

}