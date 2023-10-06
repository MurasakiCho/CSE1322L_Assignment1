/*
Class: CSE 1322L
Section: WJ1
Term: Summer 2022
Instructor: Maneesha Kumari Penmetsa
Name: Briana O'Neal
Lab#: Assignment 1
*/

import java.util.Scanner;
class Coins {
    private int quantityOnHand;
    private float denomination;
    private float weight;

    Coins(float denomination, float weight) {
        this.denomination = denomination;
        this.weight = weight;
    }

    public void increaseQuantity (int x){
        quantityOnHand += x;
    }
    public void decreaseQuantity (int x){
        quantityOnHand -= x;
        if ( (quantityOnHand) < 0){
            quantityOnHand = 0;
        }
    }

    public float getTotalValue(){
        return denomination * quantityOnHand;
    }
    public float getTotalWeight() {
        return weight * quantityOnHand;
    }
    public int getQuantityOnHand(){
        return quantityOnHand;
    }

    public float getDenomination() {
        return denomination;
    }

    public String printPretty(float amount){
        return("$" + String.format("%4.2f", amount));
    }
    public String toString (){
        return printPretty(getTotalValue()) + " in " + printPretty(denomination) + " coins";
    }

    public int withdrawal(float x){
        //division
        int numOfCoins = (int) (x/denomination);
        //do I have enough notes?
        if (numOfCoins > quantityOnHand){
            numOfCoins = quantityOnHand;
        }
        decreaseQuantity(numOfCoins);
        return numOfCoins;
    }

}

class Notes {
    private int quantityOnHand;
    private int denomination;

    Notes(int denomination) {
        this.denomination = denomination;
    }

    public void increaseQuantity(int x){
        quantityOnHand += x;
    }
    public void decreaseQuantity(int x){
        quantityOnHand -= x;
        if ( (quantityOnHand) < 0){
            quantityOnHand = 0;
        }
    }

    public int getTotalValue(){
        return denomination * quantityOnHand;
    }
    public int getQuantiyOnHand(){
        return quantityOnHand;
    }

    public int getDenomination() {
        return denomination;
    }

    public String printPretty (float amount){
        return ("$" + String.format("%4.2f",amount));
    }
    public String toString (){
        return printPretty(getTotalValue()) + " in " + printPretty(denomination) + " notes";
    }

    public int withdrawal(float x){
        //division
        int numOfNotes = (int) x/denomination;
        //do I have enough notes?
        if (numOfNotes > quantityOnHand){
            numOfNotes = quantityOnHand;
        }
        decreaseQuantity(numOfNotes);
        return numOfNotes;
    }

}

public class Assignment1 {
    public static void main(String[] args) {
        Notes twenties = new Notes(20);
        Notes tens = new Notes(10);
        Notes fives = new Notes(5);
        Notes ones = new Notes(1);

        Coins quarters = new Coins(0.25f,0.2f);
        Coins dimes = new Coins(0.10f,0.08f);
        Coins nickels = new Coins(0.05f,0.176f);
        Coins pennies = new Coins(0.01f,0.088f);

        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);

        //print how much we have in each category
        System.out.println(twenties.toString());
        System.out.println(tens.toString());
        System.out.println(fives.toString());
        System.out.println(ones.toString());
        System.out.println(quarters.toString());
        System.out.println(dimes.toString());
        System.out.println(nickels.toString());
        System.out.println(pennies.toString());

        //print total value and total weight
        float totalValue =  twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + ones.getTotalValue()
                + quarters.getTotalValue() + dimes.getTotalValue() + nickels.getTotalValue() + pennies.getTotalValue();
        float totalWeight = quarters.getTotalWeight() + dimes.getTotalWeight() + nickels.getTotalWeight() + pennies.getTotalWeight();

        System.out.println("Total Money is " + String.format("%4.2f",totalValue) + " total weight is "+ totalWeight +  "oz");
        System.out.println("How much do you need?");

        //user input and print needed notes ands coins
        Scanner scan = new Scanner(System.in);
        float amountNeeded = scan.nextFloat();

        //notes
        int numOfNotes = twenties.withdrawal(amountNeeded);
        amountNeeded -= (numOfNotes * twenties.getDenomination());
        for(int i = 0; i < numOfNotes; i++){
            System.out.println("Give them a $20 note");
        }
        numOfNotes = tens.withdrawal(amountNeeded);
        amountNeeded -= (numOfNotes * tens.getDenomination());
        for(int i = 0; i < numOfNotes; i++){
            System.out.println("Give them a $10 note");
        }
        numOfNotes = fives.withdrawal(amountNeeded);
        amountNeeded -= (numOfNotes * fives.getDenomination());
        for(int i = 0; i < numOfNotes; i++){
            System.out.println("Give them a $5 note");
        }
        numOfNotes = ones.withdrawal(amountNeeded);
        amountNeeded -= (numOfNotes * ones.getDenomination());
        for(int i = 0; i < numOfNotes; i++){
            System.out.println("Give them a $1 note");
        }

        //coins
        int numOfCoins = quarters.withdrawal(amountNeeded);
        amountNeeded -= (numOfCoins * quarters.getDenomination());
        String str = String.format("%.2f", amountNeeded);
        amountNeeded = Float.parseFloat(str);
        for(int i = 0; i < numOfCoins; i++){
            System.out.println("Give them a quarter");
        }

        numOfCoins = dimes.withdrawal(amountNeeded);
        amountNeeded -= (numOfCoins * dimes.getDenomination());
        str = String.format("%.2f", amountNeeded);
        amountNeeded = Float.parseFloat(str);
        for(int i = 0; i < numOfCoins; i++){
            System.out.println("Give them a dime");
        }

        numOfCoins = nickels.withdrawal(amountNeeded);
        amountNeeded -= (numOfCoins * nickels.getDenomination());
        str = String.format("%.2f", amountNeeded);
        amountNeeded = Float.parseFloat(str);
        for(int i = 0; i < numOfCoins; i++){
            System.out.println("Give them a nickel");
        }

        numOfCoins = pennies.withdrawal(amountNeeded);
        amountNeeded -= (numOfCoins * pennies.getDenomination());
        str = String.format("%.2f", amountNeeded);
        amountNeeded = Float.parseFloat(str);
        for(int i = 0; i < numOfCoins; i++){
            System.out.println("Give them a penny");
        }

        if(amountNeeded > 0){
            System.out.println("I don't have enough money. I still owe you $" + amountNeeded);
        }

        totalValue =  twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + ones.getTotalValue()
                + quarters.getTotalValue() + dimes.getTotalValue() + nickels.getTotalValue() + pennies.getTotalValue();
        totalWeight = quarters.getTotalWeight() + dimes.getTotalWeight() + nickels.getTotalWeight() + pennies.getTotalWeight();
        System.out.println("I have $" + String.format("%4.2f",totalValue) + " left, it's total weight is "+ totalWeight +  "oz");
    }
}
