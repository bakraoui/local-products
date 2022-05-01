package com.example.demo.configuration.security.service;

import com.example.demo.configuration.security.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByName(String name);
}
