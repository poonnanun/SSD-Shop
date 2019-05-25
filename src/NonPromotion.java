public class NonPromotion implements Promotion{

    @Override
    public SaleItem getSaleItem(Item item, int quan) {
        return new SaleItem(item.getName(), item.getPrice(), quan);
    }
}
