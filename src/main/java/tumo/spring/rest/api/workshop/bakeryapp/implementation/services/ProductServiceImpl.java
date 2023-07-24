package tumo.spring.rest.api.workshop.bakeryapp.implementation.services;


import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import tumo.spring.rest.api.workshop.bakeryapp.api.domain.Product;
import tumo.spring.rest.api.workshop.bakeryapp.api.repositories.ProductRepository;
import tumo.spring.rest.api.workshop.bakeryapp.api.services.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public Product findByName(String name) {
        Optional<Product> product = productRepository.findProductByName(name);
        return product.get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(String name, Double price, String description) {
        Product newProduct = new Product(name, price, description);
        productRepository.saveAndFlush(newProduct);
        return newProduct;
    }

    @Override
    public Product updateProduct(String name, @Nullable Double price, @Nullable String description) {
        Optional<Product> product = productRepository.findProductByName(name);
        if (product.isPresent()) {
            if (price != null) {
                if (product.isPresent()) {
                    product.get().setPrice(price);
                }
            }
            if (description != null) {
                product.get().setDescription(description);
            }
            Product savedProduct = productRepository.save(product.get());
            return savedProduct;
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
    }
}
