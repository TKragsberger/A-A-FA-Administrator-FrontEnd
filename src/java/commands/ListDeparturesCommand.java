/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import contract.dto.departure.DepartureSummary;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class ListDeparturesCommand extends TargetCommand{

    public ListDeparturesCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<DepartureSummary> departures = Factory.getInstance().getDataRepository().getDepartureSummaiers();
        request.setAttribute("departures", departures);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
