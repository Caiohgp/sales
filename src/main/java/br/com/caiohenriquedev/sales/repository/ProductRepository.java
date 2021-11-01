package br.com.caiohenriquedev.sales.repository;

import br.com.caiohenriquedev.sales.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
