package dev.vikas.ProductService.Controllers;



import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vikas.ProductService.Service.CategoryService;
import dev.vikas.ProductService.Models.Category;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    //@Autowired
    //private CategoryService categoryService;
    

    
    /*@GetMapping()
    public List<Category> getAllCategory(){
          return null;
    }*/
}