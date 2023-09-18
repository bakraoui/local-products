package com.localproducts.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<LineCommand> lines;

    @OneToMany
    private List<RawMaterial> rawMaterials;

    @ManyToOne
    private Cooperative cooperative;

    @ManyToOne
    private Category category;

}
