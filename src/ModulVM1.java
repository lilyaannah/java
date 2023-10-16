import java.util.*;
public class ModulVM1 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input x: ");
    double x5 = in.nextDouble();
    System.out.print("Input h: ");
    double h5 = in.nextDouble();
    double fx5=y5(x5),                           fxhMinus5=y5((x5-h5)),         fxhPlus5=y5((x5+h5));
    double resL5=fPl(fx5, fxhMinus5, h5),        resR5=fPr(fx5, fxhPlus5, h5),  resC5=fPc(fxhPlus5, fxhMinus5, h5);
    double fPP5=fPP(fxhPlus5, fxhMinus5,h5,fx5), y5PPmath=y5PPmath(x5),         y5math=y5math(x5);
    double deltaL5= delta(y5math, resL5),        deltaR5= delta(y5math, resR5), deltaC5= delta(y5math, resC5);
    double sigmaL5=sigma(y5math, resL5),         sigmaR5=sigma(y5math, resR5),  sigmaC5=sigma(y5math, resC5);
    double delta5= delta(y5PPmath, fPP5),        sigma5=sigma(y5PPmath, fPP5),  resPP5=fPP(fxhPlus5,fxhMinus5,h5, fx5);
    double resMathPP5=y5PPmath(x5) ;

                System.out.println("Fmath= "+y5math);
    ansShowres(resL5,resR5,resC5, resPP5, resMathPP5);
    ansShowdelta(deltaL5,deltaR5,deltaC5,delta5);
    ansShowsigma(sigmaL5,sigmaR5,sigmaC5,sigma5);
}
    public static double ansShowsigma(double sigmaL,double sigmaR,double sigmaC,double sigma){
        System.out.println("Sigma(x)L= " + sigmaL);
        System.out.println("Sigma(x)R= " + sigmaR);
        System.out.println("Sigma(x)C= " + sigmaC);
        System.out.println("Sigma(fpp)= " + sigma);
        return 0;
    }
    public static double ansShowdelta(double deltaL,double deltaR,double deltaC,double delta){
        System.out.println("Delta(x)L="+deltaL);
        System.out.println("Delta(x)R="+deltaR);
        System.out.println("Delta(x)C="+deltaC);
        System.out.println("Delta(fpp)="+delta);
        return 0;
    }
    public static double ansShowres(double resL,double resR,double resC, double resPP, double resMathPP){
        System.out.println("FpL= "+resL);
        System.out.println("FpR= "+resR);
        System.out.println("FpC= "+resC);
        System.out.println("MathPP= "+resMathPP);
        System.out.println("FPP= "+resPP);
        return 0;
    }
    public static double delta(double at,double ap){
        double result=Math.abs(at-ap);
        return result;
    }
    public static double sigma(double at,double ap) {
        double result = delta(at,ap)/Math.abs(at);
        return result;
    }
    public static double fPl(double fx, double fxhMinus, double h){
        double f=(fx-fxhMinus)/h;
        return f;
    }

    public static double fPr(double fx, double fxhPlus, double h){
        double f=(fxhPlus-fx)/h;
        return f;
    }

    public static double fPc(double fxhPlus, double fxhMinus, double h){
        double f=(fxhPlus-fxhMinus)/(2*h);
        return f;
    }

    public static double fPP(double fxhPlus, double fxhMinus, double h, double fx){
        double f=(fxhPlus-2*fx+fxhMinus)/Math.pow(h,2);
        return f;
    }

    public static double y5(double x){
        double y=(1+Math.pow(x,2))/(2*Math.sqrt(1+2*Math.pow(x,2)));
        return y;
    }
    public static double y5math(double x){
//        double a=1+Math.pow(x,2), b=2*Math.sqrt(1+2*Math.pow(x,2));
//        double ap=2*x, bp=(4*x)/Math.sqrt(1+2*Math.pow(x,2));
//        double y=(ap*b-a*bp)/Math.pow(b,2);
        double a=1+Math.pow(x,2), b=2*Math.sqrt(1+2*Math.pow(x,2));
        double ap=2*x, bp=(4*x)/Math.sqrt(1+2*Math.pow(x,2));
        double y=(ap*b-a*bp)/Math.pow(b,2);
        //double y=(x*(Math.sqrt(1+2*Math.pow(x,2))-Math.sqrt(Math.pow(1+2*Math.pow(x,2),3))))/(1+2*Math.pow(x,2));
        return y;
    }
    public static double y5PPmath(double x){
        double a=3*Math.pow(x,3), b=Math.sqrt(Math.pow((1+2*Math.pow(x,2)),3));
        double ap=9*Math.pow(x,2), bp=(4*x*(1+2*Math.pow(x,2)))/Math.sqrt(Math.pow((1+2*Math.pow(x,2)),3));
        double y=(ap*b-a*bp)/Math.pow(b,2);
        return y;
    }
    //первое задание
}

