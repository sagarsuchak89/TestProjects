//package carhireapp;
/*
 * Implements the drive method for a small car
 * Super class is AbstractVehicle
 */
   public class SmallCar extends AbstractVehicle {
    private boolean isSmall = true;

    // Calls the super constructor, sets the fields appropriately
    public SmallCar() {
        super();
    }

    public boolean isSmall() {
        return isSmall;
    }

}

