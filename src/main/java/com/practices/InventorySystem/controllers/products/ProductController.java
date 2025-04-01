package com.practices.InventorySystem.controllers.products;

import com.practices.InventorySystem.dto.products.ProductRequestDTO;
import com.practices.InventorySystem.dto.products.ProductResponseDTO;
import com.practices.InventorySystem.entity.products.Product;
import com.practices.InventorySystem.service.products.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ProductResponseDTO create(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.save(productRequestDTO);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO update(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.update(id, productRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
