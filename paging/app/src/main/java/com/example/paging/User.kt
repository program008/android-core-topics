package com.example.paging

import androidx.room.Entity

/**
 *
 * @author liu tao
 * @date 2022/2/18 10:41
 * @description 描述
 */
@Entity(tableName = "users")
data class User(
    var id:Int,
    var name:String,
    var age:Int,
    val label: String
)