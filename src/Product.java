import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private long price;
    private String manufacturer;
    private int amount;
    private String origin;

    public Product(String name, long price, String manufacturer, int amount, String origin) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.amount = amount;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
