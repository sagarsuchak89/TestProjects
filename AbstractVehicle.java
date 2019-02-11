
import java.util.*;

public abstract class AbstractVehicle implements Vehicle{
    private String  regNum;
    private static Queue<Integer> rentedHours;

    public AbstractVehicle()
    {
        rentedHours = new PriorityQueue<>();
    }

    public String getRegNum() {
        return regNum;
    }


    public Queue<Integer> getRentedHours() {
        return rentedHours;
    }

    public void setRentedHours(Queue<Integer> rentedHours) {
        this.rentedHours = rentedHours;
    }

    // This methods check if the hours booked are present in the queue and issues the car if there is no conflict
    public boolean rentVehicleBetween(int startHour, int endHour)
    {
        this.cleanRentedHours();
        for(int i = startHour; i<= endHour; i++)
        {
            if(rentedHours.contains(i))
            {
                return false;
            }
        }

    // If the vehicle is not rented during the period, then add the rental hours to the queue
        for(int i = startHour; i<= endHour; i++)
        {
            rentedHours.add(i);
        }

       return true;
    }


    //This method cleans up past hours from the queue to clean up the un-required memory, since booking will never happen in past
    private void cleanRentedHours() {
        DateTimeUtils dateObj = new DateTimeUtils();
        int currentHour = dateObj.getCurrentHoursElapsed();

        while(rentedHours.size()>0 && rentedHours.peek()< currentHour)
        {
            rentedHours.poll();
        }

    }


}