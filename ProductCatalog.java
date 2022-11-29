package 과제7;
import java.util.*;

public class ProductCatalog {
    private HashMap<ItemID,ProductSpecification> productSpecifications = new HashMap<ItemID,ProductSpecification>();
    
    public ProductCatalog() {
        // sample data
        ItemID idl = new ItemID(100);
        ItemID id2 = new ItemID(200);
        Money price = new Money(3);
        ProductSpecification ps;
        ps = new ProductSpecification(idl, price, "product 1");
        productSpecifications.put(idl, ps);
        ps = new ProductSpecification(id2, price, "product 2");
        productSpecifications.put(id2, ps);
    }

    public ProductSpecification getSpecification(ItemID id) {

        return productSpecifications.get(id);
    }

    public HashMap<ItemID,ProductSpecification> getProductSpecifications(){
        return productSpecifications;
    }
}
