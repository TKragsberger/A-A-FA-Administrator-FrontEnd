/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.control;

import contract.DataRepository;
import contract.dto.department.DepartmentDetail;
import contract.dto.department.DepartmentSummary;
import contract.dto.departure.DepartureDetail;
import contract.dto.departure.DepartureSummary;
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
import dummy.asembler.DummyAsembler;
import dummy.model.Department;
import dummy.model.Departure;
import dummy.model.Employee;
import dummy.model.LargeShip;
import dummy.model.MediumShip;
import dummy.model.Price;
import dummy.model.Reservation;
import dummy.model.Route;
import dummy.model.Schedule;
import dummy.model.Ship;
import dummy.model.SmallShip;
import dummy.model.Weather;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Thomas
 */
public class DummyDataRepository implements DataRepository {
    
    private DummyAsembler asembler = new DummyAsembler();

    public DummyDataRepository() {
        Date date1 = parseDate("2014-02-14");
        Date date2 = parseDate("2014-02-23");
        Date date3 = parseDate("2015-03-15");
        //EmployeeDetail(String firstName, String lastName, String email, double salery, long id, String position)
        new Employee("Hans", "Hansen", "hans@hansen", 30000.00, 1, "administrator");
        new Employee("Peter", "Pedersen", "peter@pedersen", 20000.00, 2, "it support");
        //PriceDetail(String passengerType, int numberOfPassengers, double price)
        new Price(1, "walking", 1, 125.00);
        new Price(2, "smallCar", 1, 250.00);
        //ReservationDetail(long id, Date date, double price, String ticketType, String firstName, String lastName, String email, int routeId)
        Reservation reservation1 = new Reservation(1, date1, 375.00, "walking", "Hans", "Hansen", "hans@hansen", 1);
        Reservation reservation2 = new Reservation(2, date2, 750.00, "smallCar", "Peter", "Pedersen", "peter@pedersen", 2);
        Reservation reservation3 = new Reservation(3, date1, 750.00, "smallCar", "Niels", "Nielsen", "niels@nielsen", 1);
        //ScheduleDetail(int id, int routeId, int capacity, int passengers, int shipId)
        new Schedule(300, 1, 1000, 867, 1, date1);
        new Schedule(354, 2, 3000, 2547, 3, date2);
        //WeatherDetail(String weather, Date date)
        new Weather("sunny", date1);
        new Weather("raining", date2);
        //SmallShip(long shipId, int passengerCapacity, String name, Date lastMaintenance)
        new SmallShip(1, 1000, "SS Martha", date3);
        //MediumShip(long shipId, int passengerCapacity, String name, Date lastMaintenance, int carCapacity)
        new MediumShip(2, 1500, "SS Charlotte", date3, 150);
        //LargeShip(long shipId, int passengerCapacity, String name, Date lastMaintenace, String currentDeckPosition, int carCapacity, int largeVehicleCapacity)
        new LargeShip(3, 2500, "SS Karoline", date3, "Upper", 200, 50);
        //Department(long id, String name, String description)
        new Department(1, "HR", "This is the HR Department");
        new Department(2, "ADM", "This is the Administation Department");
        new Department(3, "IT", "This is the IT department");
        //Route(long id, String startDestination, String endDesitination, int travelTime)
        new Route(1, "a", "b", 50.00, 40);
        new Route(2, "a", "c", 75.00, 20);
        
        //Departure(long id, Date date, long routeId, Collection<Reservation> reservations, int currentPassengers, int currentVehicles)
        Departure departure1 = new Departure(1, date1, 1, 100, 15, 0);
        Departure departure2 = new Departure(2, date2, 2, 98, 17, 0);
        departure1.addReservation(reservation1);
        departure1.addReservation(reservation3);
        departure2.addReservation(reservation2);
        
    }

    public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-mm-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
    
    @Override
    public Collection<EmployeeSummary> getEmployees() {
        
        return asembler.createEmployeeSummaries(Employee.list());
    }

    @Override
    public EmployeeDetail getEmployee(long id) {
        return asembler.createEmployeeDetail(Employee.find(id));
    }

    @Override
    public Collection<ScheduleSummary> getScheduleSummary(Date date) {
        Collection<Schedule> scheduleArray = new ArrayList<>();
        for(Schedule schedule : Schedule.list()){
            if(schedule.getDate().equals(date))
                //ScheduleSummary(int routeId, int capacity, int passengers, int shipId)
                scheduleArray.add(schedule);
        }
        if(scheduleArray.size() > 0){
            return asembler.cretaScheduleSummaries(scheduleArray);
        }
        return null;
    }

    @Override
    public ScheduleDetail getScheduleDetail(Date date, long routeId) {
        for(Schedule schedule : Schedule.list()){
            if(schedule.getDate().equals(date) && schedule.getRouteId() == routeId)
                return asembler.createScheduleDetail(schedule);
        }
        return null;
    }

    @Override
    public Collection<PriceDetail> getPrices() {
        return asembler.createPriceDetail(Price.list());
    }

    @Override
    public boolean removeEmployee(EmployeeDetail employee) {
        for(Employee emp : Employee.list()){
            if(emp.getId() == employee.getId()){
                Employee.list().remove(emp);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePrice(PriceDetail updatedPrice) {
        for(Price oldPriceDetail : Price.list()){
            if(oldPriceDetail.getId() == updatedPrice.getId()){
                oldPriceDetail.setNumberOfPassengers(updatedPrice.getNumberOfPassengers());
                oldPriceDetail.setPassengerType(updatedPrice.getPassengerType());
                oldPriceDetail.setPrice(updatedPrice.getPrice());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createEmployee(EmployeeDetail newEmployee) {
        if(!newEmployee.toString().isEmpty()){
            new Employee(newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail(), newEmployee.getSalery(), newEmployee.getId(), newEmployee.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public Collection<ReservationSummary> getReservations(Date date) {
        Collection<Reservation> rs = new ArrayList<>();
        for(Reservation reservation : Reservation.list()){
            if(reservation.getDate().equals(date))
                //ReservationSummary(Date date, String ticketType, String firstName, String lastName, String email, int routeId)
                rs.add(reservation);
        }
        return asembler.createReservationSummaries(rs);
    }

    @Override
    public ReservationDetail getReservation(long id) {
        return asembler.createReservationDetail(Reservation.find(id));
    }

    @Override
    public WeatherDetail getWeatherDetail(Date date) {
        for(Weather weather : Weather.list()){
            if(weather.getDate().equals(date))
                return asembler.createWeatherDetail(weather);
        }
        return null;
    }

    @Override
    public boolean updateEmployee(EmployeeDetail updatedEmployee) {
        for(Employee OldEmployee : Employee.list()){
            if(OldEmployee.getId() == updatedEmployee.getId()){
                OldEmployee.setFirstName(updatedEmployee.getFirstName());
                OldEmployee.setLastName(updatedEmployee.getLastName());
                OldEmployee.setEmail(updatedEmployee.getEmail());
                OldEmployee.setPosition(updatedEmployee.getPosition());
                OldEmployee.setSalery(updatedEmployee.getSalery());
                return true;
            }
        }
        return false;
    }

    @Override
    public ShipDetail getShipDetail(long id) {
        return asembler.createShipDetail(Ship.find(id));
    }

    @Override
    public Collection<ShipSummary> getShips() {
        return asembler.createShipSummaries(Ship.list());
    }

    @Override
    public DepartmentDetail getDepartmentDetail(long id) {
        return asembler.createDepartmentDetail(Department.find(id));
    }

    @Override
    public Collection<DepartmentSummary> getDepartmentSummaries() {
        return asembler.createDepartmentSummaries(Department.list());
    }

    @Override
    public RouteDetail getRouteDetail(long id) {
        return asembler.createRouteDetail(Route.find(id));
    }

    @Override
    public Collection<RouteSummary> getRouteSummaries() {
        return asembler.createRouteSummaries(Route.list());
    }

    @Override
    public DepartureDetail getDepartureDetail(long id) {
        return asembler.createDepartureDetail(Departure.find(id));
    }

    @Override
    public Collection<DepartureSummary> getDepartureSummaiers() {
        return asembler.createDepartureSummaries(Departure.list());
    }

    @Override
    public void createDeparture(DepartureDetail departure) {
        new Departure(departure.getId(), departure.getDate(), departure.getRouteId(), departure.getCurrentPassengers(), departure.getCurrentVehicles(), departure.getCurrentLargeVehicles());
    }

}
