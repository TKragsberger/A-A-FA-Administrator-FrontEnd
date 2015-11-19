/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas
 */
public class Department {
    private static final Map<String, Department> items = new HashMap<>();
    
    public static Department find(long id){
        return items.get(id+"");
    }
    
    public static Collection<Department> list(){
        return items.values();
    }
    
    private long id;
    private String name;
    private String description;
    private Collection<Employee> employees;
    
    public Department(long id, String name, String description) {
        this.id = id;
        this.name= name;
        this.description = description;
        employees = new ArrayList<>();
        items.put(id+"", this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
    
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
