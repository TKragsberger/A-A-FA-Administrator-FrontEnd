/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import contract.dto.EmployeeDetail;
import contract.dto.EmployeeSummary;
import contract.dto.PriceDetail;
import contract.dto.ReservationDetail;
import contract.dto.ReservationSummary;
import contract.dto.ScheduleDetail;
import contract.dto.ScheduleSummary;
import contract.dto.WeatherDetail;
import dummy.control.DummyDataRepository;
import static dummy.control.DummyDataRepository.parseDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Thomas
 */
public class DummyDataRepositoryTest {

    private DummyDataRepository ddr;
    private EmployeeDetail employee1;
    private EmployeeDetail employee2;
    private PriceDetail updatedPrice;
    
    public DummyDataRepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        ddr = new DummyDataRepository();
        Date date1 = parseDate("2014-02-14");
        Date date2 = parseDate("2014-02-23");
        //EmployeeDetail(String firstName, String lastName, String email, double salery, long id, String position)
        employee1 = new EmployeeDetail("Hans", "Hansen", "hans@hansen", 30000.00, 1, "administrator");
        employee2 = new EmployeeDetail("Peter", "Pedersen", "peter@pedersen", 20000.00, 2, "it support");
        //PriceDetail(String passengerType, int numberOfPassengers, double price)
        PriceDetail walkingPassenger = new PriceDetail(1, "walking", 1, 125.00);
        PriceDetail smallCar = new PriceDetail(2, "smallCar", 1, 250.00);
        updatedPrice = new PriceDetail(1, "walking", 1, 100);
        //ReservationDetail(long id, Date date, double price, String ticketType, String firstName, String lastName, String email, int routeId)
        ReservationDetail reservation1 = new ReservationDetail(1, date1, 375.00, "walking", "Hans", "Hansen", "hans@hansen", 1);
        ReservationDetail reservation2 = new ReservationDetail(2, date2, 750.00, "smallCar", "Peter", "Pedersen", "peter@pedersen", 2);
        ReservationDetail reservation3 = new ReservationDetail(3, date1, 750.00, "smallCar", "Niels", "Nielsen", "niels@nielsen", 1);
        //ScheduleDetail(int id, int routeId, int capacity, int passengers, int shipId, Date date)
        ScheduleDetail schedule1 = new ScheduleDetail(300, 1, 1000, 867, 1, date1);
        ScheduleDetail schedule2 = new ScheduleDetail(354, 2, 3000, 2547, 3, date2);
        //WeatherDetail(String weather, Date date)
        WeatherDetail weather1 = new WeatherDetail("sunny", date1);
        WeatherDetail weather2 = new WeatherDetail("raining", date2);
        ArrayList<EmployeeDetail> employees = new ArrayList();
        ArrayList<PriceDetail> prices = new ArrayList();
        ArrayList<ReservationDetail> reservations = new ArrayList();
        ArrayList<ScheduleDetail> schedules = new ArrayList();
        ArrayList<WeatherDetail> weatherSchedule = new ArrayList();

        employees.add(employee1);
        employees.add(employee2);
        prices.add(walkingPassenger);
        prices.add(smallCar);
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
        schedules.add(schedule1);
        schedules.add(schedule2);
        weatherSchedule.add(weather1);
        weatherSchedule.add(weather2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetEmployees() {
        Collection<EmployeeSummary> employees = new ArrayList<>();
        employees = ddr.getEmployees();
        Assert.assertEquals(2, employees.size());
    }
    
    @Test
    public void testGetEmployeeTrue(){
        EmployeeDetail employee = ddr.getEmployee(1);
        Assert.assertEquals("Hans", employee.getFirstName());
    }
    
    @Test
    public void testGetEmployeeFalse(){
        EmployeeDetail employee = ddr.getEmployee(2);
        Assert.assertNotSame("Hans", employee.getFirstName());
    }
    
    @Test
    public void testGetScheduleSummary(){
        Date date = parseDate("2014-02-14");
        Collection<ScheduleSummary> ss = ddr.getScheduleSummary(date);
        Assert.assertEquals(1, ss.size());
    }
    
    @Test
    public void testGetScheduleDetail(){
        Date date = parseDate("2014-02-23");
        ScheduleDetail sd = ddr.getScheduleDetail(date, 2);
        Assert.assertEquals(2, sd.getRouteId());
    }
    
    @Test
    public void testGetPrices(){
        Collection<PriceDetail> prices = new ArrayList<>();
        prices = ddr.getPrices();
        Assert.assertEquals(2, prices.size());
    }
    
    @Test
    public void testRemoveEmployee(){
        boolean employeeRemoved = ddr.removeEmployee(employee1);
        Assert.assertTrue(employeeRemoved);
    }
    
    @Test
    public void testUpdatePrice(){
        boolean priceUpdated = ddr.updatePrice(updatedPrice);
        Assert.assertTrue(priceUpdated);
    }
    
    @Test
    public void testAddEmployee(){
        EmployeeDetail employee = new EmployeeDetail("Niels", "Nielsen", "niels@nielsen.com", 22000.00, 3, "it support");
        boolean employeeAdded = ddr.createEmployee(employee);
        Assert.assertTrue(employeeAdded);
    }
    
    @Test
    public void testGetReservations(){
        Date date = parseDate("2014-02-14");
        Collection<ReservationSummary> rs = new ArrayList<>();
        rs = ddr.getReservations(date);
        Assert.assertEquals(2, rs.size());
    }
    
    @Test
    public void testGetReservation(){
        ReservationDetail rd = ddr.getReservation(2);
        Assert.assertEquals("Peter", rd.getFirstName());
    }
    
    @Test
    public void testGetWeather(){
        Date date = parseDate("2014-02-14");
        WeatherDetail wd = ddr.getWeatherDetail(date);
        Assert.assertEquals("sunny", wd.getWeather());
    }
    
    @Test
    public void testUpdateEmployee(){
        EmployeeDetail employee = new EmployeeDetail("Hans", "Hansen", "hans@hansen", 32000.00, 1, "administrator");
        boolean employeeUpdated = ddr.updateEmployee(employee);
        Assert.assertTrue(employeeUpdated);
    }
    
//    @Test
//    public void testUpdateShipDeck(){
//        Date date = parseDate("2014-02-23");
//        boolean shipDeckChanged = ddr.updateShipDeck(date, "upper");
//        Assert.assertTrue(shipDeckChanged);
//    }
}
