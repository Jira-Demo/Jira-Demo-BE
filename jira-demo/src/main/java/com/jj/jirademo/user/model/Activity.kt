package com.jj.jirademo.common.model

import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
data class Activity(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String?,
        val activityName: String
) {
        constructor() : this("","") {

        }
}
