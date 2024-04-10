package com.example.DOZ.models.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceListEntryDTO {

    @Size(min = 13, max = 13, message = "EAN must be exactly 13 characters long.")
    public String ean;

    @Min(value = 0, message = "Price must be greater than or equal to 0.")
    public double price;
}
