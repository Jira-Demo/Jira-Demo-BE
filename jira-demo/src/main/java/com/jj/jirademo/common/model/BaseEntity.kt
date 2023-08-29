package com.jj.jirademo.common.model

import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity


abstract class BaseEntity() {
    @get:CreatedDate
    abstract val createdAt :LocalDateTime
    @get:UpdateTimestamp
    abstract val updatedAt :LocalDateTime }