/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.asembler;

import contract.dto.EmployeeDetail;
import contract.dto.EmployeeSummary;
import contract.dto.LargeShipDetail;
import contract.dto.LargeShipSummary;
import contract.dto.MediumShipDetail;
import contract.dto.MediumShipSummary;
import contract.dto.PriceDetail;
import contract.dto.ReservationDetail;
import contract.dto.ReservationSummary;
import contract.dto.ScheduleDetail;
import contract.dto.ScheduleSummary;
import contract.dto.ShipDetail;
import contract.dto.ShipSummary;
import contract.dto.SmallShipDetail;
import contract.dto.SmallShipSummary;
import contract.dto.WeatherDetail;
import dummy.model.Employee;
import dummy.model.LargeShip;
import dummy.model.MediumShip;
import dummy.model.Price;
import dummy.model.Reservation;
import dummy.model.Schedule;
import dummy.model.Ship;
import dummy.model.SmallShip;
import dummy.model.Weather;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class DummyAsembler {
    
    public static EmployeeSummary createEmployeeSummary(Employee employee){
        return new EmployeeSummary(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPosition());
    }
    
    public static Collection<EmployeeSummary> createEmployeeSummaries(Collection<Employee> employees){
        Collection<EmployeeSummary> summaries = new ArrayList<>();
        for(Employee employee : employees){
            summaries.add(createEmployeeSummary(employee));
        }
        return summaries;
    } 
    
    public static EmployeeDetail createEmployeeDetail(Employee employee){
        return new EmployeeDetail(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getSalery(), employee.getId(), employee.getPosition());
    } 
    
    public static ScheduleSummary createScheduleSummary (Schedule schedule){
        return new ScheduleSummary(schedule.getRouteId(), schedule.getCapacity(), schedule.getPassengers(), schedule.getShipId());
    }
    
    public static Collection<ScheduleSummary> cretaScheduleSummaries(Collection<Schedule> schedules){
        Collection<ScheduleSummary> ss = new ArrayList<>();
        for(Schedule schedule : schedules){
            ss.add(createScheduleSummary(schedule));
        }
        return ss;
    }
    
    public static ScheduleDetail createScheduleDetail(Schedule schedule){
        return new ScheduleDetail(schedule.getId(), schedule.getRouteId(), schedule.getCapacity(), schedule.getPassengers(), schedule.getShipId(), schedule.getDate());
    }
    
    public static Collection<PriceDetail> createPriceDetail(Collection<Price> prices){
        Collection<PriceDetail> priceArray = new ArrayList<>();
        for(Price price : prices){
            priceArray.add(new PriceDetail(price.getId(), price.getPassengerType(), price.getNumberOfPassengers(), price.getPrice()));
        }
        return priceArray;
    }
    
    public static ReservationSummary createReservationSummary(Reservation reservation){
        return new ReservationSummary(reservation.getDate(), reservation.getTicketType(), reservation.getFirstName(), reservation.getLastName(), reservation.getEmail(), reservation.getRouteId());
    }
    
    public static Collection<ReservationSummary> createReservationSummaries(Collection<Reservation> reservations){
        Collection<ReservationSummary> rs = new ArrayList<>();
        for(Reservation reservation : reservations){
            rs.add(createReservationSummary(reservation));
        }
        return rs;
    }
    
    public static ReservationDetail createReservationDetail(Reservation reservation){
        return new ReservationDetail(reservation.getId(), reservation.getDate(), reservation.getPrice(), reservation.getTicketType(), reservation.getFirstName(), reservation.getLastName(), reservation.getEmail(), reservation.getRouteId());
    }
    
    public static WeatherDetail createWeatherDetail(Weather weather){
        return new WeatherDetail(weather.getWeather(), weather.getDate());
    }
    
    public static ShipDetail createShipDetail(Ship ship){
        ShipDetail sd = null;
        if(ship instanceof SmallShip){
            sd = new SmallShipDetail(ship.getShipId(), ship.getPassengerCapacity(), ship.getName(), ship.getLastMaintenance());
        } else if(ship instanceof MediumShip){
            MediumShip ms = (MediumShip) ship;
            sd = new MediumShipDetail(ship.getShipId(), ship.getPassengerCapacity(), ship.getName(), ship.getLastMaintenance(), ms.getCarCapacity());
        } else if(ship instanceof LargeShip){
            LargeShip ls = (LargeShip) ship;
            sd = new LargeShipDetail(ship.getShipId(), ship.getPassengerCapacity(), ship.getName(), ship.getLastMaintenance(), ls.getCurrentDeckPosition(), ls.getCarCapacity(), ls.getLargeVehicleCapacity());
        }
        return sd;
    }
    
    public static ShipSummary createShipSummary(Ship ship){
        ShipSummary sd = null;
        if(ship instanceof SmallShip){
            sd = new SmallShipSummary(ship.getShipId(), ship.getName());
        } else if(ship instanceof MediumShip){
            MediumShip ms = (MediumShip) ship;
            sd = new MediumShipSummary(ship.getShipId(), ship.getName());
        } else if(ship instanceof LargeShip){
            LargeShip ls = (LargeShip) ship;
            sd = new LargeShipSummary(ship.getShipId(), ship.getName());
        }
        return sd;
    }
    
    public static Collection<ShipSummary> createShipSummaries(Collection<Ship> ships){
        Collection<ShipSummary> sd = new ArrayList<>();
        for(Ship ship : ships){
            sd.add(createShipSummary(ship));
        }
        return sd;
    }
}
