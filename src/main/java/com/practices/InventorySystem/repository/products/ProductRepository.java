package com.practices.InventorySystem.repository.products;

import com.practices.InventorySystem.entity.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
