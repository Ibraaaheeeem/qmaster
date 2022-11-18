package com.haneef.quranmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haneef.quranmaster.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
