package com.jj.jirademo.common.model

import com.jj.jirademo.task.model.Task
import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
data class Activity(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String?,
        val activityName: String,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="task_id", nullable = false)
        val task: Task,


        ) {


        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Activity

                if (id != other.id) return false
                if (activityName != other.activityName) return false
                if (user != other.user) return false
                return task == other.task
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + activityName.hashCode()
                return result
        }
}
