/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.util.Date;

/**
 *
 * @author Thomas
 */
public class SmallShip extends Ship{
    
    public SmallShip(long shipId, int passengerCapacity, String name, Date lastMaintenance) {
        super(shipId, passengerCapacity, name, lastMaintenance);
    }

    @Override
    public String getShipDescription() {
        return "Walking passengers";
    }
    
}
