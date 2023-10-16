import java.util.*;
import java.util.function.Function;

public class ModulVM3 {
    public static void main(String[] args) {
        int n = 8;   double a = 1;   double b = 3;
        double left=rectangleLeft(a,b,n);
        double right=rectangleRight(a,b,n);
        double center=rectangleCenter(a,b);
        double trapezoid=trapezoid(a,b,n);
        double SimpsonMethod=SimpsonMethod(a,b,n);
        System.out.println("Left\t\tRight\t\tCenter\t\tTrapezoid\tSimpson");
        //математические значения
        double leftMath=17.3125, rightMath=22.8125, centerMath=18, trapezoidMath=20.0625, simpsonMath=20;
        double[] MathArray={leftMath,rightMath, centerMath, trapezoidMath, simpsonMath};//[5]
        double[] programArray={left,right, center, trapezoid, SimpsonMethod};//[5]

        for(int index=0; index<5; index++){
            double result=programArray[index];
            System.out.print(result+"\t\t");
        }System.out.println("Результаты программы");

        for(int index=0; index<5; index++){
            double result=MathArray[index];
            System.out.print(result+"\t\t");
        }System.out.println("Результаты математических вычислений");


        for(int index=0; index<5; index++){
            double delta=delta(programArray[index], MathArray[index]);
            System.out.print(delta+"\t\t\t");
        }System.out.println("Абсолютная погрешность (delta)");

        for(int index=0; index<5; index++){
            double sigma=sigma(programArray[index], MathArray[index]);
            System.out.print(sigma+"\t\t\t");
        }System.out.println("Относительная погрешность (sigma)");
    }
    public static double delta(double at,double ap){
        double result=Math.abs(at-ap);
        return result;
    }
    public static double sigma(double at,double ap) {
        double result = delta(at,ap)/Math.abs(at);
        return result;
    }
    public static double function(double x){
        double y= 3 * Math.pow(x, 2) - x - 1;
        return y;
    }
    public static double rectangleLeft(double a, double b, int n){
        double h = (b - a) / n;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double x = a + i * h;
            sum += function(x) * h;
    }         return sum;   }
    public static double rectangleRight(double a, double b, int n){
        double h = (b - a) / n;
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double x = a + i * h;
            sum += function(x) * h;
        }         return sum;   }
    public static double rectangleCenter(double a, double b){
        double h = (b - a) ;
        double sum ;
        double c = (a + b)/2;
            sum = function(c) * h;
            return sum;   }
    public static double trapezoid(double a, double b, int n){
        double h = (b - a) / n;
        double sum = (function(a) + function(b)) / 2.0;
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += function(x);
        }

        double result = h * sum;
        return result;   }
    public static double SimpsonMethod(double a, double b, int n){
        double h = (b - a) / n;
        double x, sum1=0.0, sum2=0.0;
        for (int i=1; i<n; i+=2) {
            x = a + i*h;
            sum1 += function(x);
        }
        for (int i=2; i<n; i+=2) {
            x = a + i*h;
            sum2 += function(x);
        }
        double integral = (h/3.0)*(function(a)+ function(b) + 4.0*sum1 + 2.0*sum2 );
        return integral;   }
}
