package dev.vikas.ProductService.Service;

import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Models.Product;

import java.util.List;

public class FakeStoreCategoryImplementation implements CategoryService{

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getProductInCategory() {
        return null;
    }
}
