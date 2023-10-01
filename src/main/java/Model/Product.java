package Model;

public class Product {
    private int id;
    private String name;
    private String prize;
    private String status;
    private String houseProduct;

    public Product(int id, String name, String prize, String status, String houseProduct) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.status = status;
        this.houseProduct = houseProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHouseProduct() {
        return houseProduct;
    }

    public void setHouseProduct(String houseProduct) {
        this.houseProduct = houseProduct;
    }
}
