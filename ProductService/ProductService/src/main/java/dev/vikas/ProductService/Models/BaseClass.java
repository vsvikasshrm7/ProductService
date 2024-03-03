package dev.vikas.ProductService.Models;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Date;

@Getter
@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@MappedSuperclass
public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}
