package tumo.spring.rest.api.workshop.bakeryapp.implementation.controllers.io;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import tumo.spring.rest.api.workshop.bakeryapp.api.domain.Product;
import tumo.spring.rest.api.workshop.bakeryapp.api.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Retrieves
    @GetMapping("{id}")
    public Product findById(@PathVariable Long id) {
        Product product = this.productService.findById(id);
        return product;
    }

    @Operation(
        summary = "retrieve a specific product by its name",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Succesfully retrieved the product"
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error"
                )
        }
    )

    @GetMapping("{name}")
    public Product findByName(@PathVariable String name) {
        Product product = this.productService.findByName(name);
        return product;
    }

    @GetMapping("")
    public List<Product> findAll() {
        List<Product> allProducts = this.productService.findAll();
        return allProducts;
    }

    //Create 
    @PostMapping("")
    public Product createProduct(
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam String description) {
        Product product = this.productService.saveProduct(name, price, description);
        return product;
    }

    //Update
    @PutMapping("")
    public Product updateProduct(
            @RequestParam String name,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description) {
        Product product = this.productService.updateProduct(name, price, description);
        return (product);
    }

    //Delete
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
    }
}