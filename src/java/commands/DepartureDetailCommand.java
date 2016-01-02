package commands;

import contract.dto.departure.DepartureDetail;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author Thomas Kragsberger
 */
public class DepartureDetailCommand extends TargetCommand{

    public DepartureDetailCommand(String target) {
        super(target);
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        int departureId = Integer.parseInt(request.getParameter("id"));
        DepartureDetail departure = Factory.getInstance().getDataRepository().getDepartureDetail(departureId);
        System.out.println(departure.getReservations().size() + " this is the size of reservations");
        request.setAttribute("departure", departure);
        return super.execute(request);
    }
    
}
