package FunctionLayer;

import DBAccess.UserMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HouseCalculater {

    public static HashMap<String, Integer> calculatingBricks(int length, int width, int height) throws LoginSampleException {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        hmap.put("4x2", 0);
        hmap.put("2x2", 0);
        hmap.put("1x2", 0);
        int oddNumbers = 0, evenNumbers = 0;

        for (int i = 0; i < height; i++) {
            if (i % 2 == 1) {
                oddNumbers++;
            } else if (i % 2 == 0) {
                evenNumbers++;
            }
        }
        if (oddNumbers != 0) {
            oddSideOfBricks(length, width, oddNumbers, hmap);
        }
        if (evenNumbers != 0) {
            evenSideOfBricks(length, width, evenNumbers, hmap);
        }

        for (HashMap.Entry<String, Integer> entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
        System.out.println("There are: " + evenNumbers + " even and " + oddNumbers + " odd!");
        System.out.println("lg " + length + " wd " + width + " ht " + height);
        return hmap;
    }

    public static HashMap<String, Integer> oddSideOfBricks(int length, int width, int oddNumbers, HashMap<String, Integer> hmap) {
        int side1 = length, side2 = width - 4, side3 = length, side4 = width - 4;
        int counter4x2 = 0, counter2x2 = 0, counter1x2 = 0, rest = 0;
        List<Integer> sidesOdd = new ArrayList<Integer>();
        sidesOdd.add(side1);
        sidesOdd.add(side2);
        sidesOdd.add(side3);
        sidesOdd.add(side4);

        for (int i = 0; i < sidesOdd.size(); i++) {
            counter4x2 = sidesOdd.get(i) / 4;
            rest = sidesOdd.get(i) % 4;
            counter2x2 = rest / 2;
            rest = sidesOdd.get(i) % 2;
            counter1x2 = rest;

            if (counter4x2 != 0) {
                hmap.put("4x2", hmap.get("4x2") + counter4x2 * oddNumbers);
            }
            if (counter2x2 != 0) {
                hmap.put("2x2", hmap.get("2x2") + counter2x2 * oddNumbers);
            }
            if (counter1x2 != 0) {
                hmap.put("1x2", hmap.get("1x2") + counter1x2 * oddNumbers);
            }
        }
        return hmap;
    }

    public static HashMap<String, Integer> evenSideOfBricks(int length, int width, int evenNumbers, HashMap<String, Integer> hmap) {
        int side1 = length - 4, side2 = width, side3 = length - 4, side4 = width;
        int counter4x2 = 0, counter2x2 = 0, counter1x2 = 0, rest = 0;
        List<Integer> sidesEven = new ArrayList<Integer>();
        sidesEven.add(side1);
        sidesEven.add(side2);
        sidesEven.add(side3);
        sidesEven.add(side4);

        for (int i = 0; i < sidesEven.size(); i++) {
            counter4x2 = sidesEven.get(i) / 4;
            rest = sidesEven.get(i) % 4;
            counter2x2 = rest / 2;
            rest = rest % 2;
            counter1x2 = rest;

            if (counter4x2 != 0) {
                hmap.put("4x2", hmap.get("4x2") + counter4x2 * evenNumbers);
            }
            if (counter2x2 != 0) {
                hmap.put("2x2", hmap.get("2x2") + counter2x2 * evenNumbers);
            }
            if (counter1x2 != 0) {
                hmap.put("1x2", hmap.get("1x2") + counter1x2 * evenNumbers);
            }
        }
        return hmap;
    }

    public static Order addOrder(User user, int length, int width, int height) throws LoginSampleException {
        Order order = UserMapper.addOrder(user, length, width, height);
        return order;
    }

    public static ArrayList<Order> getOrdersFromUser(User user) throws LoginSampleException {
        ArrayList<Order> orders = UserMapper.getOrdersFromUser(user);
        return orders;
    }

    public static House getHouseWithHouseId(int houseId) throws LoginSampleException {
        House house = UserMapper.getHouseWithHouseId(houseId);
        System.out.println("HouseId-------------");
        return house;
    }

    public static Order getOrderWithOrderId(int houseId) throws LoginSampleException {
        Order order = UserMapper.getOrderWithOrderId(houseId);
        System.out.println("orderId-------------");
        return order;
    }

    public static ArrayList<Order> getOrdersFromAllUser(User user) throws LoginSampleException {
        ArrayList<Order> ordersAll = UserMapper.getOrdersFromAllUser(user);
        System.out.println("allId-------------");
        return ordersAll;
    }

}
