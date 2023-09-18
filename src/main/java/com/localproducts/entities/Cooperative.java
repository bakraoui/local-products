package com.localproducts.entities;

import com.localproducts.security.AppUser;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private AppUser appUser;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "cooperative_region",
//            joinColumns = @JoinColumn(name = "cooperateId", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "regionId", referencedColumnName = "id")
//    )
    private List<Region> regions;


}
