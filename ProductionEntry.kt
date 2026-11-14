package com.hourlyproduction.report.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "production_entries")
data class ProductionEntry(
    @PrimaryKey val entryId: String,
    val workDate: String,
    val floorNumber: Int,
    val lineNumber: Int,
    val hourSlot: String,
    val buyer: String,
    val style: String,
    val hourlyTarget: Int,
    val actualPcs: Int,
    val createdAtEpochMs: Long,
    val updatedAtEpochMs: Long,
    val syncStatus: String = "PENDING",
    val deleted: Boolean = false
)
