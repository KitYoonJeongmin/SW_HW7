package 과제7;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sale {
    private ArrayList<SalesLineltem> lineltems = new ArrayList<SalesLineltem>();
    private Date date = new Date();
    private boolean isComplete = false;
    private Payment payment;

    public Money getBalance()  {
            return payment.getAmount().minus(getTotal());
    }

    public void becomeComplete() {  isComplete = true; }

    public boolean isComplete() {   return isComplete;   }
        
    public int makeLineItem(ProductSpecification spec, int quantity) {
        lineltems.add(new SalesLineltem(spec, quantity));
        return lineltems.size()-1;
    }

    public Money getTotal()
    {
        Money total = new Money(0);
        Iterator<SalesLineltem> i = lineltems.iterator( ) ;    
        while ( i.hasNext() ){
            SalesLineltem sli = (SalesLineltem) i.next();
            total.add( sli.getSubtotal() );
        }
        return total; 
    }

    public Payment makePayment(Money cashTendered) {   payment = new Payment(cashTendered);  return payment;}

    public String getDate() {
        SimpleDateFormat dates = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
        return dates.format(this.date)+time.format(this.date);
    }

    public ArrayList<SalesLineltem> getSLI(){
        return lineltems;
    }
}