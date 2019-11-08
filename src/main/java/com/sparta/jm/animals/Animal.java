package com.sparta.jm.animals;

import java.util.Random;

public class Animal {

    private int age;
    private String gender;
    private Random random;

    public int getAge() {
        return age;
    }

    public Animal(String gender) {
        age = 0;
        this.gender = gender;
        this.random = new Random();
    }

    protected String offSpringGender() {
        Boolean result = random.nextBoolean();
        if (result) {
            return "male";
        } else {
            return "female";
        }
    }

    public String getGender() {
        return gender;
    }

    public int increaseAge() {
        return age++;
    }

}
