package com.amdocs.pojos;

//Create a concrete class for Plant
public class ConcretePlant implements Plant {
private int plantId;
private String plantName;
private String originCountryName;
private boolean sunlightRequired;
private String waterSupplyFrequency;
private String plantType;
public double cost;

public ConcretePlant(int plantId, String plantName, String originCountryName, boolean sunlightRequired,
                    String waterSupplyFrequency, String plantType, double cost) {
   this.plantId = plantId;
   this.plantName = plantName;
   this.originCountryName = originCountryName;
   this.sunlightRequired = sunlightRequired;
   this.waterSupplyFrequency = waterSupplyFrequency;
   this.plantType = plantType;
   this.cost = cost;
}

@Override
public int getPlantId() {
   return plantId;
}

@Override
public void setPlantId(int plantId){
	this.plantId = plantId;
}

@Override
public String getPlantName() {
   return plantName;
}

@Override
public void setPlantName(String plantName){
	this.plantName = plantName;
}

@Override
public String getOriginCountryName() {
   return originCountryName;
}

@Override
public void setOriginCountryName(String originCountryName){
	this.originCountryName = originCountryName;
}

@Override
public boolean isSunlightRequired() {
   return sunlightRequired;
}

@Override
public void setSunlightRequired(boolean sunlightRequired){
	this.sunlightRequired = sunlightRequired;
}

@Override
public String getWaterSupplyFrequency() {
   return waterSupplyFrequency;
}

@Override
public void setWaterSupply(String waterSupplyFrequency){
	this.waterSupplyFrequency = waterSupplyFrequency;
}

@Override
public String getPlantType() {
   return plantType;
}

@Override
public void setPlantType(String plantType){
	this.plantType = plantType;
}

@Override
public double getCost() {
   return cost;
}
}