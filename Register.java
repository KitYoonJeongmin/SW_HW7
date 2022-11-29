package 과제7;

// Class Register
public class Register {
    private ProductCatalog catalog;
    private Sale sale;

    public Register(ProductCatalog catalog) {  this.catalog = catalog; }

	public void endSale()  {   sale.becomeComplete(); }

    public int enterItem(ItemID id, int quantity) {
        ProductSpecification spec = catalog.getSpecification(id);
        int sliNum = sale.makeLineItem(spec, quantity);
        return sliNum;
    }

    public Sale makeNewSale() { 
      sale = new Sale(); 
      return sale;
    }

    public Payment makePayment(Money cashTendered) {   return sale.makePayment(cashTendered);  }

    public Sale getSale(){return sale;}


}
