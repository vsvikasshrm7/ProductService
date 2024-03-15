package dev.vikas.ProductService;


import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Models.Product;
import dev.vikas.ProductService.Repository.CategoryRepository;
import dev.vikas.ProductService.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.antlr.stringtemplate.language.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;



//    public ProductTest(ProductRepository productRepository, CategoryRepository categoryRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//    }

    @Test
    void testFetchingType(){
//        Product product = new Product();
//        Category category = new Category();
//        category.setName("Phones");
//        Category savedcategory = categoryRepository.save(category);
//
//        product.setPrice(100);
//        product.setCategory(category);
//        product.setImageUrl("Hello");
//        Product saveedproduct = productRepository.save(product);

        Product product = new Product();
        Category category = new Category();
        category.setName("Electronics");
        //Category savedcategory = categoryRepository.save(category);

        product.setPrice(200);
        product.setCategory(category);
        product.setImageUrl("HelloNew");
        Product saveedproduct = productRepository.save(product);
    }
    @Test
    @Transactional
    void fetchTypeTest(){
//      Product product = productRepository.findProductsById(102L);
//      System.out.println("Fetched product");
//      Category category = product.getCategory();
//      String name = category.getName();
    }

    @Test
    void deleteProduct(){
        productRepository.deleteById(302L);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductForCategory(){
        Category category = categoryRepository.findById(2L).get();

        Product product = new Product();
        product.setPrice(1012);
        product.setImageUrl("Hello");
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);

    }
    @Test
    @Transactional
    void getProductsFromCategory(){
       // Category category = categoryRepository.findById(2L).get();
        List<Category> categories = categoryRepository.findAllByIdIn(List.of(1L, 2L));
         for(Category category1 :categories){
             for(Product product : category1.getProducts()){
                 System.out.println(product.getPrice());
             }
         }



    }
}

