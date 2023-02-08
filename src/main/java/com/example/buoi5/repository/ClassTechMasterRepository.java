package com.example.buoi5.repository;

import com.example.buoi5.model.ClassTechMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassTechMasterRepository extends JpaRepository<ClassTechMaster, Integer> {
    Optional<ClassTechMaster> findById(int id);
}
