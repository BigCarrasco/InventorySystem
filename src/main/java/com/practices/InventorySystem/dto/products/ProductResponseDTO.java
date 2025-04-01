package com.practices.InventorySystem.dto.products;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
}