package dev.vikas.ProductService.Service;

import java.util.List;
import java.util.Optional;

import dev.vikas.ProductService.DTO.ProductDto;
import dev.vikas.ProductService.DTO.RatingDto;
import dev.vikas.ProductService.Exception.ProductNotFoundException;
import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Models.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

public interface ProductService {
    List<Product> getAllProduct();
    Optional<Product> getSingleProduct(Long productId) throws ProductNotFoundException;
    Product addNewProduct(Product product);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
    boolean deleteProduct(Long productId);
    
}
