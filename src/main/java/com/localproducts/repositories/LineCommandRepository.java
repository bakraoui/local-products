package com.localproducts.repositories;

import com.localproducts.entities.Command;
import com.localproducts.entities.LineCommand;
import com.localproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineCommandRepository extends JpaRepository<LineCommand,Long> {

    List<LineCommand> findByProduct(Product product);

    List<LineCommand> findByCommand(Command command);
}
