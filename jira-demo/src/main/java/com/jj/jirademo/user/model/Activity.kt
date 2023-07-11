package com.jj.jirademo.common.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.util.*

data class Activity(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : UUID? = null,
        val activityName: String
)
