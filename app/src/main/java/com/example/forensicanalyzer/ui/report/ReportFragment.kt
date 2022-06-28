package com.example.forensicanalyzer.ui.report

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forensicanalyzer.R
import com.example.forensicanalyzer.ui.report.adapters.AnotherAdapter
import com.example.forensicanalyzer.ui.report.adapters.CheckBoxAdapter
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit


class ReportFragment : Fragment() {

  private lateinit var reportViewModel: ReportViewModel
  lateinit var progressBar: FrameLayout



  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    reportViewModel =
            ViewModelProvider(this).get(ReportViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_report, container, false)
    arguments?.getString("typeOfDevice")?.let { Log.e("bundle", it) }
    when (arguments?.getString("typeOfDevice")){
      "usb" -> root.findViewById<TextView>(R.id.report_head_title).text = "Исследование USB"
      "hdd" -> root.findViewById<TextView>(R.id.report_head_title).text = "Исследование HDD"
      "phone" -> root.findViewById<TextView>(R.id.report_head_title).text = "Исследование смартфона"
    }
    progressBar = root.findViewById(R.id.progress_overlay)
    var checkBoxList = ArrayList<CheckBoxItem>()
    checkBoxList.add(CheckBoxItem(true, ".jpg"))
    checkBoxList.add(CheckBoxItem(true, ".txt"))
    checkBoxList.add(CheckBoxItem(true, ".mp3"))
    checkBoxList.add(CheckBoxItem(false, ".docx"))
    checkBoxList.add(CheckBoxItem(false, ".mp4"))
    checkBoxList.add(CheckBoxItem(false, ".xlsx"))


    var checkBoxListView :RecyclerView = root.findViewById(R.id.checkBoxList)
    checkBoxListView.layoutManager = GridLayoutManager(activity, 3)
    var checkBoxAdapter = CheckBoxAdapter()
    checkBoxListView.adapter = checkBoxAdapter
    checkBoxAdapter.setData(checkBoxList)

    var anotherList = ArrayList<AnotherItem>()
    anotherList.add(AnotherItem(R.drawable.image_icon))
    anotherList.add(AnotherItem(R.drawable.video_icon))
    anotherList.add(AnotherItem(R.drawable.audio_icon))
    anotherList.add(AnotherItem(R.drawable.image_icon))

    var anotherListView :RecyclerView = root.findViewById(R.id.anotherList)
    anotherListView.layoutManager = LinearLayoutManager(
      activity,
      LinearLayoutManager.HORIZONTAL,
      false
    )
    var anotherAdapter = AnotherAdapter()
    anotherListView.adapter = anotherAdapter
    anotherAdapter.setData(anotherList)
    root.findViewById<Button>(R.id.add_report_btn).setOnClickListener(View.OnClickListener { view ->
      progressBar.visibility = View.VISIBLE
      Handler(Looper.getMainLooper()).postDelayed(
        {
          findNavController().navigate(R.id.navigation_detail_report)
        },
        3000 // value in milliseconds
      )


    })





    return root
  }
}