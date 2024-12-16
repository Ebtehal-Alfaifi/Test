package com.example.farms.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @Size(min = 2, max = 50, message = "Admin Name must be between 2 and 50 characters")
    @NotEmpty(message = "Event Name cannot be empty")
    private String name;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 100, message = "Customer Address must be 100 characters maxixmum")
    @NotEmpty(message = "Event Description cannot be empty")
    private String description;

    /// URL
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 100, message = "Event Location must be 100 characters maximum")
    @NotEmpty(message = "Event Location cannot be empty")
    private String location;

    @Column(columnDefinition = "DATETIME NOT NULL")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull(message = "Event Start Date cannot be empty")
    private LocalDateTime startDate;

    @Column(columnDefinition = "DATETIME NOT NULL")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull(message = "Event End Date cannot be empty")
    private LocalDateTime endDateTime;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    @NotEmpty(message = "Event Status cannot be empty")
    @Pattern(regexp = "^(Scheduled|Ongoing|Completed)$",
            message = "Event Status must be either 'Scheduled', 'Ongoing', or 'Completed'")
    private String status;

    //
    @ManyToOne
    @JsonIgnore
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Set<EventParticipants> eventParticipants;


}
