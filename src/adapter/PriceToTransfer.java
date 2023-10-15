package adapter;

import payment.Price;
import payment.Transfer;

public class PriceToTransfer extends Transfer{

    private Price price;

    public PriceToTransfer(Price price, double value){
        super(value);
        this.price = price;
    }

    @Override
    public double getValue(){
        return price.getValue() * 1.1;
    }

    @Override
    public void pay(){
        System.out.println("Paid with Transfer: " + this.getValue());
    }
}
