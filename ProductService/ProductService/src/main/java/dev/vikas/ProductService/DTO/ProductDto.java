package dev.vikas.ProductService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageurl;
    private String category;
    private RatingDto rating;
}
