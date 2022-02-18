package com.example.workmanager

import android.content.Context
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager

////1. 禁用单个库的自动初始化
//tools:node="remove"//android mainfest 对应meta-data
//AppInitializer.getInstance(context).initializeComponent(WorkManagerInitializer.class);
//2. 禁用所有库的自动初始化
//provider节点添加tools:node="remove"
//在需要初始化的时候手动去初始化
// AppInitializer.getInstance(context).initializeComponent(WorkManagerInitializer.class);
// Initializes WorkManager.
class WorkManagerInitializer : Initializer<WorkManager> {
    override fun create(context: Context): WorkManager {
        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }
    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }
}