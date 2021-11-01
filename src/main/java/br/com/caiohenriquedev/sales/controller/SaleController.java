package br.com.caiohenriquedev.sales.controller;

import br.com.caiohenriquedev.sales.Request.PostSaleRequest;
import br.com.caiohenriquedev.sales.domain.Product;
import br.com.caiohenriquedev.sales.domain.Sale;
import br.com.caiohenriquedev.sales.service.SaleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
public class SaleController {

    SaleService saleService;


    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> findAll(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id){
        return ResponseEntity.ok(saleService.findById(id));
    }

    @PostMapping("/sales")
    public ResponseEntity<Sale> add(@RequestBody PostSaleRequest postSaleRequest){
        return new ResponseEntity<>(saleService.save(postSaleRequest),HttpStatus.CREATED);
    }

    @PutMapping("/sales/{id}")
    public ResponseEntity<Sale> update(@RequestBody Sale sale, @PathVariable Long id){
        saleService.update(sale,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        saleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
