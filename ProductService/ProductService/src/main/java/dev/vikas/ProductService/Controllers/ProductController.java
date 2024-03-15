package dev.vikas.ProductService.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import dev.vikas.ProductService.ElasticSearchRepository.ProductElascticSearchRepository;
//import dev.vikas.ProductService.ElasticSearchRepository.ProductModel;
import dev.vikas.ProductService.Client.FakeStoreClient.FakestoreProductDto;
import dev.vikas.ProductService.DTO.UserDto;
import dev.vikas.ProductService.Exception.ProductNotFoundException;
import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Service.FakeStoreServiceImplementation;
import dev.vikas.ProductService.Service.SelfProductService;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import dev.vikas.ProductService.DTO.ProductDto;
import dev.vikas.ProductService.Models.Product;
import dev.vikas.ProductService.Service.ProductService;
import dev.vikas.ProductService.Service.FakeStoreServiceImplementation;

import javax.management.Query;

@RestController
@RequestMapping("/products")
public class ProductController {

//    private FakeStoreServiceImplementation productService;
//    private SelfProductService selfProductService;
//    With this there is direct coupling of controller with FakeStoreServiceImplementation and self ProductService
//    SRP and OCP voilation, instead create Interface and implement it by fakeStore and Self ProductService
   private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //private ProductElascticSearchRepository productElascticSearchRepository;

//    @GetMapping("/get")
//    public ResponseEntity<UserDto> getforTest(){
//        return productService.getfortest();
//    }

    @GetMapping()
    List<ProductDto> getAllProduct(){
        List<Product> product = productService.getAllProduct();
        List<ProductDto> productDto = new ArrayList<>();
        for(Product product1 : product){
            productDto.add(getProductDtoFromProduct(product1));
        }
         return productDto;
    }

    @GetMapping("/{productId}")
    ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(0);
        headers.add("auth-token", "noaccess");
        ResponseEntity<Product> response = new ResponseEntity(productService.getSingleProduct(productId), headers, HttpStatus.NOT_FOUND);
        return response;
    }

    //We can return object also and accordingly it will be desialized
    //In this method - add new product we should take productDTO but we are taking product
    @PostMapping()
    ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product product = getProductfromProductDto(productDto);
        return new ResponseEntity<>(productService.addNewProduct(product), HttpStatus.OK);
    }


    @PatchMapping("/{productId}")
    Product updateProduct(@PathVariable Long productId, @RequestBody Product product){

        return productService.updateProduct(productId, product);
    }

    @PutMapping("/{productId}")
    Product replaceProduct(@PathVariable("productId") Long productId, @RequestBody Product product){
        return productService.replaceProduct(productId, product);
    }

//    @GetMapping("/getelastic")
//    public ResponseEntity<ProductModel> getProduct(@RequestBody String name){
//
//       return null;
//    }

    public ProductDto getProductDtoFromProduct(Product product){
        ProductDto productDto1 = new ProductDto();
        productDto1.setTitle(product.getTitle());
        productDto1.setPrice(product.getPrice());
        productDto1.setCategory(product.getCategory().getName());
        return productDto1;
    }
    public Product getProductfromProductDto(ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageurl());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        return product;
    }

}
