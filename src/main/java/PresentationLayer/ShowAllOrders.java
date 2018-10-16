package PresentationLayer;

import FunctionLayer.HouseCalculater;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        User user = (User) request.getSession().getAttribute("user");
        if ("employee".equals(user.getRole())) {
            ArrayList<Order> orders = HouseCalculater.getOrdersFromAllUser(user);
            request.setAttribute("orders", orders);
        } else {
            ArrayList<Order> orders = HouseCalculater.getOrdersFromUser(user);
            request.setAttribute("orders", orders);
        }
        return "showallorders";
    }

}
