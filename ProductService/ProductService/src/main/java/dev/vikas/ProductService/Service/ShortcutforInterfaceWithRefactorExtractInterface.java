//package dev.vikas.ProductService.Service;
//
//import dev.vikas.ProductService.DTO.ProductDto;
//import dev.vikas.ProductService.DTO.UserDto;
//import dev.vikas.ProductService.Models.Product;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface ShortcutforInterfaceWithRefactorExtractInterface {
//    List<Product> getAllProduct();
//
//    ResponseEntity<UserDto> getfortest();
//
//    Optional<Product> getSingleProduct(Long productId);
//
//    Product addNewProduct(ProductDto productDto);
//
//    Product updateProduct(Long productId, Product product);
//
//    Product replaceProduct(Long productId, Product product);
//
//    boolean deleteProduct(Long productId);
//
//    Page<Product> getPageProduct(int numberPageableOfProduct, int offset);
//}
