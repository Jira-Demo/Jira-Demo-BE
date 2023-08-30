package com.jj.jirademo.common.model


import com.jj.jirademo.task.model.Task
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
data class Status(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id:String?,
        val name:String,
        val description:String,

        @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
        val task: Set<Task>?
) {


        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Status

                if (id != other.id) return false
                if (name != other.name) return false
                if (description != other.description) return false
                return task == other.task
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + name.hashCode()
                result = 31 * result + description.hashCode()
                return result
        }


}
