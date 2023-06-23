package com.jj.jirademo.comment.model

import com.jj.jirademo.user.model.User
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import org.springframework.scheduling.config.Task
import java.util.UUID

data class Comment(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id: UUID,
        val comment: String,
        val user: User,
        val task: Task,
)
