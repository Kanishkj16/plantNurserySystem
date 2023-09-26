package com.amdocs.pojos;
import java.util.Scanner;
// Kanishk. J

// Defining my Plant interface
public interface Plant {
    int getPlantId();
    String getPlantName();
    String getOriginCountryName();
    boolean isSunlightRequired();
    String getWaterSupplyFrequency();
    String getPlantType();
    double getCost();
	void setPlantId(int plantId);
	void setPlantName(String plantName);
	void setOriginCountryName(String originCountryName);
	void setSunlightRequired(boolean sunlightRequired);
	void setWaterSupply(String waterSupplyFrequency);
	void setPlantType(String plantType);
}


