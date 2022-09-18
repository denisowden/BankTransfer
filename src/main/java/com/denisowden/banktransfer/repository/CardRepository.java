package com.denisowden.banktransfer.repository;

import com.denisowden.banktransfer.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByNumber(Integer number);

}
