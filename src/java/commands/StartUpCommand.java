package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Thomas Kragsberger
 */
public class StartUpCommand extends TargetCommand {

    public StartUpCommand(String target) {
        super(target);
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        return super.execute(request);
    }
    
}
