package com.hourlyproduction.report.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductionDao {
    @Query("SELECT * FROM production_entries WHERE workDate = :date AND deleted = 0 ORDER BY floorNumber, lineNumber, hourSlot")
    fun entriesForDate(date: String): Flow<List<ProductionEntry>>

    @Query("SELECT * FROM production_entries WHERE syncStatus != 'SYNCED'")
    suspend fun pendingSync(): List<ProductionEntry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entry: ProductionEntry)

    @Query("UPDATE production_entries SET actualPcs = :pcs, updatedAtEpochMs = :updatedAt, syncStatus = 'PENDING' WHERE entryId = :id")
    suspend fun updateActual(id: String, pcs: Int, updatedAt: Long)

    @Query("UPDATE production_entries SET deleted = 1, syncStatus = 'PENDING', updatedAtEpochMs = :updatedAt WHERE entryId = :id")
    suspend fun markDeleted(id: String, updatedAt: Long)

    @Query("UPDATE production_entries SET syncStatus = 'SYNCED' WHERE entryId = :id")
    suspend fun markSynced(id: String)
}
