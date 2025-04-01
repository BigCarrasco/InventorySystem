package com.practices.InventorySystem.dto.products;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    private String description;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private int quantity;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private double price;
}