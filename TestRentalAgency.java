import  org.junit.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class TestRentalAgency {

    static RentalAgency agency;
    static DrivingLicence licenceA;
    static DrivingLicence licenceB;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        try {
            agency = new RentalAgency(2, 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy");
            licenceA = new DrivingLicence("Sagar", 101, simpleDateFormat.parse("07/22/1989"), simpleDateFormat.parse("01/01/2018"));
            licenceB = new DrivingLicence("James", 101, simpleDateFormat.parse("08/22/1989"), simpleDateFormat.parse("04/02/2018"));
        }catch (ParseException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testIssueCar() {
        assertTrue(agency.issueCar(licenceA, true,"02/23/2019 02:09:00", "03/23/2019 12:00:00"  ));
        assertTrue(agency.issueCar(licenceA, true,"02/026/2019 02:09:00", "03/29/2019 12:00:00"  ));
        assertTrue(agency.issueCar(licenceB, false,"02/23/2019 02:09:00", "03/23/2019 12:00:00"  ));
        assertTrue(agency.issueCar(licenceB, true,"02/026/2019 02:09:00", "03/29/2019 12:00:00"  ));

    }

    @Test
    public void testFleetCount() {
        agency.issueCar(licenceA, true,"02/23/2019 02:09:00", "03/23/2019 12:00:00"  );
        agency.issueCar(licenceA, true,"02/026/2019 02:09:00", "03/29/2019 12:00:00"  );
       agency.issueCar(licenceB, false,"02/23/2019 02:09:00", "03/23/2019 12:00:00"  );
      agency.issueCar(licenceB, true,"02/026/2019 02:09:00", "03/29/2019 12:00:00"  );

      assertEquals(3, agency.getListOfCars().size());
        assertEquals(3, agency.getFleet().size());

    }


}
