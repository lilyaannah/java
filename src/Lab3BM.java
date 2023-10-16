import java.util.*;
public class Lab3BM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите a= "); double a= in.nextDouble();
        System.out.print("Введите b= "); double b= in.nextDouble();
        System.out.print("Введите e= "); double e= in.nextDouble(), x0;
        double x;
        if(fP(a)*fPP(a)>0 && fP(b)*fPP(b)>0){
            x0=a;
            x=x0-((f(x0))*(b-x0))/(f(b)-f(x0));
        } else {
            x0=b;
            x=x0-((f(x0))*(x0-a))/(f(x0)-f(a));
        }
        System.out.println("--------------------------------------------");
        System.out.println("\tx\t\tf(x)\tf'(x)\tf''(x)\tCond.1");
        System.out.println("a\t"+a+"\t\t"+f(a)+"\t"+fP(a)+"\t\t"+fPP(a)+"\t"+x0);
        System.out.println("b\t"+b+"\t\t"+f(b)+"\t"+fP(b)+"\t"+fPP(b)+"\t"+x0);
        System.out.println("--------------------------------------------");
        int i=1;
        System.out.println("№\tx0\t\t\tf(x0)\t\tf'(x)\t\tx1\t\tCond.2");
        System.out.println(i+"\t"+Math.floor(x0*10000)/10000+"\t\t\t"+Math.floor(f(x0)*10000)/10000
                +"\t\t"+Math.floor(fP(x0)*10000)/10000+"\t\t\t"+Math.floor(x*10000)/10000+"\t"+"false");
        while (Math.abs((x0-x))>e){
            x0=x;
            if(fP(a)*fPP(a)>0 && fP(b)*fPP(b)>0){
                x=x0-((f(x0))*(b-x0))/(f(b)-f(x0));
            } else{
                x=x0-((f(x0))*(x0-a))/(f(x0)-f(a));
            }
            i++;
            System.out.println(i+"\t"+Math.floor(x0*10000)/10000+"\t\t"+Math.floor(f(x0)*10000)/10000
                    +"\t\t"+Math.floor(fP(x0)*10000)/10000+"\t\t"+Math.floor(x*10000)/10000+"\t"+"false");
        }
        System.out.println(i+"\t"+Math.floor(x0*10000)/10000+"\t\t"+Math.floor(f(x0)*10000)/10000
                +"\t\t"+Math.floor(fP(x0)*10000)/10000+"\t\t"+Math.floor(x*10000)/10000+"\t"+"true");
    }
    public static double f(double x){
        double y=Math.pow(x,4)+2*Math.pow(x,2)-6*x+2; return y;
    }
    public static double fP(double x){
        double y=4*Math.pow(x,3)+4*x-6;  return y;
    }
    public static double fPP(double x){
        double y=12*Math.pow(x,2)+4;  return y;
    }
}
