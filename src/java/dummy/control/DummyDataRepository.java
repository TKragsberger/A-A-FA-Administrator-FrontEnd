/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.control;

import contract.DataRepository;
import contract.dto.EmployeeDetail;
import contract.dto.EmployeeSummary;
import contract.dto.PriceDetail;
import contract.dto.ReservationDetail;
import contract.dto.ReservationSummary;
import contract.dto.ScheduleDetail;
import contract.dto.ScheduleSummary;
import contract.dto.ShipDetail;
import contract.dto.ShipSummary;
import contract.dto.WeatherDetail;
import dummy.asembler.DummyAsembler;
import dummy.model.Employee;
import dummy.model.Price;
import dummy.model.Reservation;
import dummy.model.Schedule;
import dummy.model.Ship;
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
    
    private ArrayList<Employee> employees = new ArrayList();
    private ArrayList<Price> prices = new ArrayList();
    private ArrayList<Reservation> reservations = new ArrayList();
    private ArrayList<Schedule> schedules = new ArrayList();
    private ArrayList<Weather> weatherSchedule = new ArrayList();
    private ArrayList<Ship> ships = new ArrayList<>();
    private DummyAsembler asembler = new DummyAsembler();

    public DummyDataRepository() {
        Date date1 = parseDate("2014-02-14");
        Date date2 = parseDate("2014-02-23");
        //EmployeeDetail(String firstName, String lastName, String email, double salery, long id, String position)
        Employee employee1 = new Employee("Hans", "Hansen", "hans@hansen", 30000.00, 1, "administrator");
        Employee employee2 = new Employee("Peter", "Pedersen", "peter@pedersen", 20000.00, 2, "it support");
        //PriceDetail(String passengerType, int numberOfPassengers, double price)
        Price walkingPassenger = new Price(1, "walking", 1, 125.00);
        Price smallCar = new Price(2, "smallCar", 1, 250.00);
        //ReservationDetail(long id, Date date, double price, String ticketType, String firstName, String lastName, String email, int routeId)
        Reservation reservation1 = new Reservation(1, date1, 375.00, "walking", "Hans", "Hansen", "hans@hansen", 1);
        Reservation reservation2 = new Reservation(2, date2, 750.00, "smallCar", "Peter", "Pedersen", "peter@pedersen", 2);
        Reservation reservation3 = new Reservation(3, date1, 750.00, "smallCar", "Niels", "Nielsen", "niels@nielsen", 1);
        //ScheduleDetail(int id, int routeId, int capacity, int passengers, int shipId)
        Schedule schedule1 = new Schedule(300, 1, 1000, 867, 1, date1);
        Schedule schedule2 = new Schedule(354, 2, 3000, 2547, 3, date2);
        //WeatherDetail(String weather, Date date)
        Weather weather1 = new Weather("sunny", date1);
        Weather weather2 = new Weather("raining", date2);
        
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

    public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-mm-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
    
    @Override
    public Collection<EmployeeSummary> getEmployees() {
        
        return asembler.createEmployeeSummaries(employees);
    }

    @Override
    public EmployeeDetail getEmployee(int id) {
        for(Employee employee : employees){
            if(employee.getId() == id)
                return asembler.createEmployeeDetail(employee);
        }
        return null;
    }

    @Override
    public Collection<ScheduleSummary> getScheduleSummary(Date date) {
        Collection<Schedule> scheduleArray = new ArrayList<>();
        for(Schedule schedule : schedules){
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
    public ScheduleDetail getScheduleDetail(Date date, int routeId) {
        for(Schedule schedule : schedules){
            if(schedule.getDate().equals(date) && schedule.getRouteId() == routeId)
                return asembler.createScheduleDetail(schedule);
        }
        return null;
    }

    @Override
    public Collection<PriceDetail> getPrices() {
        return asembler.createPriceDetail(prices);
    }

    @Override
    public boolean removeEmployee(EmployeeDetail employee) {
        for(Employee emp : employees){
            if(emp.getId() == employee.getId()){
                employees.remove(emp);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePrice(PriceDetail updatedPrice) {
        for(Price oldPriceDetail : prices){
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
            employees.add(new Employee(newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail(), newEmployee.getSalery(), newEmployee.getId(), newEmployee.getPosition()));
            return true;
        }
        return false;
    }

    @Override
    public Collection<ReservationSummary> getReservations(Date date) {
        Collection<Reservation> rs = new ArrayList<>();
        for(Reservation reservation : reservations){
            if(reservation.getDate().equals(date))
                //ReservationSummary(Date date, String ticketType, String firstName, String lastName, String email, int routeId)
                rs.add(reservation);
        }
        return asembler.createReservationSummaries(rs);
    }

    @Override
    public ReservationDetail getReservation(int id) {
        for(Reservation reservation : reservations){
            if(reservation.getId() == id)
                return asembler.createReservationDetail(reservation);
        }
        return null;
    }

    @Override
    public WeatherDetail getWeatherDetail(Date date) {
        for(Weather weather : weatherSchedule){
            if(weather.getDate().equals(date))
                return asembler.createWeatherDetail(weather);
        }
        return null;
    }

    @Override
    public boolean updateEmployee(EmployeeDetail updatedEmployee) {
        for(Employee OldEmployee : employees){
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

//    @Override
//    public boolean updateShipDeck(Date date, String changeTo) {
//        for(Schedule schedule : schedules){
//            if(schedule.getDate().equals(date) && schedule.getShipId() == 3)
//                return true;
//        }
//        return false;
//    }

    @Override
    public ShipDetail getShipDetail(int id) {
        for(Ship ship : ships){
            if(ship.getShipId() == id)
                return asembler.createShipDetail(ship);
        }
        return null;
    }

    @Override
    public Collection<ShipSummary> getShips() {
        return asembler.createShipSummaries(ships);
    }

}
