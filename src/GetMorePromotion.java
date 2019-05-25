public class GetMorePromotion implements Promotion{

    private int condition;
    private int freeAmount;

    public GetMorePromotion(int condition, int freeAmount){
        this.condition = condition;
        this.freeAmount = freeAmount;
    }

    @Override
    public SaleItem getSaleItem(Item item, int quan) {
        double total = item.getPrice() * quan;
        int newQuan = quan;
        if(quan >= condition){
            newQuan = (quan/condition)*freeAmount;
        }else{
            // do nothing
        }
        return new SaleItem(item.getName(), total, newQuan, 1);
    }

    @Override
    public String toString() {
        return String.format("Buy %d get %d more for free.", condition-1, freeAmount);
    }
}
