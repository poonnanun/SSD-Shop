import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String name;
    private double price;
    private Promotion promotion;

    public Item(String name, double price, int id){
        this.id = id;
        this.name = name;
        this.price = price;
        this.promotion = new NonPromotion();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        System.out.println("Change promotion to "+promotion.getClass());
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        if(promotion instanceof NonPromotion){
            return String.format("%d. %s %.2f baht", id, name, price);
        }else {
            return String.format("%d. %s %.2f baht, currently have promotion: %s.", id, name, price, promotion.toString());
        }
    }
}
