package com.learning.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.model.Educational;

@Repository
public interface EducationalRepository extends JpaRepository<Educational, Long>{

}
