package main;

import database.Database;
import factory.ConfectionaryFactory;
import model.Confectionary;

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
        Float price;
        String payment;

        // get type
        while(true){

            System.out.printf("Input confectionary type [Cupcake | Tart] [case sensitive]: ");
            type = scanner.nextLine();
            if(type.equals("Cupcake") || type.equals("Tart"))
                break;

        }
        // get name
        while(true){

            System.out.printf("Input confectionary name [length between 5 - 15]: ");
            name = scanner.nextLine();
            if(name.length() >= 5 && name.length() <= 15)
                break;

        }
        // get softness
        while(true){

            System.out.printf("Input confectionary softness [Fluffy | Medium | Hard] [case sensitive]: ");
            softness = scanner.nextLine();
            if(softness.equals("Fluffy") || softness.equals("Medium") || softness.equals("Hard"))
                break;

        }
        // get topping
        while(true){

            System.out.printf("Adding additional topping [Y | N] [case sensitive] ");
            isUseTopping = scanner.nextLine();
            if(isUseTopping.equals("Y")){

                // get topping 1, 2, 3
                while(true){

                    System.out.printf("Input topping 1 [length between 1 - 10]: ");
                    topping1 = scanner.nextLine();
                    if(topping1.length() < 1 || topping1.length() > 10){

                    }
                    else
                        break;

                }

                while(true){

                    System.out.printf("Input topping 2 [length between 1 - 10]: ");
                    topping2 = scanner.nextLine();
                    if(topping2.length() < 1 || topping2.length() > 10){

                    }
                    else
                        break;

                }

                while(true){

                    System.out.printf("Input topping 3 [length between 1 - 10]: ");
                    topping3 = scanner.nextLine();
                    if(topping3.length() < 1 || topping3.length() > 10){

                    }
                    else
                        break;

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
            price = Float.valueOf(scanner.nextLine());
            if(price >= 10.0 || price <= 50.0)
                break;

        }
        // get payment type
        while(true){

            System.out.printf("What kind of payment [Cash | Transfer | Crypto] [case sensitive]: ");
            payment = scanner.nextLine();
            if(payment.equals("Cash") || payment.equals("Transfer") || payment.equals("Crypto"))
                break;

        }

        // setup db & factory
        Database db = Database.getInstance(); // get db instance, singleton
        ConfectionaryFactory confectionaryFactory = new ConfectionaryFactory(); // setup factory

        // add confectionary with a new factory .createConfectionary()
        db.addConfectionary(confectionaryFactory.createConfectionary(type, name, softness,  isUseTopping, topping1,
                topping2, topping3, price, payment));

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
                System.out.printf("Price: " );
                confectionary.getPayment().pay();
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