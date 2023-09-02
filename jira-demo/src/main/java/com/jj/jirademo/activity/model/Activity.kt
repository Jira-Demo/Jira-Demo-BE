package com.jj.jirademo.activity.model

import com.jj.jirademo.task.model.Task
import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator

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

}
