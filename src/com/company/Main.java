package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UniformMethod obj;
        DichMethod obj1;
        double eps, pi = Math.PI, delta;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("f(x) = tg(x) - 2sin(x), [0, pi/4]");
            System.out.print("eps = ");
            eps = in.nextDouble();
            System.out.println("Метод равномерного поиска");
            for (int i = 3; i < 101; i++) {
                obj = new UniformMethod(i, eps, 0, pi / 4);
                obj.SearchSolution();
                obj.Print();
            }
            System.out.println("Метод дихотомии");
            do {
                System.out.println("delta дожно быть меньше eps");
                System.out.print("delta = ");
                delta = in.nextDouble();
            } while (delta >= eps);
            obj1 = new DichMethod(eps, delta, 0, pi / 4);
            obj1.SearchSol();
            obj1.Print();
        } while(in.nextInt() == 1);
    }
}
