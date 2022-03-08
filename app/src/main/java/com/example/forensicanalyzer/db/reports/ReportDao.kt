package com.example.forensicanalyzer.db.reports
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(report: Report)
    @Update
    fun update(report: Report)

    @Delete
    fun deleteObjectDesc(report: Report)

    @Query("SELECT * FROM Report WHERE name == :name")
    fun getByName(name: String):LiveData<Report>

    @Query("SELECT * FROM Report")
    fun getAll(): LiveData<List<Report>>

    @Query("SELECT * FROM Report WHERE name LIKE :searchQuery ")
    fun search(searchQuery: String): LiveData<List<Report>>
}