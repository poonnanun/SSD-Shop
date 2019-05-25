public class DiscountPromotion implements Promotion{

    private int condition;
    private int discountPercentage;

    public DiscountPromotion(int condition, int discountPercentage){
        this.condition = condition;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public SaleItem getSaleItem(Item item, int quan) {
        double total = 0;
        if(quan >= condition){
            total = item.getPrice() - (item.getPrice() * (discountPercentage)/100);
        }else{
            total = item.getPrice();
        }
        return new SaleItem(item.getName(), total, quan);
    }

    @Override
    public String toString() {
        return String.format("Buy more than %d get discount %d percent", condition-1, discountPercentage);
    }
}
