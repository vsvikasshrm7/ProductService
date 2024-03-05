package dev.vikas.ProductService.Controllers;



import dev.vikas.ProductService.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.vikas.ProductService.Service.CategoryService;
import dev.vikas.ProductService.Models.Category;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {
   private CategoryService categoryService;

   @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/all/{category}")
    public List<Product> getProductInCategory(@PathVariable("category") String category) {
        return categoryService.getProductInCategory();
    }
}
