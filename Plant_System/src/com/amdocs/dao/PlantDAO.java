package com.amdocs.dao;
import java.util.List;

import com.amdocs.pojos.Plant;



//Define PlantDAO interface
public interface PlantDAO {
 int addPlant(Plant plant);
 int deletePlant(int plantId);
 boolean updatePlantCost(int plantId, double newCost);
 List<Plant> showAllPlants();
 List<Plant> searchByOriginCountryName(String countryName);
 List<Plant> searchOutdoorPlantsWithSunlight();
 int countPlantsByWaterSupplyFrequency(String frequency);
}

