package com.mproduits.web.controller;

import com.mproduits.dao.ProductDao;
import com.mproduits.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mproduits.configuration.ApplicationPropertiesConfiguration;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    ProductDao productDao;
    
    ApplicationPropertiesConfiguration appPropertiesConfiguration;

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/Produits")
    public List<Product> listeDesProduits(){

        List<Product> products = productDao.findAllWithLimit(appPropertiesConfiguration.getLimitDeProduits());

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        return products;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/Produits/{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {

        Optional<Product> product = productDao.findById(id);

        if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }
    
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    @Autowired
    public void setAppPropertiesConfiguration(ApplicationPropertiesConfiguration appPropertiesConfiguration) {
        this.appPropertiesConfiguration = appPropertiesConfiguration;
    }
}

