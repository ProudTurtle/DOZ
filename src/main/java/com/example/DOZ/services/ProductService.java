package com.example.DOZ.services;

import com.example.DOZ.models.DTOs.PriceListEntryDTO;
import com.example.DOZ.models.Product;
import com.example.DOZ.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;

    @Transactional
    public void changePrice(List<PriceListEntryDTO> priceList) {
        for (PriceListEntryDTO entry : priceList) {
            Product product = productRepository.findByEan(entry.getEan()).orElseThrow(() -> new IllegalArgumentException("Product with ean: " + entry.getEan() + " not found."));
            product.setPrice(entry.getPrice());
            productRepository.save(product);
        }
    }
}
