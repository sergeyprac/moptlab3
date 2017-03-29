package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UniformMethod obj;
        DichMethod obj1;
        double eps, pi = Math.PI, delta, a = 0, b = pi/4;
        int n;
        Scanner in = new Scanner(System.in);
        do {
            do {
                System.out.println("f(x) = tg(x) - 2sin(x), [0, pi/4]");
                System.out.print("eps = ");
                eps = in.nextDouble();
                System.out.print("n = ");
                n = in.nextInt();
                System.out.println("Метод равномерного поиска");
                obj = new UniformMethod(n, eps, a, b);
                obj.SearchSolution();
                obj.Print();
            } while (in.nextInt() == 1);
            do {
                System.out.println("Метод дихотомии");
                System.out.print("delta = ");
                delta = in.nextDouble();
                obj1 = new DichMethod(eps, delta, a, b);
                obj1.SearchSol();
                obj1.Print();
            } while (in.nextInt() == 1);
        } while (in.nextInt() == 1);
    }
}
