package com.practices.InventorySystem.service.products;

import com.practices.InventorySystem.dto.products.ProductRequestDTO;
import com.practices.InventorySystem.dto.products.ProductResponseDTO;
import com.practices.InventorySystem.repository.products.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import com.practices.InventorySystem.entity.products.Product;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductResponseDTO mapToResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }

    private Product findByIdEntity(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        return mapToResponseDTO(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public ProductResponseDTO save(@Valid ProductRequestDTO productRequestDto) {
        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .quantity(productRequestDto.getQuantity())
                .price(productRequestDto.getPrice())
                .build();

        return mapToResponseDTO(productRepository.save(product));
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDto) {
        Product existing = findByIdEntity(id);
        existing.setName(productRequestDto.getName());
        existing.setDescription(productRequestDto.getDescription());
        existing.setQuantity(productRequestDto.getQuantity());
        existing.setPrice(productRequestDto.getPrice());
        return mapToResponseDTO(productRepository.save(existing));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
