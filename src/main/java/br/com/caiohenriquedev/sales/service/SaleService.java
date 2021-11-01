package br.com.caiohenriquedev.sales.service;

import br.com.caiohenriquedev.sales.Request.PostSaleRequest;
import br.com.caiohenriquedev.sales.domain.Product;
import br.com.caiohenriquedev.sales.domain.Sale;
import br.com.caiohenriquedev.sales.repository.ProductRepository;
import br.com.caiohenriquedev.sales.repository.SalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class SaleService {

    SalesRepository salesRepository;
    ProductService productService;

    public List<Sale> findAll(){
        return salesRepository.findAll();
    }

    public Sale findById(Long id){
        return salesRepository.findById(id).get();
    }

    public Sale save(PostSaleRequest postSaleRequest){
        Product product = productService.findById(postSaleRequest.getProduct().getId());
        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setPaymentMethod(postSaleRequest.getPaymentMethod());
        return salesRepository.save(sale);

    }

    public Sale update(Sale sale,Long id){
        return salesRepository.save(sale);
    }

    public void delete(Long id){
        salesRepository.deleteById(id);
    }




}
