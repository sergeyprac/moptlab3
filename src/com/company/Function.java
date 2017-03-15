package com.company;

import static java.lang.Math.sin;
import static java.lang.Math.tan;


public class Function {
    private static int cntFuncCalls;
    public static double func(double x){
        cntFuncCalls++;
        return tan(x) - 2 * sin(x);
    }
    public static int Get(){
        int x = cntFuncCalls;
        cntFuncCalls = 0;
        return x;
    }
}
