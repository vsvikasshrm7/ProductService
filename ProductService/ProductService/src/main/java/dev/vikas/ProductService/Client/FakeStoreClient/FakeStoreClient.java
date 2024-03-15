package dev.vikas.ProductService.Client.FakeStoreClient;

import dev.vikas.ProductService.DTO.ProductDto;
import dev.vikas.ProductService.Exception.ProductNotFoundException;
import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<FakestoreProductDto> getAllProduct(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products", FakestoreProductDto[].class);
        List<FakestoreProductDto> answer = new ArrayList<>();
        for(FakestoreProductDto fakestoreProductDto : l.getBody()){
            answer.add(fakestoreProductDto);
        }
        return answer;
    }
    public Optional<FakestoreProductDto> getSingleProduct(Long productId) throws ProductNotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakestoreProductDto.class, productId);
        FakestoreProductDto fakestoreProductDto = response.getBody();
        if(fakestoreProductDto ==null) {
            throw new ProductNotFoundException("Product Not Found with id :" + productId);
        }

        return Optional.of(fakestoreProductDto);
    }
    public FakestoreProductDto addNewProduct(Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreProductDto> fakestoreProductDtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakestoreProductDto.class);

        return fakestoreProductDtoResponseEntity.getBody();
    }
    public FakestoreProductDto updateProduct(Long productId, Product product){
        return null;
    }
    public FakestoreProductDto replaceProduct(Long productId, Product product){
        return null;
    }
    public boolean deleteProduct(Long productId){
        return false;
    }


}
