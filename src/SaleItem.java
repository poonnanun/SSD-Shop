public class SaleItem {

    private String name;
    private double finalPrice;
    private int quantities;

    public SaleItem(String name, double price, int quantities){
        this.name = name;
        this.finalPrice = price*quantities;
        this.quantities = quantities;
    }

    public SaleItem(String name, double price, int quantities, int check){
        this.name = name;
        this.finalPrice = price;
        this.quantities = quantities;
    }

    public double getTotal(){
        return this.finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%d %s for %.2f baht",quantities,name,finalPrice);
    }
}
