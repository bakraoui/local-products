package com.example.demo.entities;

import com.example.demo.configuration.security.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Client {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AppUser appUser;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "id_client",
            referencedColumnName = "id"
    )
    private List<Command> commands;


}
