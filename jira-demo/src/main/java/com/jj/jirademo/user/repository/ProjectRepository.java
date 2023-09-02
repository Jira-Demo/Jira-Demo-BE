package com.jj.jirademo.user.repository;

import com.jj.jirademo.common.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,String> {

}
