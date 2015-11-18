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
 * The price detail will be used for creating a table of alle the prices. 
 * the passenger type will tell if the passenger is in a car, bus og is walking onboard,
 * how many passenger there are in a car
 */
public class Price {
    private static final Map<String, Price> items = new HashMap<>();
    
    public static Price find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Price> list(){
        return items.values();
    }
    private String passengerType;
    private int numberOfPassengers;
    private double price;
    private int id;

    public Price(int id, String passengerType, int numberOfPassengers, double price) {
        this.passengerType = passengerType;
        this.numberOfPassengers = numberOfPassengers;
        this.price = price;
        this.id = id;
        items.put(id+"", this);
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
}
