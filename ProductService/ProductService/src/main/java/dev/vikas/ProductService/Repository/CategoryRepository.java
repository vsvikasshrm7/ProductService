package dev.vikas.ProductService.Repository;

import dev.vikas.ProductService.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);
    List<Category> findAllByIdIn(List<Long> ids);
}
