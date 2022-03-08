package com.example.forensicanalyzer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.forensicanalyzer.db.reports.DateConverter
import com.example.forensicanalyzer.db.reports.Report
import com.example.forensicanalyzer.db.reports.ReportDao

@Database(entities = [Report::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class DataBase : RoomDatabase() {
    abstract fun reportDao(): ReportDao

    companion object {
        var INSTANCE: DataBase? = null

        fun getAppDataBase(context: Context): DataBase? {
            if (INSTANCE == null){
                synchronized(DataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DataBase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}