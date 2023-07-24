package tumo.spring.rest.api.workshop.bakeryapp.api.services;

import jakarta.annotation.Nullable;
import tumo.spring.rest.api.workshop.bakeryapp.api.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * Retrieve a specific product object by its id
     *
     * @param id A unique id for the product
     */
    Product findById(Long id);

    Product findByName(String name);

    List<Product> findAll();

    Product saveProduct(
            String name,
            Double price,
            String description);

    Product updateProduct(
            String name,
            @Nullable Double price,
            @Nullable String description);

    void deleteProduct(Long id);
}
