package main;

import database.Database;
import factory.ConfectionaryFactory;
import model.Confectionary;
import model.ConfectionaryBuilder;

import java.util.Scanner;

public class Main{

    // setup scanner
    Scanner scanner = new Scanner(System.in);
    public void displayMenu(){

        System.out.println("Nom Nom Co.");
        System.out.println("============");
        System.out.println("1. Bake Confectionary");
        System.out.println("2. View Confectionary");
        System.out.println("3. Exit");
        System.out.printf(">>");

    }

    public void createConfectionaryMenu(){

        String type;
        String name;
        String softness;
        String isUseTopping;
        String topping1 = null;
        String topping2 = null;
        String topping3 = null;
        Double price;
        String payment;

        ConfectionaryBuilder confectionaryBuilder = new ConfectionaryBuilder();

        // get type
        while(true){

            System.out.printf("Input confectionary type [Cupcake | Tart] [case sensitive]: ");
            type = scanner.nextLine();
            if(type.equals("Cupcake") || type.equals("Tart")){
                confectionaryBuilder.setType(type);
                break;
            }

        }
        // get name
        while(true){

            System.out.printf("Input confectionary name [length between 5 - 15]: ");
            name = scanner.nextLine();
            if(name.length() >= 5 && name.length() <= 15){
                confectionaryBuilder.setName(name);
                break;
            }

        }
        // get softness
        while(true){

            System.out.printf("Input confectionary softness [Fluffy | Medium | Hard] [case sensitive]: ");
            softness = scanner.nextLine();
            if(softness.equals("Fluffy") || softness.equals("Medium") || softness.equals("Hard")){
                confectionaryBuilder.setSoftness(softness);
                break;
            }

        }
        // get topping
        while(true){

            System.out.printf("Adding additional topping [Y | N] [case sensitive] ");
            isUseTopping = scanner.nextLine();
            confectionaryBuilder.setIsUseTopping(isUseTopping);
            if(isUseTopping.equals("Y")){

                confectionaryBuilder.setIsUseTopping(isUseTopping);
                // get topping 1, 2, 3
                while(true){

                    System.out.printf("Input topping 1 [length between 1 - 10]: ");
                    topping1 = scanner.nextLine();
                    if(topping1.length() < 1 || topping1.length() > 10){

                    }
                    else{
                        confectionaryBuilder.setTopping1(topping1);
                        break;
                    }

                }

                while(true){

                    System.out.printf("Input topping 2 [length between 1 - 10]: ");
                    topping2 = scanner.nextLine();
                    if(topping2.length() < 1 || topping2.length() > 10){

                    }
                    else{
                        confectionaryBuilder.setTopping2(topping2);
                        break;
                    }

                }

                while(true){

                    System.out.printf("Input topping 3 [length between 1 - 10]: ");
                    topping3 = scanner.nextLine();
                    if(topping3.length() < 1 || topping3.length() > 10){

                    }
                    else{
                        confectionaryBuilder.setTopping3(topping3);
                        break;
                    }

                }

                break;


            }
            else if(isUseTopping.equals("N")){

                break;

            }

        }
        // get price
        while(true){

            System.out.printf("Input confectionary price [10.0 - 50.0]: ");
            price = Double.valueOf(scanner.nextLine());
            if(price >= 10.0 || price <= 50.0){
                confectionaryBuilder.setPrice(price);
                break;
            }

        }
        // get payment type
        while(true){

            System.out.printf("What kind of payment [Cash | Transfer | Crypto] [case sensitive]: ");
            payment = scanner.nextLine();
            if(payment.equals("Cash") || payment.equals("Transfer") || payment.equals("Crypto")){
                confectionaryBuilder.setPayment(payment);
                break;
            }

        }

        // setup db & factory
        Database db = Database.getInstance(); // get db instance, singleton
        // ConfectionaryFactory confectionaryFactory = new ConfectionaryFactory(); // setup factory

        /*// add confectionary with a new factory .createConfectionary()
        db.addConfectionary(confectionaryFactory.createConfectionary(type, name, softness,  isUseTopping, topping1,
                topping2, topping3, price, payment));*/

        // call builder
        db.addConfectionary(confectionaryBuilder.makeConfectionary());
        // by using a builder, we can customize our COnfectionary and wrap it all up using .makeConfectionary()

        System.out.println("Press enter to continue");
        scanner.nextLine();
        new Main();

    }

    public void viewConfectionary(){

        Database db = Database.getInstance();
        if(db.getConfectionaries().isEmpty()){

            System.out.println("No Confectionary Yet");
            System.out.println("Press enter to continue");
            scanner.nextLine();

        }
        else{

            for(Confectionary confectionary : db.getConfectionaries()){

                System.out.println("Name: " + confectionary.getName());
                System.out.println("Softness: " + confectionary.getSoftness());
                if(confectionary.getTopping1() == null)
                    System.out.println("Topping: -");
                else{

                    System.out.println("Topping 1: " + confectionary.getTopping1());
                    System.out.println("Topping 2: " + confectionary.getTopping2());
                    System.out.println("Topping 3: " + confectionary.getTopping3());

                }
                System.out.println("PaymentType: " + confectionary.getPayment().getType());
                System.out.println("Price: " + confectionary.getPayment().getValue());
//                confectionary.getPayment().pay();
                /*

                when we create the object, lets say new Cupcake(), we're passing the adapter as its payment
                because Confectionary holds a Payment attribute, a Cupcake will also need a Payment, in this case
                we use the adapter as its payment.
                when we call confectionary.getPayment(), we're accessing the payment of Cupcake (from parent)
                which returns a Payment object
                this returned object is the adapter itself. Moreover, the adapters all implements Payment, which
                means that Confectionary parent class can hold these adapters.
                when we call .pay(), we're basically calling (lets say) PriceToCash.pay() method, instead of the
                Cash.pay() method, since we constructed Cupcake using PriceToPay.
                In other words, the adapter is wearing a mask to identify themselves as the payment type,
                in which they are also implementing Payment interface, which also is held inside Confectionary

                Since lets say, PriceToCash extends Cash, it means that it can access Cash's .getType()
                Becasue PriceToCash isnt implementing Payment interface, it's not bound to implement the methods of
                the interface, instead Cash is implementing Payment interface, causing it to be bound to implement
                all methods inside Payment.
                Thats why we cant access confectioanry.getPayment.getValue() (inside PriceToCash) since .getPayment()
                 only returns Payment type.
                 In other words, PriceToCash is not Payment, but Cash
                 while Cash is payment, so to access .getValue(), we need Payment interface to hold .getValue()

                 */

                System.out.println("============================");

            }

        }

        new Main();

    }

    public Main(){

        displayMenu();
        int input = Integer.parseInt(scanner.nextLine());

        switch(input){

            case 1:
                createConfectionaryMenu();
                break;

            case 2:
                viewConfectionary();
                break;

            case 3:
                System.out.println("Thank you for using nomnom service");
                return;

            default:
                throw new IllegalArgumentException("Error input number");
//                break;

        }

    }

    public static void main(String[] args){

        new Main();

    }
}