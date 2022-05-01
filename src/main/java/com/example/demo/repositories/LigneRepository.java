package com.example.demo.repositories;

import com.example.demo.entities.Client;
import com.example.demo.entities.Command;
import com.example.demo.entities.LigneCommand;
import com.example.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneRepository extends JpaRepository<LigneCommand,Long> {

//    List<LigneCommand> findByClient(Client client);

    List<LigneCommand> findByProduit(Produit produit);

    List<LigneCommand> findByCommand(Command command);
}
