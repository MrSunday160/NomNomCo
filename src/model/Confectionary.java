package model;

import payment.Payment;
import payment.Price;

public abstract class Confectionary{

    private String name;
    private String softness;
    private String topping1;
    private String topping2;
    private String topping3;
    private Payment payment;

    // if use toppings
    public Confectionary(String name, String softness, String topping1, String topping2, String topping3, Payment payment){
        this.name = name;
        this.softness = softness;
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.payment = payment;
    }

    // if no toppings, overload the constructor
    public Confectionary(String name, String softness, Payment payment){

        this.name = name;
        this.softness = softness;
        this.payment = payment;

    }

    public String getName(){
        return name;
    }


    public String getSoftness(){
        return softness;
    }


    public String getTopping1(){
        return topping1;
    }


    public String getTopping2(){
        return topping2;
    }


    public String getTopping3(){
        return topping3;
    }


    public Payment getPayment(){
        return payment;
    }

    public abstract void bake();

}
