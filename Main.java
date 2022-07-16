package ControlWork4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(0,new Cat("Lisa",5,35,50,85));
        cats.add(1,new Cat("Lord",13,65,45,35));
        cats.add(2,new Cat("Rose",8,55,35,65));

        action(cats);
    }
    static void  action(List<Cat> cats){
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                printCats(cats);
                System.out.println("n - to add new cat");
                System.out.println("c - to choose a cat, to do smth");
                String s = sc.nextLine();
                commands(s,cats);
                break;
            } catch (EmptyStackException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void printCats(List<Cat> cats){
        var sorted = cats.stream().sorted(Comparator.comparing(Cat::getAverageState).reversed()).toList();
        System.out.println("---+-------+------+----------+-------+---------+---------------+---");
        System.out.println(" # | name  |  age | health   | mood  | feed K  |   average K   |");
        sorted.forEach(e -> System.out.printf(" %d | %s  |  %d   | %d       | %d    |  %d     |      %d       |\n",sorted.indexOf(e)+1,e.getName(),e.getAge(),e.getHealthState(),e.getDelightState(),e.getFedState(),e.getAverageState()));
        System.out.println("---+-------+------+----------+-------+---------+---------------+---");
    }
    static void commands(String s,List<Cat> cats)throws EmptyStackException{
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String name = "";
        int age = 0;
        switch (s){
            case "n":
                while(true) {
                    try {
                        System.out.print("Enter name of cat:");
                        name = sc.nextLine();
                        isEmpty(name);
                        System.out.print("\nEnter age of cat:");
                        String a = sc.nextLine();
                        isEmpty(a);
                        age = isNumber(a);
                        isCapableNumber(age);
                        break;
                    } catch (OutOfMemoryError | NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                Cat cat = new Cat(name,age,r.nextInt(60) + 21,r.nextInt(60) + 21,r.nextInt(60) + 21);
                cats.add(cat);
                break;
            default:
                action(cats);

        }
        printCats(cats);
    }
    static void isEmpty(String s)throws OutOfMemoryError {
        if(s.isEmpty()){
            throw new OutOfMemoryError("It can not be empty!!!");
        }
    }
    static int isNumber(String s)throws NumberFormatException{
        int num = 0;
        try{
            num = Integer.parseInt(s);
            return num;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It has to number!!!");
        }
    }
    static void isCapableNumber(int num)throws IndexOutOfBoundsException{
        if(num < 1 || num > 18){
            throw new IndexOutOfBoundsException("Cat's age has to be from 1 to 18!!!");
        }
    }
}
