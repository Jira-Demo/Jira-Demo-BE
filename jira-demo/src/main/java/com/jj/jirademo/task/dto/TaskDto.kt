package com.jj.jirademo.task.dto


import java.time.LocalDateTime
import java.util.*

data class TaskDto(
        val id : String?,
        val description: String?,
        val taskName: String,
        val dueDate : Date?,
        val priorityId : String,
        val statusId : String
) {

}
