package dev.vikas.ProductService.Service;

import java.util.List;
import java.util.Optional;

import dev.vikas.ProductService.DTO.ProductDto;
import dev.vikas.ProductService.Models.Product;

public interface ProductService {
    List<Product> getAllProduct();
    Optional<Product> getSingleProduct(Long productId);
    Product addNewProduct(ProductDto productDto);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
    boolean deleteProduct(Long productId);
    
}
