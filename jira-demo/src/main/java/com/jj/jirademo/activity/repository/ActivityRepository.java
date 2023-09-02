package com.jj.jirademo.activity.repository;

import com.jj.jirademo.activity.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,String> {
}
