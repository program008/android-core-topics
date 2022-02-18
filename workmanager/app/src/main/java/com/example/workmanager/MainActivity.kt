package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import androidx.work.WorkRequest

/**
 * //https://medium.com/androiddevelopers/introducing-workmanager-2083bcfc4712
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1.define the work (extends worker)
        //2.create a workRequest
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>()
                // Additional configuration
                //.setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .build()

        //3.submit the workRequest to system
        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest)

    }
}