package com.example.farms.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @NotEmpty(message = "Customer Name cannot be empty")
    @Size(min = 2, max = 50, message = "Customer Name must be between 2 and 50 characters")
    private String name;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL UNIQUE")
    @NotEmpty(message = "Customer Email cannot be empty")
    @Size(min = 8, max = 50, message = "Customer Email must be between 8 and 50 characters")
    @Email(message = "Customer Email must be in valid email format")
    private String email;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL UNIQUE")
    @NotEmpty(message = "Customer Phone Number cannot be empty")
    @Pattern(regexp = "^05\\d{8}$",
            message = "Customer Phone number must start with '05' and be exactly 10 digits long.")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @NotEmpty(message = "Customer Address cannot be empty")
    @Size(min = 1, max = 100, message = "Customer Address must be 100 characters maximum")
    private String address;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @NotEmpty(message = "Customer Password cannot be empty")
    @Size(max = 50, message = "Customer Password must be 50 characters maximum")
    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$",
            message = "Customer Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 8 characters long.")
    private String password;

    @Column(columnDefinition = "INT NOT NULL")
    @NotNull(message = "Supplier Company Register Number cannot be empty")
    @Min(value = 10, message = "Supplier Company Register Number must be exactly 10 digits")
    @Max(value = 10, message = "Supplier Company Register Number must be exactly 10 digits")
    private Integer companyRegister;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<Product> products;


    @OneToMany(cascade =CascadeType.ALL,mappedBy = "supplier")
    private Set<HeavyEquipment>heavyEquipments;


}

