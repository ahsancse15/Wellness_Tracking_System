package com.example.FirstDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FirstDemo.model.register;

@Repository
public interface registerRepository extends JpaRepository<register, String> {
	
	@Query("SELECT s FROM register s WHERE s.email = :email")
    Iterable<register> findPatientsByEmail(String email);

}
