package adapter;

import payment.Cash;
import payment.Price;

public class PriceToCash extends Cash{

    // essentially, when object is created, we're extending Cash class, meaning this class is a Cash type
    private Price price;

    public PriceToCash(Price price, double value){
        super(value);
        this.price = price;
    }

    @Override
    public double getValue(){ // we get the value of Price, but label it as a Cash value. Basically covers the Price
        // type over with Cash type
        return price.getValue(); // conversion rate is price * 1
    }

    @Override
    public void pay(){
        System.out.println("Paid with Cash: " + this.getValue());
    }
}
