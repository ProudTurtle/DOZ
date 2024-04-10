package com.example.DOZ.repositories;

import com.example.DOZ.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findAll();

    List<Sale> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
