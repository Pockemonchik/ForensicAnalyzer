package com.example.forensicanalyzer.db.reports

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.forensicanalyzer.db.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReportViewModel(application: Application): AndroidViewModel(application){


    private val getAll: LiveData<List<Report>>
    private val repository: ReportRepository

    init {
        val reportDao = DataBase.getAppDataBase(application)?.reportDao()
        repository = ReportRepository(reportDao!!)
        getAll = repository.getAll
    }
    fun getAll() : LiveData<List<Report>>{
        return this.getAll
    }
    fun insert(report: Report) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(report)
        }
    }
    fun search(searchQuery: String): LiveData<List<Report>> {
        return repository.search(searchQuery)
    }
}


