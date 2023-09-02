package com.jj.jirademo.task.repository;

import com.jj.jirademo.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,String> {
}
