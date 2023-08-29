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

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Activity

                if (id != other.id) return false
                return activityName == other.activityName
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + activityName.hashCode()
                return result
        }


}
