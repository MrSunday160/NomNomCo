package payment;

public class Transfer implements Payment{

    private double value;

    public Transfer(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void pay(){
        System.out.println("Paid with Transfer: " + this.getValue());
    }

    @Override
    public String getType(){
        return "Transfer";
    }
}
