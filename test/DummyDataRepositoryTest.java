/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import contract.dto.department.DepartmentDetail;
import contract.dto.department.DepartmentSummary;
import contract.dto.employee.EmployeeDetail;
import contract.dto.employee.EmployeeSummary;
import contract.dto.price.PriceDetail;
import contract.dto.reservation.ReservationDetail;
import contract.dto.reservation.ReservationSummary;
import contract.dto.route.RouteDetail;
import contract.dto.route.RouteSummary;
import contract.dto.schedule.ScheduleDetail;
import contract.dto.schedule.ScheduleSummary;
import contract.dto.ship.ShipDetail;
import contract.dto.ship.ShipSummary;
import contract.dto.weather.WeatherDetail;
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
        updatedPrice = new PriceDetail(1, "walking", 1, 100);
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
        EmployeeDetail employee = new EmployeeDetail("Niels", "Nielsen", "niels@nielsen.com", 22000.00, 3, "it support");
        ddr.createEmployee(employee);
        boolean employeeRemoved = ddr.removeEmployee(employee);
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
        ddr.removeEmployee(employee);
    }
    
    @Test
    public void testGetReservationSummary(){
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
    
    @Test
    public void testGetShipDetail(){
        ShipDetail sd = ddr.getShipDetail(2);
        Assert.assertEquals("SS Charlotte", sd.getName());
    }
    
    @Test
    public void testGetShipSummary(){
        Collection<ShipSummary> ss = ddr.getShips();
        Assert.assertEquals(3, ss.size());
    }
    
    @Test
    public void testGetDepartmentDetail(){
        DepartmentDetail dd = ddr.getDepartmentDetail(2);
        Assert.assertEquals("ADM", dd.getName());
    }
    
    @Test
    public void testGetDepartmentSummaries(){
        Collection<DepartmentSummary> ds = ddr.getDepartmentSummaries();
        Assert.assertEquals(3, ds.size());
    }
    
    @Test
    public void testGetRouteDetail(){
        RouteDetail rd = ddr.getRouteDetail(1);
        Assert.assertEquals(1, rd.getId());
    }
    
    @Test
    public void testGetRouteSummaries(){
        Collection<RouteSummary> rs = ddr.getRouteSummaries();
        Assert.assertEquals(2, rs.size());
    }
}
