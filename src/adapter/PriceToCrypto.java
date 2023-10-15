package adapter;

import payment.Crypto;
import payment.Price;

public class PriceToCrypto extends Crypto{

    private Price price;

    public PriceToCrypto(Price price, double value){
        super(value);
        this.price = price;
    }

    @Override
    public double getValue(){
        return price.getValue() / 2;
    } // conversion rate is price / 2

    @Override
    public void pay(){
        System.out.println("Paid with Crypto: " + this.getValue());
    }
}
