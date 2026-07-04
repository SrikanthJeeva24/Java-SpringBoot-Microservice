package com.sri.user_service.repository;

import java.util.Optional;

import com.sri.user_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
