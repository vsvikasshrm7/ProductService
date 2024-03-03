package dev.vikas.ProductService.Service;

import java.util.List;
import java.util.Optional;

import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Models.Product;

public interface CategoryService {
    
    List<Category> getAllCategories();

    List<Product> getProductInCategory();

}
