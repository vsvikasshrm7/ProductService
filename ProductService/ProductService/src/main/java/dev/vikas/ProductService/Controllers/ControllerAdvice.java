package dev.vikas.ProductService.Controllers;

import dev.vikas.ProductService.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleexception(Exception exception){

        return new ResponseEntity(exception.getMessage(), HttpStatus.OK);
    }
}
