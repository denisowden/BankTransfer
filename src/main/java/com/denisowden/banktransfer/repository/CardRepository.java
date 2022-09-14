package com.denisowden.banktransfer.repository;

import com.denisowden.banktransfer.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {

    CardEntity findByNumber(Integer number);

}
