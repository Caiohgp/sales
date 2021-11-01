package br.com.caiohenriquedev.sales.service;

import br.com.caiohenriquedev.sales.domain.Product;
import br.com.caiohenriquedev.sales.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProductService {

    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, Long idProduct) {
        Optional<Product> productOptional = productRepository.findById(idProduct);

        if (productOptional.isPresent()){
            productOptional.get().setName(product.getName());
            productOptional.get().setPrice(product.getPrice());
            return productRepository.save(productOptional.get());
        }else{
            return null;
        }
    }

    public void deleteProduct(Long id){
        productRepository.delete(findById(id));
    }
}
