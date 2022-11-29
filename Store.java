package 과제7;

// Class Store
public class Store {
    private ProductCatalog catalog = new ProductCatalog();
    private Register register = new Register(catalog);

    public Store(){
        DB dbManager = new DB();
         catalog = dbManager.getDB(catalog);
    }
   
    public Register getRegister() {    return register;  }
}
