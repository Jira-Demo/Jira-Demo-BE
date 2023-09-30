package com.jj.jirademo.user.model

import com.jj.jirademo.comment.model.Comment
import com.jj.jirademo.common.model.Project
import com.jj.jirademo.common.model.Role
import com.jj.jirademo.task.model.Task
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? ,
        val name: String,
        val surname: String,
        val password: String,
        val email: String,
        @Enumerated(EnumType.STRING)
        @Column(name="role")
        val role: Role,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="project_id", nullable = false)
        val project: Project,


        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val comment: Set<Comment>?,

        @OneToMany(mappedBy = "assignedUser", fetch = FetchType.LAZY)
        val taskAssigned: Set<Task>?,

        @OneToMany(mappedBy = "reportedUser", fetch = FetchType.LAZY)
        val taskReported: Set<Task>?


) {


        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as User

                if (id != other.id) return false
                if (name != other.name) return false
                if (surname != other.surname) return false
                if (password != other.password) return false
                if (email != other.email) return false
                if (role != other.role) return false
                if (project != other.project) return false
                if (comment != other.comment) return false
                if (taskAssigned != other.taskAssigned) return false
                return taskReported == other.taskReported
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + name.hashCode()
                result = 31 * result + surname.hashCode()
                result = 31 * result + password.hashCode()
                result = 31 * result + email.hashCode()
                return result
        }
}
