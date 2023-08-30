package com.jj.jirademo.common.model

import com.jj.jirademo.task.model.Task
import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
data class Priority(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String?,
        val priorityName: String,

        @OneToMany(mappedBy = "priority", fetch = FetchType.LAZY)
        val task: Set<Task>?
) {


        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Priority

                if (id != other.id) return false
                if (priorityName != other.priorityName) return false
                return task == other.task
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + priorityName.hashCode()
                return result
        }

}
