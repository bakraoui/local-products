package com.localproducts.repositories;


import com.localproducts.entities.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface OriginRepository extends JpaRepository<Origin,Long> {

    // update origin
    @Modifying
    @Transactional
    @Query(value = "UPDATE origine  SET label = :label WHERE id = :id",nativeQuery = true)
    int update(@Param("id") long id, @Param("label") String label);

    Optional<Origin> findByLabel(String label);
}
