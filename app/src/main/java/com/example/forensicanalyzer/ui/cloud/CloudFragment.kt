package com.example.forensicanalyzer.ui.cloud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.forensicanalyzer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.tabs.TabLayout

class CloudFragment : Fragment() {

  private lateinit var cloudViewModel: CloudViewModel
  private lateinit var viewPagerAdapter: ViewPagerAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    cloudViewModel =
            ViewModelProvider(this).get(CloudViewModel::class.java)

    viewPagerAdapter = ViewPagerAdapter(parentFragmentManager)
    val root = inflater.inflate(R.layout.fragment_cloud, container, false)
    var tabLayout : TabLayout = root.findViewById(R.id.cloud_tabs)
    var viewPager: ViewPager = root.findViewById(R.id.viewpager)
    viewPager.adapter = viewPagerAdapter
    tabLayout.setupWithViewPager(viewPager)


    return root
  }

}