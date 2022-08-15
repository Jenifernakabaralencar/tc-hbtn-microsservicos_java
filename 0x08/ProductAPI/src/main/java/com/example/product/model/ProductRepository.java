package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        for (Product p:list) {
            if (p.getId() == id){
                return p;
            }
        }return null;
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        for (Product p: list) {
            if (p.getId() == s.getId()){
                p.setName(s.getName());
                p.setCode(s.getCode());
                p.setCreatedOne(s.getCreatedOne());
                p.setDescription(s.getDescription());
                p.setPrice(s.getPrice());
                p.setStatus(s.getStatus());
            }
        }
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }
}
