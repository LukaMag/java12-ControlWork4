package ControlWork4;

import java.util.Objects;

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
        this.functionState = true;
        this.averageState = (fedState+delightState+healthState)/3;
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

    @Override
    public void feedCat(Cat cat) {

    }

    @Override
    public void playWithCat(Cat cat) {

    }

    @Override
    public void cureCat(Cat cat) {

    }
}
