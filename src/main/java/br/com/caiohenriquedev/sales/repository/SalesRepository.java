package br.com.caiohenriquedev.sales.repository;

import br.com.caiohenriquedev.sales.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sale,Long> {
}
