package ControlWork4;

import java.util.Objects;
import java.util.Random;

public class Cat implements Functionable{
    private String name;
    private int age;
    private int fedState;
    private int delightState;
    private int healthState;
    private boolean functionState;
    private int averageState;

    public Cat(String name, int age, int fedState, int delightState, int healthState) {
        this.name = name;
        this.age = age;
        this.fedState = fedState;
        this.delightState = delightState;
        this.healthState = healthState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && fedState == cat.fedState && delightState == cat.delightState && healthState == cat.healthState && functionState == cat.functionState && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, fedState, delightState, healthState, functionState);
    }

    public int getAverageState() {
        return averageState;
    }

    public void setAverageState(int averageState) {
        this.averageState = averageState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFedState() {
        return fedState;
    }

    public void setFedState(int fedState) {
        this.fedState = fedState;
    }

    public int getDelightState() {
        return delightState;
    }

    public void setDelightState(int delightState) {
        this.delightState = delightState;
    }

    public int getHealthState() {
        return healthState;
    }

    public void setHealthState(int healthState) {
        this.healthState = healthState;
    }

    public boolean isFunctionState() {
        return functionState;
    }

    public void setFunctionState(boolean functionState) {
        this.functionState = functionState;
    }

    public int countAverage(Cat cat){
        int average = 0;
        average = (cat.getFedState()+cat.getHealthState()+cat.getDelightState())/3;
        return average;
    }

    @Override
    public Cat feedCat(Cat cat) {
        Random r = new Random();
        int random = r.nextInt(6) +1;
        if(random <= 3) {
            if (cat.getAge() < 6) {
                cat.setFedState(cat.getFedState() + 7);
                cat.setDelightState(cat.getDelightState()+7);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setFedState(cat.getFedState() + 5);
                cat.setDelightState(cat.getDelightState()+5);
            } else {
                cat.setFedState(cat.getFedState() + 4);
                cat.setDelightState(cat.getDelightState()+4);
            }
            System.out.printf("You've fed a %s, %d years old\n", cat.getName(), cat.getAge());
        }else {
            if (cat.getAge() < 6) {
                cat.setFedState(cat.getFedState() + 7);
                cat.setDelightState(cat.getDelightState()-1);
                cat.setHealthState(cat.getHealthState()-1);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setFedState(cat.getFedState() + 5);
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-2);
            } else {
                cat.setFedState(cat.getFedState() + 4);
                cat.setDelightState(cat.getDelightState()-3);
                cat.setHealthState(cat.getHealthState()-3);
            }
            System.out.printf("%s was poisoned",cat.getName());
        }
        return cat;
    }

    @Override
    public Cat playWithCat(Cat cat) {
        Random r = new Random();
        int random = r.nextInt(6) +1;
        if(random <= 3){
            if(cat.getAge() < 6){
                cat.setDelightState(cat.getDelightState()+7);
                cat.setHealthState(cat.getHealthState()+7);
                cat.setFedState(cat.getFedState()-3);
            }else if(cat.getAge() >= 6 && cat.getAge() < 10){
                cat.setDelightState(cat.getDelightState()+5);
                cat.setHealthState(cat.getHealthState()+5);
                cat.setFedState(cat.getFedState()-5);
            }else{
                cat.setDelightState(cat.getDelightState()+4);
                cat.setHealthState(cat.getHealthState()+4);
                cat.setFedState(cat.getFedState()-6);
            }
            System.out.printf("You've played with %s, %d years old\n", cat.getName(), cat.getAge());
        }else{
            if(cat.getAge() < 6){
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-2);
                cat.setFedState(cat.getFedState()-4);
            }else if(cat.getAge() >= 6 && cat.getAge() < 10){
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-3);
                cat.setFedState(cat.getFedState()-6);
            }else{
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-4);
                cat.setFedState(cat.getFedState()-7);
            }
            System.out.printf("You accidentally hurt %s",cat.getName());
        }
        return cat;
    }

    @Override
    public Cat cureCat(Cat cat) {
        Random r = new Random();
        int random = r.nextInt(6) +1;
        if(random <= 3) {
            if (cat.getAge() < 6) {
                cat.setHealthState(cat.getHealthState() + 7);
                cat.setDelightState(cat.getDelightState() - 3);
                cat.setFedState(cat.getFedState() - 3);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setHealthState(cat.getHealthState() + 5);
                cat.setDelightState(cat.getDelightState() - 5);
                cat.setFedState(cat.getFedState() - 5);
            } else {
                cat.setHealthState(cat.getHealthState() + 4);
                cat.setDelightState(cat.getDelightState() - 6);
                cat.setFedState(cat.getFedState() - 6);
            }
            System.out.printf("You've taken care of %s, %d years old\n",cat.getName(),cat.getAge());
        }else {
            if (cat.getAge() < 6) {
                cat.setHealthState(cat.getHealthState() - 2);
                cat.setDelightState(cat.getDelightState() - 4);
                cat.setFedState(cat.getFedState() - 4);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setHealthState(cat.getHealthState() - 2);
                cat.setDelightState(cat.getDelightState() - 6);
                cat.setFedState(cat.getFedState() - 6);
            } else {
                cat.setHealthState(cat.getHealthState() - 2);
                cat.setDelightState(cat.getDelightState() - 6);
                cat.setFedState(cat.getFedState() - 6);
            }
            System.out.printf("Doctor has given wrong pills to %s accidentally",cat.getName());
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", fedState=" + fedState +
                ", delightState=" + delightState +
                ", healthState=" + healthState +
                ", functionState=" + functionState +
                ", averageState=" + averageState +
                '}';
    }
}
