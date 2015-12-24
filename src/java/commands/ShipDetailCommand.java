package commands;

import contract.dto.ship.ShipDetail;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author Thomas Kragsberger
 */
public class ShipDetailCommand extends TargetCommand{

    public ShipDetailCommand(String target) {
        super(target);
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        int shipId = Integer.parseInt(request.getParameter("id"));
        ShipDetail ship = Factory.getInstance().getDataRepository().getShipDetail(shipId);
        request.setAttribute("ship", ship);
        return super.execute(request);
    }
    
}
