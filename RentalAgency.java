//package carhireapp;

import java.util.*;

/*
 * Main rental agency class
 * Contains the companies fleet of cars that they rent, as well as methods to get the current reservations
 */
public class RentalAgency {
    private static List<Vehicle> ListOfCars = new ArrayList<>();
    private static Map<Vehicle, Booking> FLEET = new HashMap<Vehicle, Booking>();
   // private static final String startWorldDate = "01/01/2019 00:00:00";
     DateTimeUtils dateUtil = new DateTimeUtils();

    // When RentalAgency is created, populate the ListOfCars
    public RentalAgency(int netSmall, int netLarge) {
        populateList(netSmall, netLarge);
    }

    // A method to populate the map of vehicles with 20 small cars and 10 large
    // cars
    private void populateList(int netSmall, int netLarge) {
        for (int i = 0; i < netSmall; i++) {
            ListOfCars.add(new SmallCar());
        }

        for (int i = 0; i < netLarge; i++) {
            ListOfCars.add(new LargeCar());
        }
    }

    // Returns the entire List listOfCars
    public List<Vehicle> getListOfCars() {
        return ListOfCars;
    }

    // Returns the entire map FLEET
    public Map<Vehicle, Booking> getFleet() {
        return FLEET;
    }



    // Returns the Booking
    public Booking getCar(Vehicle vehicle) {
        if (FLEET.containsKey(vehicle)) {
            return FLEET.get(vehicle);
        } else
            return null;
    }


    //This method goes over the list of vehicles and reserves a vehicle if there is no conflict schedule
    // Logic: If hours elapsed since 1st Jan 2019, are currently booked for the temp car, it goes to the next one in list.
    public boolean issueCar(DrivingLicence licence, Boolean isSmall, String startDate, String endDate) {

        int startHour = dateUtil.getHoursElapsed(startDate);
        int endHour = dateUtil.getHoursElapsed(endDate);
        boolean flag = false;
        // A simple flag to toggle depending on if we find an appropriate car to

            for (Vehicle temp : ListOfCars) {
                // iterates through the list of Vehicles
                if (temp.isSmall() == isSmall && temp.rentVehicleBetween(startHour, endHour)) {
                    // checks if the user entered true or false for isSmall and
                    Booking booking = new Booking(licence, temp, startDate, endDate);
                    FLEET.put(temp, booking);
                    flag = true;


                }


            }

            if(flag)
            {
                System.out.println("A vehicle has been issued successfully");
            }
            else{
                System.out.println("No vehicle is available for this schedule..");
            }
        return flag;

    }



}