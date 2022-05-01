package com.example.demo.repositories;


import com.example.demo.entities.Origine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrigineRepository extends JpaRepository<Origine,Long> {

    // update origin
    @Modifying
    @Transactional
    @Query(value = "UPDATE origine  SET label = :label WHERE id = :id",nativeQuery = true)
    int update(@Param("id") long id, @Param("label") String label);

    Origine findByLabel(String label);
}
