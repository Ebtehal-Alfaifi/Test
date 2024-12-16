package com.example.farms.Model;


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
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plantId;



    @NotEmpty(message = "plant type can not be null")
    @Pattern(
            regexp = "^(Palm|Fruits|Vegetables)$",
            message = "Plant type must be either 'Palm', 'Fruits', or 'Vegetables'."
    )
    @Size(max =10,message =" plant type should be 10 character only" )
    @Column(columnDefinition = "varchar(10) not null")
    private String type;



    @NotNull(message = "quantity can not be null")
    @Positive(message = " quantity should has positive number")
    @Column(columnDefinition = "int not null")
    private Integer quantity;



    @ManyToOne(cascade = CascadeType.ALL)
    private Farm farm;
}
