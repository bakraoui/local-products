package com.localproducts.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username ;
    private String password ;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Set<AppRole> roles = new HashSet<>();
}
