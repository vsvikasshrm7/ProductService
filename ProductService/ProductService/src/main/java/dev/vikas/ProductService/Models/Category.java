package dev.vikas.ProductService.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.jdbc.Size;

@Getter
@Setter
@Entity
public class Category extends BaseClass {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 1)
    private List<Product> products;
    //mappedBy = "category"
}
//FetchMode allows to solve how associated object is fetched
//Spring data JPA modifies the behaviour of FetchMode a lot



