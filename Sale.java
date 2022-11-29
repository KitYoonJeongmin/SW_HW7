package 과제7;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sale {
    ArrayList<String> sliLog = new ArrayList<String>();
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
        String sliString = new String();
        sliString += Integer.toString(spec.getltemlD().getID()) ;
        sliString += spec.getDescription();
        sliString += Integer.toString(spec.getPrice().getPrice());
        sliLog.add(sliString);
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

    public String printBill(){

        Iterator<String> i = sliLog.iterator( ) ;    
        Iterator<SalesLineltem> j = lineltems.iterator();
        while ( i.hasNext() && j.hasNext() ){
            String sliString = (String) i.next();
            SalesLineltem sli = (SalesLineltem) j.next();
            sliString += sli.getSubtotal().toString();
        }

        String bill = new String();
        bill = getDate()+"\n";

        Iterator<String> k = sliLog.iterator( ) ;    
        while ( k.hasNext()){
            bill+=(String) k.next()+"\n";
        }
        bill += ("총 가격:"+Integer.toString(getTotal().getPrice())+"\n");
        bill += ("지불 금액:"+Integer.toString(payment.getAmount().getPrice())+"\n");
        bill += ("거스름돈:"+Integer.toString(getBalance().getPrice()));
        return bill;
    }
}