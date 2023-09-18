package com.localproducts.entities;

import com.localproducts.security.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Client {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private  String address;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AppUser appUser;



}
