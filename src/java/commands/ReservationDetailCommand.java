/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import contract.dto.reservation.ReservationDetail;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class ReservationDetailCommand extends TargetCommand{

    public ReservationDetailCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        int reservationId = Integer.parseInt(request.getParameter("id"));
        ReservationDetail reservation = Factory.getInstance().getDataRepository().getReservation(reservationId);
        request.setAttribute("reservation", reservation);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
