package com.localproducts.repositories;

import com.localproducts.entities.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CooperativeRepository extends JpaRepository<Cooperative,Long> {
    Optional<Cooperative> findByName(String name);
}
