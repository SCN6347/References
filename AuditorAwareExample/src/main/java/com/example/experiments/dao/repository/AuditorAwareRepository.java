package com.example.experiments.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.experiments.dao.entity.AuditorAwareEntity;

@Repository
public interface AuditorAwareRepository extends JpaRepository<AuditorAwareEntity, java.lang.Integer> {


}
