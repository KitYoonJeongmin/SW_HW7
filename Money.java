package 과제7;

public class Money {
    private int price;

    Money(int itemPrice){price = itemPrice;}

    public void add(Money addMoney){
        price += addMoney.getPrice();
        //return new Money(price);
    }

    
    public Money minus(Money minusMoney){
        return new Money(price - minusMoney.price);
    }

    public Money times(int quantity){

        //timeMoney.price *= quantity;
        //price *= quantity;
        return new Money((this.price*quantity));
    }

    public int getPrice(){return price;}
}
