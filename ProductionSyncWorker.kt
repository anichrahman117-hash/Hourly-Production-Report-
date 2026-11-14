package com.hourlyproduction.report.sync

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

/**
 * Sync worker scaffold.
 * Next implementation step: read PENDING Room rows, write them to Firestore using
 * entryId as the deterministic document ID (idempotent upload), then mark SYNCED.
 * Resolve edit/delete conflicts on the server using updatedAtEpochMs and audit records.
 */
class ProductionSyncWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        // Firebase project configuration and repository are required before syncing.
        return Result.retry()
    }
}
