package tumo.spring.rest.api.workshop.bakeryapp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tumo.spring.rest.api.workshop.bakeryapp.api.domain.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<Product> findById(Long id);
    Optional<Product> findProductByName(String name);   

//    @Query
}
