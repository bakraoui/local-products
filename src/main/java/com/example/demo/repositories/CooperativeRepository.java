package com.example.demo.repositories;

import com.example.demo.entities.Cooperative;
import com.example.demo.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CooperativeRepository extends JpaRepository<Cooperative,Long> {
    List<Cooperative> findByRegions_Name(String name);
    Optional<Cooperative> findByName(String name);
    List<Cooperative> findByNameContaining(String name);
}
