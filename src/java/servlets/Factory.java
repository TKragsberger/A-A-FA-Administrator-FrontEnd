package servlets;

import commands.Command;
import commands.DepartureDetailCommand;
import commands.ListReservationsCommand;
import commands.ShipDetailCommand;
import commands.StartUpCommand;
import commands.TargetCommand;
import dummy.control.DummyDataRepository;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas Kragsberger
 */
public class Factory {

    private final static Factory instance = new Factory();
    private final Map<String, Command> commands = new HashMap();
    
    private final DummyDataRepository repository = new DummyDataRepository(); //replace repository when database connection is ready

    private Factory(){
        commands.put("start-up", new StartUpCommand("/welcome-page.jsp"));
        commands.put("main", new TargetCommand("/administrator/main-page.jsp"));
        commands.put("view-ship", new ShipDetailCommand("/administrator/ship-detail-page.jsp"));
        commands.put("view-depature", new DepartureDetailCommand("/administrator/departure-detail-page.jsp"));
        commands.put("view-reservations", new ListReservationsCommand("/administrator/reservation-summary-page.jsp"));
    }
    
    public DummyDataRepository getDataRepository() {
        return repository;
    }
    
    public static Factory getInstance(){
        return instance;
    }
    
    public Command getCommand(String commandString, HttpServletRequest request) {
        if (commandString == null) {
            commandString = "start-up";
            
        }
        System.out.println("the command is "+ commandString);
        Command cmd = commands.get(commandString);
        
        return cmd;
    }
}
