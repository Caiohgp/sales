package br.com.caiohenriquedev.sales.controller;

import br.com.caiohenriquedev.sales.domain.Product;
import br.com.caiohenriquedev.sales.repository.ProductRepository;
import br.com.caiohenriquedev.sales.service.ProductService;
import javassist.tools.web.BadHttpRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
@Log4j2
public class ProductController {

    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }



    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Long id){
        return ResponseEntity.ok(productService.updateProduct(product,id));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
