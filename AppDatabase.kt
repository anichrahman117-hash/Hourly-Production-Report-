package com.hourlyproduction.report.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductionEntry::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productionDao(): ProductionDao
}
