package com.amdocs.dao;

import java.util.ArrayList;
import java.util.List;

import com.amdocs.pojos.ConcretePlant;
import com.amdocs.pojos.Plant;

//Create a concrete class for PlantDAO
public class ConcretePlantDAO implements PlantDAO {
private List<Plant> plants;
private static int nextId = 0;
public ConcretePlantDAO() {
 this.plants = new ArrayList<>();
}

@Override
public int addPlant(Plant plant) {
	nextId++;
	plant.setPlantId(nextId);
 plants.add(plant);
 return plant.getPlantId();
}

@Override
public int deletePlant(int plantId) {
 for (Plant plant : plants) {
     if (plant.getPlantId() == plantId) {
         plants.remove(plant);
         return plantId;
     }
 }
 return -1;
}

@Override
public boolean updatePlantCost(int plantId, double newCost) {
 for (Plant plant : plants) {
     if (plant.getPlantId() == plantId) {
         ((ConcretePlant) plant).cost = newCost;
         return true;
     }
 }
 return false;
}

@Override
public List<Plant> showAllPlants() {
 return plants;
}

@Override
public List<Plant> searchByOriginCountryName(String countryName) {
 List<Plant> result = new ArrayList<>();
 for (Plant plant : plants) {
     if (plant.getOriginCountryName().equalsIgnoreCase(countryName)) {
         result.add(plant);
     }
 }
 return result;
}

@Override
public List<Plant> searchOutdoorPlantsWithSunlight() {
 List<Plant> result = new ArrayList<>();
 for (Plant plant : plants) {
     if (plant.getPlantType().equalsIgnoreCase("outdoor") && plant.isSunlightRequired()) {
         result.add(plant);
     }
 }
 return result;
}

@Override
public int countPlantsByWaterSupplyFrequency(String frequency) {
 int count = 0;
 for (Plant plant : plants) {
     if (plant.getWaterSupplyFrequency().equalsIgnoreCase(frequency)) {
         count++;
     	}	
 	}
 return count;
	}
}




