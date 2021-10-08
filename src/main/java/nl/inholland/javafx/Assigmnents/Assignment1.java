package nl.inholland.javafx.Assigmnents;

public class Assignment1 {

    private final double rate;

    public Assignment1(){
        rate = 1.18;
    }

    public double calculateCurrency(double input){
        return input * rate;
    }
}
