package payment;

public class Cash implements Payment{

    private double value;

    public Cash(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void pay(){
        System.out.println("Paid with Cash: " + this.getValue());
    }

    @Override
    public String getType(){

        return "Cash";

    }

}
