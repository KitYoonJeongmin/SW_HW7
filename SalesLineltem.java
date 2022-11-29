package 과제7;

// Class SalesLineltem
public class SalesLineltem {
    private int quantity;
    private ProductSpecification productSpec;

    public SalesLineltem(ProductSpecification spec, int quantity) {
        this.productSpec = spec;
        this.quantity = quantity;
    }

    public Money getSubtotal() {   return productSpec.getPrice().times(quantity);  } //Money에 times 함수 생성

    public ProductSpecification getProductSpec() {return productSpec;}

}