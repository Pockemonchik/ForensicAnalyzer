package com.example.forensicanalyzer.db.reports

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity
data class Report(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val type: String,
    @TypeConverters(DateConverter::class)
    val date: Date,
    )