package com.example.demo.daoSpringData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Produit;

// Extends from JpaRepository generic interface
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // If we have a custom query
    @Query("select p from Produit p where p.designation like :x")
    public List<Produit> produitByDesi(@Param("x") String mc);
}
