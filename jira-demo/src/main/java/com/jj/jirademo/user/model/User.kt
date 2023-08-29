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
        constructor() : this("","","","","", Project(), Task(),Role(), hashSetOf()) {

        }

}
