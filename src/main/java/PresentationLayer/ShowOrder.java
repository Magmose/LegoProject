package PresentationLayer;

import FunctionLayer.House;
import FunctionLayer.HouseCalculater;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int houseId = (int) Integer.parseInt(request.getParameter("houseid"));
        Order order = HouseCalculater.getOrderWithOrderId(houseId);
        House house = HouseCalculater.getHouseWithHouseId(houseId);
        HashMap<String, Integer> hmap = HouseCalculater.calculatingBricks(house.getLength(), house.getWidth(), house.getHeight());
        request.setAttribute("hmap", hmap);
        request.setAttribute("order", order);
        return "showorder";
    }

}
