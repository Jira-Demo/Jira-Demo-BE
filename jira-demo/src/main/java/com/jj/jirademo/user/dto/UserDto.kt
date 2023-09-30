package com.jj.jirademo.user.dto

import com.jj.jirademo.comment.dto.CommentDto
import com.jj.jirademo.comment.model.Comment
import com.jj.jirademo.task.dto.TaskDto

data class UserDto(
        val id: String?,
        val name: String,
        val surname: String,
        val password: String,
        val email: String,
        val project: UserProjectDto,
        val comment: Set<CommentDto>,
        val taskAssigned: Set<TaskDto>,
        val taskReported:Set<TaskDto>,
        val roleId: String,
)
