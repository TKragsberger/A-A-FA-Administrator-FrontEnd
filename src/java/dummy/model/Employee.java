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
 * The employee detail tells about an employees position in the company and the 
 * salery he or she gets.
 */
public class Employee {
    private static final Map<String, Employee> items = new HashMap<>();
    
    public static Employee find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Employee> list(){
        return items.values();
    }
    
    private String firstName;
    private String lastName;
    private String email;
    private double salery;
    private long id;
    private String position;

    public Employee(String firstName, String lastName, String email, double salery, long id, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salery = salery;
        this.id = id;
        this.position = position;
        items.put(id+"", this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalery() {
        return salery;
    }

    public void setSalery(double salery) {
        this.salery = salery;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
