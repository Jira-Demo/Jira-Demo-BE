package com.jj.jirademo.common.model

import java.time.LocalDateTime
import javax.persistence.Entity


 open class BaseEntity(
        open val createdDate: LocalDateTime? = null,
        open val updatedDate: LocalDateTime? = null)
