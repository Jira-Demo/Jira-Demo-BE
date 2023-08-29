package com.jj.jirademo.common.model

import com.jj.jirademo.user.model.User

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
@Entity
data class Role(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : String?,
        val roleName: String,

        @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
        val user: Set<User>?

) {
        constructor() : this("","", hashSetOf()) {

        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Role

                if (id != other.id) return false
                if (roleName != other.roleName) return false
                return user == other.user
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + roleName.hashCode()
                return result
        }


}
