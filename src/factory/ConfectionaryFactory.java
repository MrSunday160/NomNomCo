package factory;

import adapter.PriceToCash;
import adapter.PriceToCrypto;
import adapter.PriceToTransfer;
import model.Confectionary;
import model.Cupcake;
import model.Tart;
import payment.Cash;
import payment.Crypto;
import payment.Price;
import payment.Transfer;

public class ConfectionaryFactory{

    public ConfectionaryFactory(){}

    public Confectionary createConfectionary(String type, String name, String softness,
                                             String isUseTopping, String topping1,
                                             String topping2, String topping3, double price, String payment){

        Price priceTemp = new Price(price); // we create a new Price object, so that we can later on use an adapter
        // to convert into

        if(type.equals("Cupcake")){

            if(isUseTopping.equals("Y")){

                // we use new PriceToCash() to convert Price object into Cash. PriceToCash is an extension of Cash class
                if(payment.equals("Cash"))
                    return new Cupcake(name, softness, topping1, topping2, topping3, new PriceToCash(priceTemp, price));

                if(payment.equals("Transfer"))
                    return new Cupcake(name, softness, topping1, topping2, topping3, new PriceToTransfer(priceTemp,
                            price));

                if(payment.equals("Crypto"))
                    return new Cupcake(name, softness, topping1, topping2, topping3, new PriceToCrypto(priceTemp, price));

            }

            // overload constructor if there is no toppings
            if(payment.equals("Cash"))
                return new Cupcake(name, softness, new PriceToCash(priceTemp, price));

            if(payment.equals("Transfer"))
                return new Cupcake(name, softness, new PriceToTransfer(priceTemp, price));

            if(payment.equals("Crypto"))
                return new Cupcake(name, softness, new PriceToCrypto(priceTemp, price));


        }

        if(isUseTopping.equals("Y")){

            if(payment.equals("Cash"))
                return new Tart(name, softness, topping1, topping2, topping3, new PriceToCash(priceTemp, price));

            if(payment.equals("Transfer"))
                return new Tart(name, softness, topping1, topping2, topping3, new PriceToTransfer(priceTemp,
                        price));

            if(payment.equals("Crypto"))
                return new Tart(name, softness, topping1, topping2, topping3, new PriceToCrypto(priceTemp, price));

        }

        if(payment.equals("Cash"))
            return new Tart(name, softness, new PriceToCash(priceTemp, price));

        if(payment.equals("Transfer"))
            return new Tart(name, softness, new PriceToTransfer(priceTemp, price));

        if(payment.equals("Crypto"))
            return new Tart(name, softness, new PriceToCrypto(priceTemp, price));

        return null;

    }

}
