package com.amdocs.main;
import java.util.List;
import java.util.Scanner;

import com.amdocs.dao.PlantDAO;
import com.amdocs.dao.ConcretePlantDAO;
import com.amdocs.exception.PlantNotFoundException;
import com.amdocs.pojos.ConcretePlant;
import com.amdocs.pojos.Plant;

public class PlantNurserySystem {
    public static void main(String[] args) {
        PlantDAO plantDAO = new ConcretePlantDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*******************************************");
            System.out.println("           My Plant Nursery System");
            System.out.println("***********************************************");
            System.out.println("1. Add new plant");
            System.out.println("2. Update plant cost");
            System.out.println("3. Delete plant");
            System.out.println("4. View all plants");
            System.out.println("5. Find plant by origin country name");
            System.out.println("6. Find outdoor plants which require sunlight");
            System.out.println("7. Count plants by water supply frequency");
            System.out.println("8. Exit");
            System.out.print("Enter the choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter plant name: ");
                    String plantName = scanner.nextLine();
                    System.out.print("Enter origin country name: ");
                    String originCountryName = scanner.nextLine();
                    System.out.print("Does it require sunlight? (true/false): ");
                    boolean sunlightRequired = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Enter water supply frequency (daily/weekly/alternate days): ");
                    String waterSupplyFrequency = scanner.nextLine();
                    System.out.print("Enter plant type (indoor/outdoor): ");
                    String plantType = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    double cost = scanner.nextDouble();
                    Plant newPlant = new ConcretePlant(plantDAO.showAllPlants().size() + 1, plantName, originCountryName,
                            sunlightRequired, waterSupplyFrequency, plantType, cost);
                    plantDAO.addPlant(newPlant);
                    System.out.println("Plant added with ID: " + newPlant.getPlantId());
                    break;

                case 2:
                    System.out.print("Enter plant ID to update cost: ");
                    int plantId = scanner.nextInt();
                    System.out.print("Enter new cost: ");
                    double newCost = scanner.nextDouble();
                    boolean updated = plantDAO.updatePlantCost(plantId, newCost);
                    if (updated) {
                        System.out.println("Plant cost updated successfully.");
                    } else {
                        System.out.println("Plant with ID " + plantId + " not found.");
                        try {
							throw new PlantNotFoundException("There are no plants");
						} catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                    break;

                case 3:
                    System.out.print("Enter plant ID to delete: ");
                    int deletePlantId = scanner.nextInt();
                    int deletedId = plantDAO.deletePlant(deletePlantId);
                    if (deletedId != -1) {
                        System.out.println("Plant with ID " + deletedId + " deleted.");
                    } else {
                        System.out.println("Plant with ID " + deletePlantId + " not found.");
                        try {
							throw new PlantNotFoundException("There are no plants");
						} catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                    break;

                case 4:
                    List<Plant> allPlants = plantDAO.showAllPlants();
                    if (allPlants.isEmpty()) {
                        //System.out.println("");
                        try {
							throw new PlantNotFoundException("There are no plants");
						} catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

                    } else {
                        System.out.println("All Plants:");
                        for (Plant plant : allPlants) {
                            System.out.println(plant.getPlantId() + ". " + plant.getPlantName());
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter origin country name to search for plants: ");
                    String searchCountryName = scanner.nextLine();
                    List<Plant> plantsByCountry = plantDAO.searchByOriginCountryName(searchCountryName);
                    if (plantsByCountry.isEmpty()) {
                        System.out.println("No plants found for origin country: " + searchCountryName);
                        try {
							throw new PlantNotFoundException("There are no plants");
						} catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    } else {
                        System.out.println("Plants from " + searchCountryName + ":");
                        for (Plant plant : plantsByCountry) {
                            System.out.println(plant.getPlantId() + ". " + plant.getPlantName());
                        }
                    }
                    break;

                case 6:
                    List<Plant> outdoorPlantsWithSunlight = plantDAO.searchOutdoorPlantsWithSunlight();
                    if (outdoorPlantsWithSunlight.isEmpty()) {
                        System.out.println("No outdoor plants require sunlight.");
                        try {
							throw new PlantNotFoundException("There are no plants");
						} catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    } else {
                        System.out.println("Outdoor Plants Requiring Sunlight:");
                        for (Plant plant : outdoorPlantsWithSunlight) {
                            System.out.println(plant.getPlantId() + ". " + plant.getPlantName());
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter water supply frequency (daily/weekly/alternate days): ");
                    String countFrequency = scanner.nextLine();
                    int plantCount = plantDAO.countPlantsByWaterSupplyFrequency(countFrequency);
                    System.out.println("Number of plants with " + countFrequency + " water supply frequency: " + plantCount);
                    break;

                case 8:
                    System.out.println("Exiting Plant Nursery System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

}
