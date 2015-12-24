package commands;

import javax.servlet.http.HttpServletRequest;

public class TargetCommand implements Command {
    private final String target;

    public TargetCommand(String target) {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("target", target);
        return target;
    }
}
