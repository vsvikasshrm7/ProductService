package dev.vikas.ProductService.Client.FakeStoreClient;

import dev.vikas.ProductService.DTO.RatingDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageurl;
    private String category;
    private RatingDto rating;
}
