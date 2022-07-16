package ControlWork4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(0,new Cat("Lisa",5,35,50,85));
        cats.add(1,new Cat("Lord",13,65,45,35));
        cats.add(2,new Cat("Rose",8,55,35,65));


        printCats(cats);
    }
    static void  action(List<Cat> cats){
        Scanner sc = new Scanner(System.in);
        
    }
    static void printCats(List<Cat> cats){
        var sorted = cats.stream().sorted(Comparator.comparing(Cat::getAverageState).reversed()).toList();
        System.out.println("---+-------+------+----------+-------+---------+---------------+---");
        System.out.println(" # | name  |  age | health   | mood  | feed K  |   average K   |");
        sorted.forEach(e -> System.out.printf(" %d | %s  |  %d   | %d       | %d    |  %d     |      %d       |\n",sorted.indexOf(e)+1,e.getName(),e.getAge(),e.getHealthState(),e.getDelightState(),e.getFedState(),e.getAverageState()));
        System.out.println("---+-------+------+----------+-------+---------+---------------+---");
    }
}
