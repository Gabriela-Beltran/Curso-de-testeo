package com.platzi.javatest.player;

public class Player {
    private Dice dice;
    private int minNumber;

    public Player(Dice dice , int minNumber ) {
        this.dice = dice;
        this.minNumber= minNumber;
    }
    public boolean play(){
       int diceNumber=  dice.roll();
       return diceNumber> minNumber;
    }
}
