package com.jj.jirademo.user.dto

import com.jj.jirademo.task.dto.TaskDto

data class UserRequest(
        val password: String,
        val email: String
)
