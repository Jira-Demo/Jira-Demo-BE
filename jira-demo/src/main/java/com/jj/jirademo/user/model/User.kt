package com.jj.jirademo.user.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

data class User(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id: UUID,
        val name: String,
        val surname: String,
        val password: String,
        val email: String,
        val projectId: UUID,
        val taskId: UUID,
        val roleId: UUID
)
