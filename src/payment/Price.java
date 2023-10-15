package payment;

public class Price implements Payment{

    private double value;

    public Price(double value){

        this.value = value;

    }

    public double getValue(){

        return value;

    }

    @Override
    public void pay(){

    }

    @Override
    public String getType(){
        return null;
    }
}
