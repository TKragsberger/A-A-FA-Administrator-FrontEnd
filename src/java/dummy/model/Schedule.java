/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * The schedule Detail will contain information about a certain ship on a certain route.
 * The capacity will tell the administrtor how many people there are on board and if a bigger ship is needed.
 * Passengers tells the amount of passengers there are onboard.
 */
public class Schedule {
    private static final Map<String, Schedule> items = new HashMap<>();
    
    public static Schedule find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Schedule> list(){
        return items.values();
    }
    private int id;
    private int routeId;
    private int capacity;
    private int passengers;
    private int shipId;
    private Date date;

    public Schedule(int id, int routeId, int capacity, int passengers, int shipId, Date date) {
        this.id = id;
        this.routeId = routeId;
        this.capacity = capacity;
        this.passengers = passengers;
        this.shipId = shipId;
        this.date = date;
        items.put(id+"", this);
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
