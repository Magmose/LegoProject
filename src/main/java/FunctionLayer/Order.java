package FunctionLayer;

public class Order {

    private User user;
    private int idOrder;
    private House house;
    private boolean isShipped;

    public Order(User user, int idOrder, House house) {
        this.user = user;
        this.idOrder = idOrder;
        this.house = house;
    }

    public void setIsShipped(boolean isShipped) {
        this.isShipped = isShipped;
    }

    public User getUser() {
        return user;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public House getHouse() {
        return house;
    }

    public boolean isIsShipped() {
        return isShipped;
    }

}
