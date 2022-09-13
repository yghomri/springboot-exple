package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.EntityRepository;
import com.example.demo.entities.Produit;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
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
	}

}
