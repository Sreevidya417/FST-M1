package org.example.Activities;

public class Activity1 {

    public static void main(String[] args) {
        Car audi = new Car();
        audi.make = 2014;
        audi.color = "Black";
        audi.transmission = "Manual";

        //Using Car class method
        audi.displayCharacterstics();
        audi.accelerate();
        audi.brake();
    }

}