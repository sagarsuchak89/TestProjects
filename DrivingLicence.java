//package carhireapp;

import java.util.Date;

/*
 * Relies on the Name and LicenceNumber classes
 * A simple class to store information about a driving licence
 */
public final class DrivingLicence {
    private final String driverName;
    private final Date driverDateOfBirth;
    private final Date dateOfIssue;
    private final int number;

    public DrivingLicence(String driverName, int number, Date dateOfBirth, Date dateOfIssue) {
        this.driverName = driverName;
        this.driverDateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
        this.number = number;
    }

    public String getDriverName() {
        return driverName;
    }

    public Date getDriverDateOfBirth() {
        return driverDateOfBirth;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public String toString() {
        return "\nDrivingLicence \ndriverName= " + driverName.toString() + "\ndriverDateOfBirth= " + driverDateOfBirth
                + "\ndateOfIssue= " + dateOfIssue + "\nnumber= " + number + "]";
    }

}