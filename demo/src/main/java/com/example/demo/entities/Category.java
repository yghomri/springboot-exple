package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 70)
    private String categoryName;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<Produit> produits;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Collection<Produit> getProduits() {
        return produits;
    }
    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Category() {
    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
