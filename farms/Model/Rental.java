package com.example.farms.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @NotNull(message = "Rental Date Start cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rentalStartDate;

    @Column(columnDefinition = "DATETIME NOT NULL")
    @NotNull(message = "Rental End Date cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rentalEndDate;

    @Column(columnDefinition = "DECIMAL NOT NULL")
    @NotNull(message = "Rental Price cannot be empty")
    @Positive(message = "Rental Price must be positive number")
    private Integer rentalPrice;

    @Column(columnDefinition = "VARCHAR(50) DEFAULT ('Active')")
    @NotEmpty(message = "Rental Status cannot be empty")
    @Size(min = 1, max = 50, message = "Rental Status must be 50 characters maximum")
    @Pattern(regexp = "^(Active|Cancelled|Completed)$",
            message = "Rental Status must be either 'Active', 'Cancelled, or 'Completed'")
    private String Status = "Active";

    //
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rental")
    private Set<HeavyEquipment> heavyEquipments;
}
