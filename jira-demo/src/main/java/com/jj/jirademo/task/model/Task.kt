package com.jj.jirademo.task.model

import com.jj.jirademo.comment.model.Comment
import com.jj.jirademo.common.model.BaseEntity
import com.jj.jirademo.common.model.Priority
import com.jj.jirademo.common.model.Status

import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*

@Entity

data class Task(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String?,
        val description: String,
        val taskName: String,
        val dueDate : Date,
        override val createdDate: LocalDateTime,
        override val updatedDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="priority_id", nullable = false)
        val priority : Priority,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="status_id", nullable = false)
        val status : Status,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="assigned_user_id", nullable = false)
        val assignedUser: User,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="reported_user_id", nullable = false)
        val reportedUser: User,


        @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
        val comment: Set<Comment>?

): BaseEntity() {

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Task

                if (id != other.id) return false
                if (description != other.description) return false
                if (taskName != other.taskName) return false
                if (dueDate != other.dueDate) return false
                if (createdDate != other.createdDate) return false
                if (updatedDate != other.updatedDate) return false
                if (priority != other.priority) return false
                if (status != other.status) return false
                if (assignedUser != other.assignedUser) return false
                if (reportedUser != other.reportedUser) return false
                return comment == other.comment
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + description.hashCode()
                result = 31 * result + taskName.hashCode()
                result = 31 * result + dueDate.hashCode()
                result = 31 * result + createdDate.hashCode()
                result = 31 * result + updatedDate.hashCode()
                return result
        }
}
