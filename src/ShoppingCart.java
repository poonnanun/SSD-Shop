import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<SaleItem> cart;
    private double total;

    public ShoppingCart(){
        cart = new ArrayList<>();
    }

    public void addItem(Item item, int quantities){
        SaleItem tmp = item.getPromotion().getSaleItem(item, quantities);
        cart.add(tmp);
    }

    public double getTotal(){
        for(SaleItem a: cart){
            total += a.getTotal();
        }
        return total;
    }

    public void printAll(){
        System.out.println("---------------------------------------------shop-list---------------------------------------------");
        for(SaleItem d: cart){
            System.out.println(d);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public void cleanCart(){
        cart.clear();
        total = 0;
        System.out.println("Shopping cart is clean.");
    }
}
