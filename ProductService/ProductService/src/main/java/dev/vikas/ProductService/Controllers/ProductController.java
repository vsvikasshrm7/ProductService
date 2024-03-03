package dev.vikas.ProductService.Controllers;

import java.util.List;
import java.util.Optional;

//import dev.vikas.ProductService.ElasticSearchRepository.ProductElascticSearchRepository;
//import dev.vikas.ProductService.ElasticSearchRepository.ProductModel;
import dev.vikas.ProductService.DTO.UserDto;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    List<Product> getAllProduct(){
        List<Product> product = productService.getAllProduct();
         return product;
    }

    @GetMapping("/{productId}")
    ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>(0);
        headers.add("auth-token", "noaccess");
        ResponseEntity<Product> resposne = new ResponseEntity(productService.getSingleProduct(productId), headers, HttpStatus.NOT_FOUND);
        return resposne;
    }

    //We can return object also and accordingly it will be desialized
    @PostMapping()
    ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){

        ResponseEntity<Product> response = new ResponseEntity<Product>(productService.addNewProduct(productDto), null, HttpStatus.FOUND);
        return response;
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



}
