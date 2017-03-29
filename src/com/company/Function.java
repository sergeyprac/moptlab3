package com.company;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;


public class Function {
    private static int cntFuncCalls = 0;
    public static double func(double x){
        cntFuncCalls++;
        //return x * sin(x) + 2 * cos(x);
        return tan(x) - 2 * sin(x);
    }
    public static int Get(){
        int x = cntFuncCalls;
        cntFuncCalls = 0;
        return x;
    }
}
