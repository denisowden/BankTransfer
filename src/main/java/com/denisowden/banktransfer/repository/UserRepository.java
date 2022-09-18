package com.denisowden.banktransfer.repository;

import com.denisowden.banktransfer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
