package com.example.forensicanalyzer.ui.overview.detail_report

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class DetailReportFragment : Fragment() {


    private lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_detail_report, container, false)

        //chart view
        pieChart = root.findViewById(R.id.pieChartView)

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);

        pieChart.holeRadius = 30f;
        pieChart.transparentCircleRadius = 40f;

        pieChart.centerText = "15 GB";
        pieChart.setCenterTextSize(20f);


        val l: Legend = pieChart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        setPieChartData()



        //list of files view
        var fileList = ArrayList<DetailReportListItem>()
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        fileList.add(DetailReportListItem(R.drawable.report_icon, "Файл с серктными данными"))
        var fileListView : RecyclerView = root.findViewById(R.id.fileListView)
        fileListView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        var adapter = DetailReportAdapter()
        fileListView.adapter = adapter
        adapter.setData(fileList)



        return root
    }
    private fun setPieChartData() {
        val listPie = ArrayList<PieEntry>()
        val listColors = ArrayList<Int>()
        listPie.add(PieEntry(20F, "DOC"))
        listColors.add(resources.getColor(R.color.blue_200))
        listPie.add(PieEntry(30F, "IMAGE"))
        listColors.add(resources.getColor(R.color.blue_700))
        listPie.add(PieEntry(30F, "CRYPT"))
        listColors.add(resources.getColor(R.color.blue_500))
        listPie.add(PieEntry(20F, "CRYPT"))
        listColors.add(resources.getColor(R.color.purple_200))

        val pieDataSet = PieDataSet(listPie, "")
        pieDataSet.colors = listColors

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData

        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setEntryLabelColor(R.color.blue_700)
        pieChart.animateY(1400, Easing.EaseInOutQuad)
    }
}