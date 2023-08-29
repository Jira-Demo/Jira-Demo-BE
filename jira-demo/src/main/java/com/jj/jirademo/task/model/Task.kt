package com.jj.jirademo.task.model

import com.jj.jirademo.comment.model.Comment
import com.jj.jirademo.common.model.BaseEntity
import com.jj.jirademo.common.model.Priority
import com.jj.jirademo.common.model.Status

import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashSet

@Entity
data class Task(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String?,
        val description: String,
        val taskName: String,
        val dueDate : Date,
        override val createdAt: LocalDateTime,
        override val updatedAt: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="priority_id", nullable = false)
        val priority : Priority,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="status_id", nullable = false)
        val status : Status,

        @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
        val user: Set<User>?,

        @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
        val comment: Set<Comment>?

):BaseEntity() {
        constructor() : this("","","", Date(),LocalDateTime.now(),LocalDateTime.now(), Priority(), Status(), hashSetOf(), hashSetOf()) {

        }

}
