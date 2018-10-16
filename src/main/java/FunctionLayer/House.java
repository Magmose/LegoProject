package FunctionLayer;

public class House {

    private int length, width, height, houseId;
    private boolean windowDoor;

    public House(int length, int width, int height, int houseId) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.houseId = houseId;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHouseId() {
        return houseId;
    }

    public boolean isWindowDoor() {
        return windowDoor;
    }

    public String toHtml() {
        return "House messurements. " + "Length: " + length + ". Width:" + width + ". Height:" + height;
    }

}
