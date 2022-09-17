package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.EntityRepository;
import com.example.demo.daoSpringData.CategoryRepository;
import com.example.demo.daoSpringData.ProduitRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Produit;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        // With JPA - No Spring Data
        EntityRepository<Produit> produitDao = ctx.getBean(EntityRepository.class);
        produitDao.save(new Produit("LX 456", 8000, 7));
        produitDao.save(new Produit("HP 654", 500, 8));
        produitDao.save(new Produit("HP 786", 2000, 5));

        List<Produit> produits = produitDao.findAll();
        for (Produit produit:produits) {
            System.out.println("Id: " + produit.getId());
            System.out.println("Des: " + produit.getDesignation());
            System.out.println("price: " + produit.getPrix());
            System.out.println("Quantity: " + produit.getQuantite());
        }

        List<Produit> produitsDes = produitDao.findByDesignation("%H%");
        for (Produit produit:produitsDes) {
            System.out.println("Id: " + produit.getId());
            System.out.println("Des: " + produit.getDesignation());
            System.out.println("price: " + produit.getPrix());
        }

        // With Spring Data. Load the bean and get the implementation of interface
        ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
        CategoryRepository categoryRepository = ctx.getBean(CategoryRepository.class);

        Category c1 = new Category("Laptop");
        Category c2 = new Category("Printer");
        Category c3 = new Category("Software");

        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c3);

        produitRepository.save(new Produit("LX 4", 400, 4, c1));
        produitRepository.save(new Produit("PX 5", 500, 5, c1));
        produitRepository.save(new Produit("PX 6", 600, 6, c2));

        List<Produit> produitsRep = produitRepository.findAll();
        for (Produit produit:produitsRep) {
            System.out.println("Id: " + produit.getId());
            System.out.println("Des: " + produit.getDesignation());
            System.out.println("price: " + produit.getPrix());
        }

        List<Produit> produitsByDes = produitRepository.produitByDesi("%PX%");
        for (Produit produit:produitsByDes) {
            System.out.println("Id: " + produit.getId());
            System.out.println("Des: " + produit.getDesignation());
            System.out.println("price: " + produit.getPrix());
            System.out.println("category name: " + produit.getCategory().getCategoryName());
            System.out.println("category id: " + produit.getCategory().getId());
        }
    }
}
