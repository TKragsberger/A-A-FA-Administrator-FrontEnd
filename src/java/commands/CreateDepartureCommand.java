/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import contract.dto.departure.DepartureDetail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class CreateDepartureCommand extends TargetCommand{

    public CreateDepartureCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        String stringDate = request.getParameter("date");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-mm-dd").parse(stringDate);
        } catch (ParseException e) {
            date = null;
        }
        long routeId = Long.parseLong(request.getParameter("routeId"));
        Factory.getInstance().getDataRepository().createDeparture(new DepartureDetail(id, date, routeId));
        request.setAttribute("id", id);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
