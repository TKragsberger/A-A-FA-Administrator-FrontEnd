/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.asembler;

import contract.dto.department.DepartmentDetail;
import contract.dto.department.DepartmentSummary;
import contract.dto.departure.DepartureDetail;
import contract.dto.departure.DepartureSummary;
import contract.dto.employee.EmployeeDetail;
import contract.dto.employee.EmployeeSummary;
import contract.dto.ship.LargeShipDetail;
import contract.dto.ship.LargeShipSummary;
import contract.dto.ship.MediumShipDetail;
import contract.dto.ship.MediumShipSummary;
import contract.dto.price.PriceDetail;
import contract.dto.reservation.ReservationDetail;
import contract.dto.reservation.ReservationSummary;
import contract.dto.route.RouteDetail;
import contract.dto.route.RouteSummary;
import contract.dto.schedule.ScheduleDetail;
import contract.dto.schedule.ScheduleSummary;
import contract.dto.ship.ShipDetail;
import contract.dto.ship.ShipSummary;
import contract.dto.ship.SmallShipDetail;
import contract.dto.ship.SmallShipSummary;
import contract.dto.weather.WeatherDetail;
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
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class DummyAsembler {
    
    public static EmployeeSummary createEmployeeSummary(Employee employee){
        return new EmployeeSummary(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPosition());
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
        return new ScheduleSummary(schedule.getId(), schedule.getRouteId(), schedule.getCapacity(), schedule.getPassengers(), schedule.getShipId());
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
        return new ReservationSummary(reservation.getId(), reservation.getDate(), reservation.getTicketType(), reservation.getFirstName(), reservation.getLastName(), reservation.getEmail(), reservation.getRouteId());
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
        return new WeatherDetail(weather.getDate(), weather.getWeather());
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
    
    public static DepartmentDetail createDepartmentDetail(Department department){
        return new DepartmentDetail(department.getId(), department.getName(), department.getDescription());
    }
    
    public static DepartmentSummary createDepartmentSummary(Department deparment){
        return new DepartmentSummary(deparment.getId(), deparment.getDescription());
    }
    
    public static Collection<DepartmentSummary> createDepartmentSummaries(Collection<Department> departments){
        Collection<DepartmentSummary> ds = new ArrayList<>();
        for(Department department : departments){
            ds.add(createDepartmentSummary(department));
        }
        return ds;
    }
    
    public static RouteDetail createRouteDetail(Route route){
        return new RouteDetail(route.getId(), route.getStartDestination(), route.getEndDesitination(), route.getPrice(), route.getTravelTime());
    }
    
    public static RouteSummary createRouteSummary(Route route){
        return new RouteSummary(route.getStartDestination()+" to "+route.getEndDesitination(), route.getId());
    }
    
    public static Collection<RouteSummary> createRouteSummaries(Collection<Route> routes){
        Collection<RouteSummary> rs = new ArrayList<>();
        for(Route route : routes){
            rs.add(createRouteSummary(route));
        }
        return rs;
    }
    
    public static DepartureSummary createDepartureSummary(Departure departure){
        return new DepartureSummary(departure.getId(), departure.getDate(), departure.getRouteId());
    }
    
    public static Collection<DepartureSummary> createDepartureSummaries(Collection<Departure> departures){
        Collection<DepartureSummary> ds = new ArrayList<>();
        for(Departure departure : departures){
            ds.add(createDepartureSummary(departure));
        }
        return ds;
    }
    
    public static DepartureDetail createDepartureDetail(Departure departure){
        Collection<ReservationSummary> rs = createReservationSummaries(departure.getReservations());
        DepartureDetail d = new DepartureDetail(departure.getId(), departure.getDate(), departure.getRouteId());
        d.addPassengers(departure.getCurrentPassengers());
        d.addVehicles(departure.getCurrentVehicles());
        d.addLargeVehicles(departure.getCurrentLargeVehicles());
        for(ReservationSummary r : rs){
            d.addReservation(r);
        }
        return d;
    }
}
