package com.denisowden.banktransfer.repository;

import com.denisowden.banktransfer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
