package com.localproducts.security.service;

import com.localproducts.security.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    Optional<AppRole> findByName(String name);
}
