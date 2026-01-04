package com.example.BookStore.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.models.Signuptable;

@Repository
public interface SignupRepository extends JpaRepository<Signuptable, Integer>
{
	 Signuptable findByEmail(String email);
}
