package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.House;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO User (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM User "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Order addOrder(User user, int length, int width, int height) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL1 = "INSERT INTO House (Length, Width, Height, windowDoor) VALUES (?, ?, ?, ?)";
            PreparedStatement ps1 = con.prepareStatement(SQL1, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1, length);
            ps1.setInt(2, width);
            ps1.setInt(3, height);
            ps1.setBoolean(4, false);
            ps1.executeUpdate();
            ResultSet rs1 = ps1.getGeneratedKeys();
            rs1.next();
            int houseId = rs1.getInt(1);

            String SQL2 = "INSERT INTO `order` (User_Id, House_Id_fk) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL2, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setInt(2, houseId);
            ps.executeUpdate();
            ResultSet rs2 = ps.getGeneratedKeys();
            rs2.next();
            int orderId = rs2.getInt(1);

            House house = new House(length, width, height, houseId);
            Order order = new Order(user, orderId, house);
            return order;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrdersFromUser(User user) throws LoginSampleException {
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "select distinct `House`.*, `order`.`idOrder` from `User`join `order` join `House` on (`House`.`House_Id` = `order`.`House_Id_fk`)\n"
                    + "WHERE  `order`.`User_Id` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int houseId = rs.getInt("House_Id");
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                int height = rs.getInt("Height");
                int orderId = rs.getInt("idOrder");

                House house = new House(length, width, height, houseId);
                Order order = new Order(user, orderId, house);
                orders.add(order);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static House getHouseWithHouseId(int houseId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT `House`.* FROM `House` join `order` ON(`House`.`House_Id` = `order`.`House_Id_fk`) WHERE `order`.`House_Id_fk` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, Integer.toString(houseId));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                int height = rs.getInt("Height");
                House house = new House(length, width, height, houseId);
                return house;
            } else {
                throw new LoginSampleException("Could not validate house");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Order getOrderWithOrderId(int houseId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT `House`.*, `order`.`idOrder`, `User`.* FROM `House` join `order` join `User` ON(`House`.`House_Id` = `order`.`House_Id_fk`) WHERE `order`.`House_Id_fk` = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, Integer.toString(houseId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                int height = rs.getInt("Height");
                int orderId = rs.getInt("idOrder");

                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String role = rs.getString("Role");

                User user = new User(email, password, role);
                House house = new House(length, width, height, houseId);
                Order order = new Order(user, orderId, house);
                return order;
            } else {
                throw new LoginSampleException("Could not validate order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrdersFromAllUser(User user) throws LoginSampleException {
        ArrayList<Order> ordersAll = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT distinct `House`.*, `order`.* FROM `User` inner join `order` on `order`.`User_Id` = `User`.`Id` \n"
                    + "inner join `House` on `order`.`House_Id_fk` =  `House`.`House_Id`";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int houseId = rs.getInt("House_Id");
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                int height = rs.getInt("Height");
                int orderId = rs.getInt("idOrder");

                House house = new House(length, width, height, houseId);
                Order order = new Order(user, orderId, house);
                ordersAll.add(order);
            }
            return ordersAll;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
