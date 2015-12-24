/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas
 */
public class Route {
    private static final Map<String, Route> items = new HashMap<>();
    
    public static Route find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Route> list(){
        return items.values();
    }
    
    private long id;
    private String startDestination;
    private String endDesitination;
    private double price;
    private int travelTime;

    public Route(long id, String startDestination, String endDesitination, double price, int travelTime) {
        this.id = id;
        this.startDestination = startDestination;
        this.endDesitination = endDesitination;
        this.price = price;
        this.travelTime = travelTime;
        items.put(id+"", this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public String getEndDesitination() {
        return endDesitination;
    }

    public void setEndDesitination(String endDesitination) {
        this.endDesitination = endDesitination;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
}
