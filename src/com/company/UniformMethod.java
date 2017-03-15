package com.company;

import static com.company.Function.Get;
import static com.company.Function.func;

/**
 * Created by Сергей on 12.03.2017.
 */
public class UniformMethod {
    private double minF, eps, minX, maxX;
    private double[] point, funcRes;
    private int n;

    UniformMethod(int n, double eps, double a, double b) {
        this.n = n;
        this.eps = eps;
        point = new double[n + 1];
        funcRes = new double[n + 1];
        point[0] = a;
        funcRes[0] = func(a);
        point[n] = b;
        funcRes[n] = func(b);
    }

    public void SearchSolution() {
        double step = (point[n] - point[0]) / n;
        int numMin = 0, pred, next;
        point[1] = point[0] + step;
        funcRes[1] = func(point[0]);
        do {
            numMin++;
            if(numMin != n - 1) {
                point[numMin + 1] = point[numMin] + step;
                funcRes[numMin + 1] = func(point[numMin + 1]);
            }
        } while (!(funcRes[numMin] < funcRes[numMin - 1] && funcRes[numMin] < funcRes[numMin + 1]) && numMin < n - 1);
        /*for (int i = 1; i < n; i++) {
            point[i] = point[i - 1] + step;
            funcRes[i] = func(point[i]);
            if(funcRes[i] < funcRes[numMin]){
                numMin = i;
            }
        }*/
        if (funcRes[n] < funcRes[numMin]) {
            numMin = n;
        }
        if(funcRes[0] < funcRes[numMin]){
            numMin = 0;
        }
        if (numMin == 0) {
            pred = 0;
            next = 1;
        } else if (numMin == n) {
            next = n;
            pred = n - 1;
        } else {
            pred = numMin - 1;
            next = numMin + 1;
        }
        if (point[next] - point[pred] > eps) {
            point[0] = point[pred];
            point[n] = point[next];
            funcRes[0] = funcRes[pred];
            funcRes[n] = funcRes[next];
            SearchSolution();
        } else {
            minX = point[pred];
            maxX = point[next];
            minF = funcRes[numMin];
        }
    }

    public void Print() {
        System.out.println("n = " + n + ": " + "[" + minX + ", " + maxX + "]; " + minF + "; " + Get());
    }
}
