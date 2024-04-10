package com.example.DOZ.controllers;

import com.example.DOZ.models.DTOs.PriceListEntryDTO;
import com.example.DOZ.repositories.SaleRepository;
import com.example.DOZ.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class ApiController {

    ProductService productService;
    SaleRepository saleRepository;


    @PostMapping("/update-prices")
    public ResponseEntity<?> updatePrices(@Valid @RequestBody List<PriceListEntryDTO> priceList, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }

        try {
            productService.changePrice(priceList);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/sales-report/{date}")
    public ResponseEntity<?> getSalesReport(@PathVariable("date") String date){
        LocalDate convertDate = LocalDate.parse(date);
        LocalDateTime startOfDay = LocalDateTime.of(convertDate, LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(convertDate, LocalTime.MAX);

        return ResponseEntity.ok(saleRepository.findAllByDateBetween(startOfDay, endOfDay));
    }



}
