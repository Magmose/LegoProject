package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReturnPage extends Command {

    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        User user = (User) request.getSession().getAttribute("user");
        return user.getRole() + "page";
    }
}
