package com.company;

import static com.company.Function.Get;
import static com.company.Function.func;

/**
 * Created by Сергей on 12.03.2017.
 */
public class DichMethod {
    private double eps, delta, a, b, funcX1, funcX2;
    DichMethod(double eps, double delta, double a, double b){
        this.eps = eps;
        this.delta = delta;
        this.a = a;
        this.b = b;
    }
    public void SearchSol(){
        double x1 = (a + b) / 2 - delta, x2 = (a + b) / 2 + delta;
        if((funcX1 = func(x1)) < (funcX2 = func(x2))){
            b = x2;
        } else if(funcX1 > funcX2){
            a = x1;
        } else {
            a = x1;
            b = x2;
        }
        if(b - a > eps){
            SearchSol();
        }
    }

    public void Print() {
        System.out.println("[" + a + ", " + b + "]; " + (funcX1 <= funcX2 ? funcX1 : funcX2) + "; " + Get());
    }
}
