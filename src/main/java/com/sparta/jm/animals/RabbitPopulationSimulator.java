package com.sparta.jm.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RabbitPopulationSimulator {

    private List<Animal> rabbits = new ArrayList<>();
    private List<Animal> foxes = new ArrayList<>();

    private Random random = new Random();

    private int month = 1;
    private int amountBorn = 0;
    private int maleCount = 1;
    private int femaleCount = 1;

    public void setInitialRabbitPopulation() {
        rabbits.add(new Rabbit("male"));
        rabbits.add(new Rabbit("female"));

        maleCount++;
        femaleCount++;
    }

    public void simulatePopulation() {
        List<Animal> tempRabbitArray = new ArrayList<>();

        int monthlyBirths = 0;

        for (Animal rabbit : rabbits){
            rabbit.increaseAge();

            if (rabbit.getAge() >= 3 && rabbit.getGender().equals("female")) {
                for (int i = 0; i < random.nextInt(14) + 1; i++) {
                    tempRabbitArray.add(new Rabbit(rabbit.offSpringGender()));
                    if (tempRabbitArray.get(i).getGender() == "male") {
                        maleCount++;
                    } else {
                        femaleCount++;
                    }
                    monthlyBirths++;
                }
            }
        }
        rabbits.addAll(tempRabbitArray);


        for(Animal fox : foxes) {
            fox.increaseAge();

            if (fox.getAge() >= 10 && fox.getGender().equals("female")) {
                for (int i = 0; i < random.nextInt(14) + 1; i++) {
                    tempRabbitArray.add(new Fox(fox.offSpringGender()));
                }
            }

            amountBorn = monthlyBirths;
            month++;
        }

    }

    public int getAmountBorn() {
        return amountBorn;
    }

    public int getNumberOfMales() {
        return maleCount;
    }

    public int getNumberOfFemales() {
        return femaleCount;
    }

    public int getMonth() {
        return month;
    }

    public int getRabbitSize() {
        return rabbits.size();
    }

}

//Phase 3 - Predators
//        * We will now introduce predators to affect the rabbit population
//        * A single Fox breeding pair will be introduced done
//        * A fox will breed once a year
//        * They have between 1-10 kits
//        * They reach breeding maturity in 10 months
//        * While food is available a single fox can eat up to 20 rabbits a month

// let a male and female fox join the rabbit population after 10 months