package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 70)
    private String designation;
    private double prix;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private Category category;
    
    public Produit() {

    }
    public Produit(String designation, double prix, int quantite) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }
    public Produit(String designation, double prix, int quantite, Category category) {
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
        this.category = category;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public Long getId() {
        return id;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
