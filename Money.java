package 과제7;

public class Money {
    private int price;

    Money(int itemPrice){price = itemPrice;}

    public Money add(Money addMoney){
        price += addMoney.price;
        return new Money(price);
    }

    
    public Money minus(Money minusMoney){
        return new Money(price - minusMoney.price);
    }

    public Money times(int quantity){
        Money timeMoney = new Money(price);
        timeMoney.price *= quantity;
        return timeMoney;
    }

    public int getPrice(){return price;}
}
