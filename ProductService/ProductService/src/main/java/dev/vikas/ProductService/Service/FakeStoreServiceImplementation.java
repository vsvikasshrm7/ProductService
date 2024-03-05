package dev.vikas.ProductService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.vikas.ProductService.DTO.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.vikas.ProductService.DTO.ProductDto;
import dev.vikas.ProductService.Models.Category;
import dev.vikas.ProductService.Models.Product;

@Service
@Primary
public class FakeStoreServiceImplementation implements ProductService {

  private RestTemplateBuilder restTemplateBuilder;
    @Autowired
        FakeStoreServiceImplementation(RestTemplateBuilder restTemplateBuilder){
           this.restTemplateBuilder = restTemplateBuilder;
        }

    @Override
    public List<Product> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> answer = new ArrayList<Product>();
      
        for(ProductDto productDto : l.getBody()){
            Product product = getProductfromProductDto(productDto);
            answer.add(product);
        }
        return answer;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
           RestTemplate restTemplate = restTemplateBuilder.build();
           ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class, productId);
            ProductDto productDto = response.getBody();
            Product product = getProductfromProductDto(productDto);

            if(product==null){
                return Optional.empty();
            }
            return Optional.of(product);
    }

    @Override
    public Product addNewProduct(Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", product, ProductDto.class);

        return getProductfromProductDto(productDtoResponseEntity.getBody());
    }


    @Override
    public Product updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());


        //ResponseEntity<ProductDto> response = restTemplate.execute(null, null, null, null)
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

        
	/*public <T> ResponseEntity<T> requestForEntity(String url, HttpMethod method,
			@Nullable HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables)
			throws RestClientException {
             RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class);

		RequestCallback requestCallback = restTemplate.httpEntityCallback(requestEntity, responseType);
		ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
		return nonNull(execute(url, method, requestCallback, responseExtractor, uriVariables));
	}*/
    
    
}
