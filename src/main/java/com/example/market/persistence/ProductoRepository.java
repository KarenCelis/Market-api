package com.example.market.persistence;

import com.example.market.domain.Product;
import com.example.market.persistence.crud.ProductoCrudRepository;
import com.example.market.persistence.entity.Producto;
import com.example.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.market.domain.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Repository

public class ProductoRepository implements ProductRepository{
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){

        return mapper.toProducts((List<Producto>) productoCrudRepository.findAll());

    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {


        return Optional.of(mapper.toProducts(productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);

    }
/*
    public List<Producto> getByCategoria(int idCategoria){

       // return productoCrudRepository.findByIdCategoria(idCategoria);
    return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
}

public Optional<List<Producto>> getEscasos(int cantidad){

        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);

}
public Optional<Producto> getProducto(int idProducto){


        return productoCrudRepository.findById(idProducto);
}

///guardar producto

    public Producto save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(product));
    }
    */


}
