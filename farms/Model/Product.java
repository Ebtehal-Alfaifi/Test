package com.example.farms.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @NotEmpty(message = "Product Name cannot be empty")
    @Size(min = 2, max = 50, message = "Product Name must be between 2 and 50 characters")
    private String name;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @NotEmpty(message = "Product Category cannot be empty")
    @Size(min = 1, max = 50, message = "Plant Type must be 50 characters maximum")
    @Pattern(regexp = "^(Animal|Agricultural)$",
            message = "Product Category must be either 'Animal' or 'Agricultural'")
    private String category;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    @NotEmpty(message = "Product Description cannot be empty")
    @Size(min = 1, max = 255, message = "Product Description must be 255 characters maximum")
    private String description;

    @Column(columnDefinition = "DECIMAL NOT NULL")
    @NotNull(message = "Product Price cannot be empty")
    @Positive(message = "Product Price must be positive number")
    private Double price;

    //
    @ManyToOne
    @JsonIgnore
    private OrderFD orderFD;

    @ManyToOne
    @JsonIgnore
    private Supplier supplier;
}


