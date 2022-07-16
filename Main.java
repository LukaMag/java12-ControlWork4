package ControlWork4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Lisa",5,35,50,85));
        cats.add(new Cat("Rose",8,55,35,65));
        cats.add(new Cat("Lord",13,65,45,10));
        for (Cat c:
             cats) {
            c.setFunctionState(true);
            c.countAverage(c);
        }
        cats.sort(Cat::countAverage);
        action(cats);
    }
    static void action(List<Cat> cats){
        Scanner sc = new Scanner(System.in);
        List<Cat> catsAlive = cats.stream().filter(e->e.getHealthState()>0).toList();
        while(true){
            try {
                printCats(catsAlive);
                System.out.println("n - to add new cat");
                System.out.println("c - to choose a cat, to do smth");
                System.out.println("d - to skip day");
                System.out.print("Choose an action:");
                String s = sc.nextLine();
                catsAlive =  commands(s,catsAlive);
                break;
            } catch (EmptyStackException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static List<Cat> commands(String s,List<Cat> catsAlive)throws EmptyStackException{
        List<Cat> cats = new ArrayList<>(catsAlive);
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
                        isCapableNumber(age,1, cats.size());
                        break;
                    } catch (OutOfMemoryError | NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                Cat cat = new Cat(name,age,r.nextInt(60) + 21,r.nextInt(60) + 21,r.nextInt(60) + 21);
                cats.add(cat);
                break;
            case "c":
                String command = "";
                String n = "";
                int index = 0;
                    while (true) {
                        try {
                            System.out.print("Enter index of cat:");
                            n = sc.nextLine();
                            isEmpty(n);
                            index = isNumber(n);
                            isCapableNumber(index,2, cats.size()+1);
                            break;
                        } catch (OutOfMemoryError | NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                while(true) {
                    try {
                        printCommands();
                        command = sc.nextLine();
                        isEmpty(command);
                        break;
                    }catch (OutOfMemoryError e){
                        System.out.println(e.getMessage());
                    }
                }
                cats.set(index-1, catsManipulation(cats.get(index-1), command));
            break;
            case "d":
                for (Cat c:cats) {
                    c.setHealthState(c.getHealthState() + r.nextInt(7)-3);
                    c.setDelightState(c.getDelightState() + r.nextInt(7)-3);
                    c.setFedState(c.getFedState() + r.nextInt(5) + 1);
                    c.setFunctionState(true);
                }
                System.out.println("You've skipped the day");
                break;
            default:
                System.out.println("Choose correct command");
                action(cats);
        }
        action(cats);
        return cats;
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
    static void isCapableNumber(int num,int occur,int cats)throws IndexOutOfBoundsException{
        if(occur == 1) {
            if (num < 1 || num > 18) {
                throw new IndexOutOfBoundsException("Cat's age has to be from 1 to 18!!!");
            }
        }else{
            if(num < 0 || num > cats){
                throw new IndexOutOfBoundsException("Choose correct index of Cat");
            }
        }
    }
    static void printCommands(){
        System.out.println("f - to feed a cat");
        System.out.println("p - to play with cat");
        System.out.println("t - to take care of cat");
        System.out.print("Choose action to do with cat:");
    }
    static Cat catsManipulation(Cat cat, String command){
            switch (command) {
                case "f":
                    if(cat.isFunctionState()) {
                        cat = cat.feedCat(cat);
                        cat.setFunctionState(false);
                    }else{
                        System.out.printf("You've fed a %s already today\n",cat.getName());
                    }
                   break;
                case "p":
                    if(cat.isFunctionState()) {
                        cat = cat.playWithCat(cat);
                        cat.setFunctionState(false);
                    }else{
                        System.out.printf("You've played with %s already today\n",cat.getName());
                    }
                    break;
                case "t":
                    if(cat.isFunctionState()){
                        cat = cat.cureCat(cat);
                        cat.setFunctionState(false);
                    }else{
                        System.out.printf("You've taken care of %s already today\n",cat.getName());
                    }

                    break;
                default:
                    System.out.println("Choose correct command!!!");
            }
            return cat;
    }
    static void printCats(List<Cat> cats){
        for (Cat c: cats) {
            c.setAverageState(c.countAverage(c));
        }
        var sorted = cats.stream().sorted(Comparator.comparing(Cat::getAverageState).reversed()).toList();
        System.out.println("---+-------+------+----------+-------+---------+---------------+---");
        System.out.println(" # | name  |  age | health   | mood  | feed K  |   average K   |");
        sorted.forEach(e -> System.out.printf(" %d | %s  |  %d   | %d       | %d    |  %d     |      %d       |\n",sorted.indexOf(e)+1,e.getName(),e.getAge(),e.getHealthState(),e.getDelightState(),e.getFedState(),e.getAverageState()));
        System.out.println("---+-------+------+----------+-------+---------+---------------+---");
    }
}
