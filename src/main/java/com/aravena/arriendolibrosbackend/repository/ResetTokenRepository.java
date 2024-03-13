package com.aravena.arriendolibrosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravena.arriendolibrosbackend.model.ResetToken;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer>{

	//from ResetToken where token = :?
    ResetToken findByToken(String token);
}
