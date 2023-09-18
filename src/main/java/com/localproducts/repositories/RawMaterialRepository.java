package com.localproducts.repositories;

import com.localproducts.entities.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial,Long> {
    Optional<RawMaterial> findByName(String name);
}
