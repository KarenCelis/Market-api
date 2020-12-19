package com.example.market.persistence;

import com.example.market.persistence.crud.ProductoCrudRepository;
import com.example.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();

    }


}
