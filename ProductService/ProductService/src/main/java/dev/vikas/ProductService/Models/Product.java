package dev.vikas.ProductService.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseClass{
    private String title;
    private double price;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn
    @Fetch(FetchMode.SELECT)
    private Category category;
    //private String category;
    private String imageUrl;
    //private boolean isPublic;
}
