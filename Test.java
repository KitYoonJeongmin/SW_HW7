package 과제7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Test {
    Store store = new Store();
    Sale sale = new Sale();

    @org.junit.Test
    public void makeSaleTest(){
        sale = store.getRegister().makeNewSale();
        assertNotNull(sale);
    }
    
    @org.junit.Test
    public void enterItemTest(){
        sale = store.getRegister().makeNewSale();
        store.getRegister().enterItem(new ItemID(200),10);
        SalesLineltem sli = sale.getSliList().get(0);
        System.out.println(sli.getProductSpec().getDescription());
    } 
    @org.junit.Test
    public void endSaleTest(){
        sale = store.getRegister().makeNewSale();
        store.getRegister().endSale();
        assertTrue(sale.isComplete());  
    }
    @org.junit.Test
    public void makePaymentTest(){
        sale = store.getRegister().makeNewSale();
        Payment payment = store.getRegister().makePayment(new Money(500));
        assertEquals(payment.getAmount().getPrice(), new Money(500).getPrice());  
    }
    @org.junit.Test
    public void printBillTest(){
        sale = store.getRegister().makeNewSale();
        store.getRegister().enterItem(new ItemID(100), 10);
        store.getRegister().enterItem(new ItemID(200), 10);
        store.getRegister().endSale();
        store.getRegister().makePayment(new Money(500));
        String bill = store.getRegister().getSale().printBill();
        System.out.println(bill);
    }

    
}
