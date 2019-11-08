package com.sparta.jm.controller;

import com.sparta.jm.animals.RabbitPopulationSimulator;

public class Starter {
    public static void main(String[] args) {
        RabbitPopulationSimulator rabbitPopulationSimulator = new RabbitPopulationSimulator();

        rabbitPopulationSimulator.setInitialRabbitPopulation();

        System.out.println("==================================================================");
        while (rabbitPopulationSimulator.getRabbitSize() != 0 && rabbitPopulationSimulator.getRabbitSize() < 600) {
            System.out.println("At " + rabbitPopulationSimulator.getMonth() + " months");
            rabbitPopulationSimulator.simulatePopulation();
            System.out.println("Rabbit population: " + rabbitPopulationSimulator.getRabbitSize());
            System.out.println(rabbitPopulationSimulator.getAmountBorn() + " new rabbits were born this month");
            System.out.println("Number of males: " + rabbitPopulationSimulator.getNumberOfMales());
            System.out.println("Number of females: " + rabbitPopulationSimulator.getNumberOfFemales());
            System.out.println("==================================================================");
        }
    }
}
