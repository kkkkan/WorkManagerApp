package com.kkkkan.myapplication

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(ct: Context, workerParams: WorkerParameters) : Worker(ct, workerParams) {
    override fun doWork(): Result {

        return Result.SUCCESS
    }
}
