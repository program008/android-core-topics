package com.example.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 *
 * @author liu tao
 * @date 2022/2/18 17:18
 * @description 描述
 */
class UploadWorker(appContext: Context, workerParameters: WorkerParameters) :
    Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.
        //uploadImages()
        // Indicate whether the work finished successfully with the Result
        //Result.success(): The work finished successfully.
        //Result.failure(): The work failed.
        //Result.retry(): The work failed and should be tried at another time according to its retry policy.
        return Result.success()
    }
}