package com.project.movietickets.repository;

import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntityByUsername(String username);
    List<UserEntity> findAllByRoleEquals(Role role);
}
