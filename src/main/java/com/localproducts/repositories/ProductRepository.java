package com.localproducts.repositories;

import com.localproducts.entities.Category;
import com.localproducts.entities.Cooperative;
import com.localproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);
    List<Product> findByCooperative(Cooperative cooperative);
    List<Product> findByCategory(Category category);
}
