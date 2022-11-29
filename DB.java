package 과제7;

public class DB {
    DB(){}
    public ProductCatalog getDB(ProductCatalog catalog){
        ProductSpecification ps;
        ItemID id1 = new ItemID(100);
        Money price1 = new Money(800);
        ps = new ProductSpecification(id1, price1, "메로나");
        catalog.getProductSpecifications().put(id1,ps);
        
        ItemID id2 = new ItemID(200);
        Money price2 = new Money(2000);
        ps = new ProductSpecification(id2, price2, "월드콘");
        catalog.getProductSpecifications().put(id2,ps);
       
        ItemID id3 = new ItemID(300);
        Money price3 = new Money(600);
        ps = new ProductSpecification(id3, price3, "바밤바");
        catalog.getProductSpecifications().put(id3,ps);
        
        return catalog;
        
    }

}
