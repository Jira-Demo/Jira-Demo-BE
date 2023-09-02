package com.jj.jirademo.task.repository;

import com.jj.jirademo.common.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority,String> {
}
