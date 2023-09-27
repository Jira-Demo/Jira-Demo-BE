package com.jj.jirademo.user.dto

import com.jj.jirademo.task.dto.TaskDto

data class UserDto(
        val id: String?,
        val name: String,
        val surname: String,
        val password: String,
        val email: String,
        val project: UserProjectDto,
        val taskAssigned: Set<TaskDto>,
        val roleId: String,
)
