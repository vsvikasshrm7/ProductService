package dev.vikas.ProductService.Models;

import jakarta.persistence.CascadeType;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseClass{
    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Category category;
    //private String category;
    private String imageUrl;
    //private boolean isPublic;
}
