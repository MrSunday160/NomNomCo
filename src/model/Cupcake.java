package model;

import payment.Payment;

public class Cupcake extends Confectionary{

    public Cupcake(String name, String softness, String topping1, String topping2, String topping3, Payment payment){
        super(name, softness, topping1, topping2, topping3, payment);
    }

    public Cupcake(String name, String softness, Payment payment){ // overload constructor

        super(name, softness, payment);

    }

    @Override
    public void bake(){

        System.out.println("Confectionary Baked");

    }
}
