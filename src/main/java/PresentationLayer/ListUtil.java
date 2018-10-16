package PresentationLayer;

import FunctionLayer.Order;
import java.util.List;

public class ListUtil {

    public static String makeOrderList(List<Order> orders) {
        String html = "";
        System.out.println("ListUtilll------------------");
        for (Order order : orders) {
            html += "<form name=\"showorder\" action=\"FrontController\" method=\"POST\">";
            html += "    <input type=\"hidden\" name=\"command\" value=\"showorder\">";
            html += "    <input type=\"hidden\" name=\"houseid\" value=\"" + order.getHouse().getHouseId() + "\">";
            html += "    <input type=\"hidden\" name=\"houseid\" value=\"" + order.getIdOrder() + "\">";
            html += "    <input type=\"submit\" value=\"" + "Order id: " + order.getIdOrder() + "\"> <br>";
            html += "</form>";
        }
        return html;
    }

}
