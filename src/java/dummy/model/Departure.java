package dummy.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas Kragsberger
 */
public class Departure {
    private static final Map<String, Departure> items = new HashMap<>();
    
    public static Departure find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Departure> list(){
        return items.values();
    }
    
    private long id;
    private Date date;
    private long routeId;
    private Collection<Reservation> reservations;
    private int currentPassengers;
    private int currentVehicles;
    private int currentLargeVehicles;

    public Departure(long id, Date date, long routeId, int currentPassengers, int currentVehicles, int currentLargeVehicles) {
        this.id = id;
        this.date = date;
        this.routeId = routeId;
        this.reservations = new ArrayList<>();
        this.currentPassengers = currentPassengers;
        this.currentVehicles = currentVehicles;
        this.currentLargeVehicles = currentLargeVehicles;
        items.put(id+"", this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public void setCurrentPassengers(int currentPassengers) {
        this.currentPassengers = currentPassengers;
    }

    public int getCurrentVehicles() {
        return currentVehicles;
    }

    public void setCurrentVehicles(int currentVehicles) {
        this.currentVehicles = currentVehicles;
    }
    
    public int getCurrentLargeVehicles(){
        return currentLargeVehicles;
    }
    
    public void setCurrentLargeVehicles(int currentLargeVehicles){
        this.currentLargeVehicles = currentLargeVehicles;
    }
    
    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
}
