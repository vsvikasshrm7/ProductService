package dev.vikas.ProductService.Repository;

import dev.vikas.ProductService.Models.Product;
import net.sf.jsqlparser.statement.select.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @Query("select p.title from Product p where p.id =: id")
    List<Product> LaooProductWithId(Long id);

    Product save(Product product);
    Product findProductsById(Long id);

    @Override
    Page<Product> findAll(Pageable pageable);
}
