package com.jj.jirademo.task.repository;

import com.jj.jirademo.common.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,String> {
}
