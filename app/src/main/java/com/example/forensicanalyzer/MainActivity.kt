package com.example.forensicanalyzer

import android.animation.Animator
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.forensicanalyzer.databinding.ActivityMainBinding
import com.example.forensicanalyzer.db.reports.Report
import com.example.forensicanalyzer.db.reports.ReportViewModel
import com.github.mjdev.libaums.UsbMassStorageDevice
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var reportViewModel : ReportViewModel
    private lateinit var manager: UsbManager
    private val ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION"


    private val usbReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            if (ACTION_USB_PERMISSION == intent.action) {
                synchronized(this) {
                    try {
                        val devices = UsbMassStorageDevice.getMassStorageDevices(this@MainActivity /* Context or Activity */)


                        loop@ for(device in devices){
                            if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                                device.usbDevice?.apply {
                                    try {
                                        device.init()
                                        Log.e("init", device.partitions.toString())
                                        Toast.makeText(this@MainActivity,"permission access",Toast.LENGTH_LONG).show()
                                        // Only uses the first partition on the device
                                        Toast.makeText(this@MainActivity,"usb to str "+device.toString(),Toast.LENGTH_LONG).show()
                                        Log.e("fs", device.partitions.toString())
                                        val currentFs = device.partitions[0].fileSystem
                                        Toast.makeText(this@MainActivity,"check fs",Toast.LENGTH_LONG).show()
                                        val root = currentFs.rootDirectory

                                        val files = root.listFiles()
                                        for (file in files) {
                                            Toast.makeText(this@MainActivity,file.name,Toast.LENGTH_LONG).show()
                                        }
                                    }
                                    catch (e: Exception){
                                        Toast.makeText(this@MainActivity,"err "+e.toString(),Toast.LENGTH_LONG).show()

                                    }



                                }
                            } else {
                                Toast.makeText(this@MainActivity,"permission denied for device",Toast.LENGTH_LONG).show()
                            }
                        }

                    }
                    catch (e: Exception){
                        Toast.makeText(this@MainActivity,"err "+e.toString(),Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        reportViewModel = ViewModelProvider(this).get(ReportViewModel::class.java)
        var dbData = reportViewModel.getAll().value

        if (dbData == null){
            reportViewModel.insert(Report(1,"Отчет номер один","usb", Calendar.getInstance().time))
            reportViewModel.insert(Report(2,"Отчет номер два", "phone",Calendar.getInstance().time))
            reportViewModel.insert(Report(3,"Отчет номер три","hdd", Calendar.getInstance().time))
            reportViewModel.insert(Report(4,"Отчет номер четыре","", Calendar.getInstance().time))
        }



        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_report -> {
                    var addReportContainer: ConstraintLayout = findViewById(R.id.add_report_container)
                    addReportContainer.isClickable = true
                    addReportContainer.visibility = VISIBLE
                    addReportContainer.bringToFront()

                }
                R.id.navigation_overview -> {
                    navController.navigate(R.id.navigation_overview)
                }
                R.id.navigation_cloud -> {
                    navController.navigate(R.id.navigation_cloud)
                }

            }
            true
        }

        binding.closeImageView.setOnClickListener(addReportClickListener)
        binding.usbImageView.setOnClickListener(addReportClickListener)
        binding.hddImageView.setOnClickListener(addReportClickListener)
        binding.phoneImageView.setOnClickListener(addReportClickListener)
        manager = getSystemService(Context.USB_SERVICE) as UsbManager
        val filter = IntentFilter(ACTION_USB_PERMISSION)
        registerReceiver(usbReceiver, filter)






    }
    private val addReportClickListener: View.OnClickListener = View.OnClickListener { view ->
        val navController = findNavController(R.id.nav_host_fragment)
        when (view.id) {
            R.id.closeImageView -> {
                GONE.also { binding.addReportContainer.visibility = it }
                binding.addReportContainer.isClickable = false
            }
            R.id.usbImageView -> {
                var bundle = bundleOf("typeOfDevice" to "usb")
                GONE.also { binding.addReportContainer.visibility = it }
                navController.navigate(R.id.navigation_report,bundle)
                binding.addReportContainer.isClickable = false
                val devices = UsbMassStorageDevice.getMassStorageDevices(this@MainActivity /* Context or Activity */)


                val permissionIntent = PendingIntent.getBroadcast(this, 0, Intent(ACTION_USB_PERMISSION), 0);
                manager.requestPermission(devices[0].usbDevice, permissionIntent)



                    // before interacting with a device you need to call init()!


            }
            R.id.hddImageView -> {
                var bundle = bundleOf("typeOfDevice" to "hdd")
                GONE.also { binding.addReportContainer.visibility = it }
                navController.navigate(R.id.navigation_report,bundle)
                binding.addReportContainer.isClickable = false
            }
            R.id.phoneImageView -> {
                var bundle = bundleOf("typeOfDevice" to "phone")
                GONE.also { binding.addReportContainer.visibility = it }
                navController.navigate(R.id.navigation_report,bundle)
                binding.addReportContainer.isClickable = false
            }
        }

    }
}