package com.example.farms.Repository;

import com.example.farms.Model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant,Integer> {
    Plant findPlantByPlantId(Integer plantId);
}
