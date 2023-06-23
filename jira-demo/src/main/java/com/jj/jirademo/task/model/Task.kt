package com.jj.jirademo.task.model

import com.jj.jirademo.common.model.BaseEntity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*

data class Task(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : UUID? = null,
        val priorityId : UUID,
        val status : UUID,
        val description: String,
        val taskName: String,
        val dueDate : Date,
        override val createdAt: LocalDateTime,
        override val updatedAt: LocalDateTime
):BaseEntity()
