package com.jj.jirademo.comment.dto

import com.jj.jirademo.task.dto.TaskDto
import com.jj.jirademo.user.dto.UserDto


data class CommentDto(
        val id: String?,
        val comment: String,
        val user: UserDto,
        val task: TaskDto,
)
