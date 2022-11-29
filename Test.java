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
        int sliNum = store.getRegister().enterItem(new ItemID(0),10);   //item discription을 넣어줘야 됨
        assertEquals(sliNum, 1);
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
    public void printBill(){
        sale = store.getRegister().makeNewSale();
        
    }

    
}
