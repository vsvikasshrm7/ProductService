package dev.vikas.ProductService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.vikas.ProductService.Client.FakeStoreClient.FakeStoreClient;
import dev.vikas.ProductService.Client.FakeStoreClient.FakestoreProductDto;
import dev.vikas.ProductService.Exception.ProductNotFoundException;
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
public class FakeStoreServiceImplementation implements ProductService {

  private FakeStoreClient fakeStoreClient;

    public FakeStoreServiceImplementation(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    //    public <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
//        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
//        return (ResponseEntity)RestTemplate.nonNull((ResponseEntity)restTemplate.execute(url, HttpMethod.POST, requestCallback, responseExtractor, uriVariables));
//    }
    @Override
    public List<Product> getAllProduct() {
        List<FakestoreProductDto> fakestoreProductDtos =  fakeStoreClient.getAllProduct();
        List<Product> productList = new ArrayList<>();
        for(FakestoreProductDto fakestoreProductDto : fakestoreProductDtos){
            productList.add(getProductfromFakeStoreProductDto(fakestoreProductDto));
        }
        return productList;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws ProductNotFoundException {
           Optional<FakestoreProductDto> fakestoreProductDto = fakeStoreClient.getSingleProduct(productId);
           FakestoreProductDto fakestoreProductDto1 = fakestoreProductDto.get();
           return Optional.of(getProductfromFakeStoreProductDto(fakestoreProductDto1));
    }

    @Override
    public Product addNewProduct(Product product) {
        FakestoreProductDto fakestoreProductDto = fakeStoreClient.addNewProduct(product);
        return getProductfromFakeStoreProductDto(fakestoreProductDto);
    }


    @Override
    public Product updateProduct(Long productId, Product product) {
        //RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
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
    public Product getProductfromFakeStoreProductDto(FakestoreProductDto fakestoreProductDto){
        Product product = new Product();
        product.setTitle(fakestoreProductDto.getTitle());
        product.setDescription(fakestoreProductDto.getDescription());
        product.setImageUrl(fakestoreProductDto.getImageurl());
        product.setPrice(fakestoreProductDto.getPrice());
        Category category = new Category();
        category.setName(fakestoreProductDto.getCategory());
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
