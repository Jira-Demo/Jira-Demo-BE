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

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="project_id", nullable = false)
        val project: Project,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="task_id", nullable = false)
        val task: Task,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name="role_id", nullable = false)
        val role: Role,

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val comment: Set<Comment>?
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
                if (project != other.project) return false
                if (task != other.task) return false
                if (role != other.role) return false
                return comment == other.comment
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
