package com.jj.jirademo.comment.model

import com.jj.jirademo.task.model.Task
import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator

import java.util.UUID

@Entity
data class Comment(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val comment: String,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="user_id", nullable = false)
        val user: User,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="task_id", nullable = false)
        val task: Task,
) {




}
