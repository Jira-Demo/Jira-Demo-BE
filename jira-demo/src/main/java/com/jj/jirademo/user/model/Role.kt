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
}
