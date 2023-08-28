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
}
