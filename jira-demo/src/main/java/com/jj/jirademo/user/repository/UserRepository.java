package com.jj.jirademo.user.repository;

import com.jj.jirademo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
