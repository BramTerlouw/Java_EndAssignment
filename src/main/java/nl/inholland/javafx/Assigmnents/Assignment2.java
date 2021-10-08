package nl.inholland.javafx.Assigmnents;

public class Assignment2 {

    private final int price;
    private final double kmCosts;
    private final int ltrCosts;

    public Assignment2(){
        price = 45;
        kmCosts = 0.25;
        ltrCosts = 2;
    }

    public double calculatuRent(int nrOfDays, int kmDriven, boolean tankNotFull, int nrOfLiters){
        return calculateTotalPrice(nrOfDays) + calculateTotalKMPrice(kmDriven) + calculateLiterPrice(tankNotFull, nrOfLiters);
    }

    private int calculateTotalPrice(int nrOfDays){
        return nrOfDays * price;
    }

    private double calculateTotalKMPrice(int kmDriven){
        if (kmDriven <= 100) return 0;
        else{
            int paidKm = kmDriven - 100;
            return paidKm * kmCosts;
        }
    }

    private int calculateLiterPrice(boolean tankNotFull, int nrOfLiters){
        if (!tankNotFull) return 0;
        else {
            return nrOfLiters * ltrCosts;
        }
    }
}
