package com.jj.jirademo.common.model

import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*
import kotlin.collections.HashSet

@Entity
data class Project(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String? ,
        val projectName: String ,

        @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
        val users: Set<User>?
) {
        constructor() : this("","", hashSetOf()) {
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Project

                if (id != other.id) return false
                if (projectName != other.projectName) return false
                return users == other.users
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + projectName.hashCode()
                return result
        }


}
