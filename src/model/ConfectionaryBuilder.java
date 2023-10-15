package model;

import factory.ConfectionaryFactory;

import java.util.logging.Logger;

public class ConfectionaryBuilder{

    private String type;
    private String name;
    private String softness;
    private String isUseTopping;
    private String topping1 = null;
    private String topping2 = null;
    private String topping3 = null;
    private Double price;
    private String payment;

    public ConfectionaryBuilder(){}

    public ConfectionaryBuilder setType(String type){

        this.type = type;
        return this;

    }

    public ConfectionaryBuilder setName(String name){

        this.name = name;
        return this;

    }

    public ConfectionaryBuilder setSoftness(String softness){

        this.softness = softness;
        return this;

    }

    public ConfectionaryBuilder setIsUseTopping(String isUseTopping){

        this.isUseTopping = isUseTopping;
        return this;

    }

    public ConfectionaryBuilder setTopping1(String topping1){

        this.topping1 = topping1;
        return this;

    }

    public ConfectionaryBuilder setTopping2(String topping2){

        this.topping2 = topping2;
        return this;

    }

    public ConfectionaryBuilder setTopping3(String topping3){

        this.topping3 = topping3;
        return this;

    }

    public ConfectionaryBuilder setPrice(Double price){

        this.price = price;
        return this;

    }

    public ConfectionaryBuilder setPayment(String payment){

        this.payment = payment;
        return this;

    }

    // call factory
    public Confectionary makeConfectionary(){

        System.out.println("makeConfectioanry() called");
        // call factory
        return new ConfectionaryFactory().createConfectionary(type, name, softness, isUseTopping, topping1, topping2,
                topping3, price, payment);

    }

}
