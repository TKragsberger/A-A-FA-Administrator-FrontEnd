package commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

/**
 *
 * @author Thomas Kragsberger
 */
public class ListReservationsCommand extends TargetCommand {

    public ListReservationsCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
//        String stringDate = request.getParameter("date");
//        Date date;
//        try {
//            date = new SimpleDateFormat("yyyy-mm-dd").parse(stringDate);
//        } catch (ParseException e) {
//            date = null;
//        }
//        request.setAttribute("reservations", Factory.getInstance().getDataRepository().getReservations(date));
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }

}
