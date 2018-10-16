/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FunctionLayer.HouseCalculater;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.HashMap;

public class HouseOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int houseWidth = (int) Integer.parseInt(request.getParameter("width"));
        int houseLength = (int) Integer.parseInt(request.getParameter("length"));
        int houseHeight = (int) Integer.parseInt(request.getParameter("height"));
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "index";
        }

        if (houseWidth >= 5 && houseLength >= 5 && houseHeight >= 1) {
            HashMap<String, Integer> hmap = HouseCalculater.calculatingBricks(houseLength, houseWidth, houseHeight);
            Order order = HouseCalculater.addOrder(user, houseLength, houseWidth, houseHeight);
            request.setAttribute("hmap", hmap);
            request.setAttribute("order", order);

            //Send to finish buy site if not erro
            return "showorder";
        } else {
            throw new LoginSampleException("Your house can minimum be 5x5x1");
        }
    }
}
