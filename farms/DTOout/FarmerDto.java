package com.example.farms.DTOout;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FarmerDto{


    private String name;

    private Integer phoneNumber;

    private String address;

    private String visaType;
}
