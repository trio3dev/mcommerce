package com.mproduits.dao;

import com.mproduits.model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
    
    default List<Product> findAllWithLimit(int limit){
        Pageable pageable = PageRequest.of(0, limit);
        return findAll(pageable).getContent();
    }
}
