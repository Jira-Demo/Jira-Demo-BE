package com.jj.jirademo.user.dto


import java.time.LocalDateTime

data class ProjectDto(
        val id : String?,
        val projectName: String,
        val createdDate: LocalDateTime?,
        val updatedDate: LocalDateTime?
)
