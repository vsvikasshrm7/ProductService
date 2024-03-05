package dev.vikas.ProductService.Service;

import dev.vikas.ProductService.DTO.ProductDto;
import dev.vikas.ProductService.DTO.RatingDto;
import dev.vikas.ProductService.DTO.UserDto;
import dev.vikas.ProductService.Models.Product;
import dev.vikas.ProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.PageAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private RestTemplate restTemplate;
    @Autowired
    SelfProductService(ProductRepository productRepository, RestTemplate restTemplate){
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


    public ResponseEntity<UserDto> getfortest(){
        //RestTemplate restTemplate = new RestTemplate();
        //Here we don't have to make rest template object but to use beans of it
        ResponseEntity<UserDto> response =  restTemplate.getForEntity("http://userservice/authentication/get", UserDto.class);
        return response;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(!optionalProduct.isEmpty()){
            return optionalProduct;
        }

        return Optional.empty();
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }


    public Page<Product> getPageProduct(int numberPageableOfProduct, int offset){
        return productRepository.findAll(PageRequest.of(offset/numberPageableOfProduct, numberPageableOfProduct, Sort.by(Sort.Direction.ASC, "price")));
    }
}
