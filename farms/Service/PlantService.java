package com.example.farms.Service;

import com.example.farms.API.ApiException;
import com.example.farms.Model.Farm;
import com.example.farms.Model.Plant;
import com.example.farms.Repository.FarmRepository;
import com.example.farms.Repository.PlantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;
    private final FarmRepository farmRepository;

    // get


    //add

    public Plant addPlant(Plant plant, Integer farmId){
        Farm farm=farmRepository.findFarmById(farmId);
        if (farm==null){
            throw new ApiException("farm does not existing");
        }
        plant.setFarm(farm);
        return plantRepository.save(plant);
    }

    public void updatePlant(Integer plantId,Plant plant){
        Plant oldPlant=plantRepository.findPlantByPlantId(plantId);
        if (oldPlant==null){
            throw new ApiException("plant does not found");
        }
        oldPlant.setQuantity(plant.getQuantity());
        oldPlant.setFarm(plant.getFarm());
        oldPlant.setType(plant.getType());
        plantRepository.save(oldPlant);
    }


}
