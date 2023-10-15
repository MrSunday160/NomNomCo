package payment;

public class Crypto implements Payment{

    private double value;

    public Crypto(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void pay(){
        System.out.println("Paid with Crypto: " + this.getValue());
    }

    @Override
    public String getType(){
        return "Crypto";
    }
}
