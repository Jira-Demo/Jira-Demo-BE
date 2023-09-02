package com.jj.jirademo.common.model

import com.jj.jirademo.user.model.User
import javax.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashSet

@Entity
data class Project(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String? ,
        val projectName: String ,
        override val createdDate:LocalDateTime?,
        override val updatedDate: LocalDateTime?,

        @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
        val users: Set<User>?
):BaseEntity() {



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
