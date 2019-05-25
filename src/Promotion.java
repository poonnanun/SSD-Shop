import java.io.Serializable;

public interface Promotion extends Serializable {

    SaleItem getSaleItem(Item item, int quan);

}
