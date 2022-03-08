package com.example.forensicanalyzer.db.reports

import androidx.lifecycle.LiveData

class ReportRepository(private val reportDao: ReportDao) {
    val getAll: LiveData<List<Report>> = reportDao.getAll()
    fun insert(report: Report){
        reportDao.insert(report)
    }

    fun getByName(name: String): LiveData<Report>{
        return reportDao.getByName(name)
    }

    fun search(searchQuery: String): LiveData<List<Report>> {
        return reportDao.search(searchQuery)
    }
}