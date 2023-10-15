package model;

import payment.Payment;

public class Tart extends Confectionary{


    public Tart(String name, String softness, String topping1, String topping2, String topping3, Payment payment){
        super(name, softness, topping1, topping2, topping3, payment);
    }

    public Tart(String name, String softness, Payment payment){ // overload constructor

        super(name, softness, payment);

    }

    @Override
    public void bake(){

        System.out.println("Tart Baked");

    }
}
