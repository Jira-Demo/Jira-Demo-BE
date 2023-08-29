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
        constructor() : this("","","", hashSetOf()) {

        }


}
