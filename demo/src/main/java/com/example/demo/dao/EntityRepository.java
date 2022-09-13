package com.example.demo.dao;

import java.util.List;

// Generic interface that we can use for any entity, instead of using ProduitDao, CategoryDao interfaces ...etc
public interface EntityRepository<T> {
    public T save(T p);
    public List<T> findAll();
    public List<T> findByDesignation(String mc);
    public T findOne(Long id);
    public T update(T p);
    public void delete(Long id);    
}
