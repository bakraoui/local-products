package com.example.demo.repositories;

import com.example.demo.entities.MatierePremiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MatierePremiereRepository extends JpaRepository<MatierePremiere,Long> {
    Optional<MatierePremiere> findByName(String name);
}
