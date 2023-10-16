import java.util.*;

public class derivatives1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input choice: ");
        int choice = in.nextInt();
        switch(choice){
            case 1:System.out.print("Input x: ");   double x5 = in.nextDouble();
                   System.out.print("Input h: ");   double h5 = in.nextDouble();

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
                break;
            case 2: System.out.print("Input x: ");   double x7 = in.nextDouble();
                    System.out.print("Input h: ");   double h7 = in.nextDouble();

     double fx7=y7(x7);                          double fxhMinus7=y7((x7-h7));          double fxhPlus7=y7((x7+h7));
     double resL7=fPl(fx7, fxhMinus7, h7);       double resR7=fPr(fx7, fxhPlus7, h7);   double resC7=fPc(fxhPlus7, fxhMinus7, h7);
     double fPP7=fPP(fxhPlus7, fxhMinus7,h7,fx7); double y7PPmath=y7PPmath(x7);          double y7math=y7math(x7);
     double deltaL7= delta(y7math, resL7);       double deltaR7= delta(y7math, resR7);  double deltaC7= delta(y7math, resC7);
     double sigmaL7=sigma(y7math, resL7);        double sigmaR7=sigma(y7math, resR7);   double sigmaC7=sigma(y7math, resC7);
     double delta7= delta(y7PPmath, fPP7);        double sigma7=sigma(y7PPmath, fPP7),  resPP7=fPP(fxhPlus7,fxhMinus7,h7, fx7);
                double resMathPP7=y7PPmath(x7) ;

                System.out.println("Fmath= "+y7math);
                ansShowres(resL7,resR7,resC7, resPP7, resMathPP7);
                ansShowdelta(deltaL7,deltaR7,deltaC7,delta7);
                ansShowsigma(sigmaL7,sigmaR7,sigmaC7,sigma7);
                break;
            case 3:
                System.out.print("Input x: ");   double x11 = in.nextDouble();
                System.out.print("Input h: ");   double h11 = in.nextDouble();

                double fx11=y11(x11);                          double fxhMinus11=y11((x11-h11));          double fxhPlus11=y11((x11+h11));
                double resL11=fPl(fx11, fxhMinus11, h11);       double resR11=fPr(fx11, fxhPlus11, h11);   double resC11=fPc(fxhPlus11, fxhMinus11, h11);
                double fPP11=fPP(fxhPlus11, fxhMinus11,h11,fx11); double y11PPmath=y11PPmath(x11);          double y11math=y11math(x11);
                double deltaL11= delta(y11math, resL11);       double deltaR11= delta(y11math, resR11);  double deltaC11= delta(y11math, resC11);
                double sigmaL11=sigma(y11math, resL11);        double sigmaR11=sigma(y11math, resR11);   double sigmaC11=sigma(y11math, resC11);
                double delta11= delta(y11PPmath, fPP11);        double sigma11=sigma(y11PPmath, fPP11),   resPP11=fPP(fxhPlus11,fxhMinus11,h11, fx11);
                double resMathPP11=y11PPmath(x11) ;

                System.out.println("Fmath= "+y11math);
                ansShowres(resL11,resR11,resC11,resPP11, resMathPP11);
                ansShowdelta(deltaL11,deltaR11,deltaC11,delta11);
                ansShowsigma(sigmaL11,sigmaR11,sigmaC11,sigma11);
                break;
            case 4:
                System.out.print("Input x: ");   double x12 = in.nextDouble();
                System.out.print("Input h: ");   double h12 = in.nextDouble();

                double fx12=y12(x12);                          double fxhMinus12=y12((x12-h12));          double fxhPlus12=y12((x12+h12));
                double resL12=fPl(fx12, fxhMinus12, h12);       double resR12=fPr(fx12, fxhPlus12, h12);   double resC12=fPc(fxhPlus12, fxhMinus12, h12);
                double fPP12=fPP(fxhPlus12, fxhMinus12,h12,fx12); double y12PPmath=y12PPmath(x12);          double y12math=y12math(x12);
                double deltaL12= delta(y12math, resL12);       double deltaR12= delta(y12math, resR12);  double deltaC12= delta(y12math, resC12);
                double sigmaL12=sigma(y12math, resL12);        double sigmaR12=sigma(y12math, resR12);   double sigmaC12=sigma(y12math, resC12);
                double delta12= delta(y12PPmath, fPP12);        double sigma12=sigma(y12PPmath, fPP12),  resPP12=fPP(fxhPlus12,fxhMinus12,h12, fx12);
                double resMathPP12=y12PPmath(x12) ;

                System.out.println("Fmath= "+y12math);
                ansShowres(resL12,resR12,resC12,resPP12, resMathPP12);
                ansShowdelta(deltaL12,deltaR12,deltaC12,delta12);
                ansShowsigma(sigmaL12,sigmaR12,sigmaC12,sigma12);
            default:
                System.out.println("error"); }
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
        double a=1+Math.pow(x,2), b=2*Math.sqrt(1+2*Math.pow(x,2));
        double ap=2*x, bp=(4*x)/Math.sqrt(1+2*Math.pow(x,2));
        double y=(ap*b-a*bp)/Math.pow(b,2);
        return y;
    }
    public static double y5PPmath(double x){
        double a=3*Math.pow(x,3), b=Math.sqrt(Math.pow((1+2*Math.pow(x,2)),3));
        double ap=9*Math.pow(x,2), bp=(4*x*(1+2*Math.pow(x,2)))/Math.sqrt(Math.pow((1+2*Math.pow(x,2)),3));
        double y=(ap*b-a*bp)/Math.pow(b,2);
        return y;
    }

    public static double y7(double x){
        double y=Math.log(Math.sin((2*x+4)/(x+1)));
        return y;
    }
    public static double y7math(double x){
        double a=2*Math.cos((2*x)/(x+1)+4/(x+1)), b=Math.pow(x,2)+2*x+1, c=Math.sin((2*x)/(x+1)+4/(x+1));
        double y=-(a/(b*c));
        return y;
    }
    public static double y7PPmath(double x){
        double sin=Math.sin((2*x)/(x+1)+4/(x+1)), cos=Math.cos((2*x)/(x+1)+4/(x+1)), poly=Math.pow(x,4)+4*Math.pow(x,3)+6*Math.pow(x,2)+4*x+1;
        double y=((4*x+4)*cos*sin-4*Math.pow(cos,2))/(poly*Math.pow(sin,2))-4/poly;
        return y;
    }
    public static double y11(double x){
        double y=Math.pow((Math.pow(x,3)+4),Math.tan(x));
        return y;
    }
    public static double y11math(double x){
        double x34=Math.pow(x,3)+4, tg=Math.tan(x), cos2=Math.pow(Math.cos(x),2), ln=Math.log(x34);
        double y=(Math.pow(x34,tg+1)*ln+3*Math.pow(x,2)*Math.pow(x34,tg)*cos2*tg)/(x34*cos2);
        return y;
    }
    public static double y11PPmath(double x){
        double x34=Math.pow(x,3)+4, tg=Math.tan(x), tgPow=Math.pow(x34,tg), ln2=Math.pow(Math.log(x34),2),
                cos=Math.cos(x), cos2=Math.pow(cos,2), sin=Math.sin(x), ln=Math.log(x34),
                cos4=Math.pow(cos,4), x6=Math.pow(x,6)+8*Math.pow(x,3)+16, x6_24=6*Math.pow(x,5)+24*Math.pow(x,2);
        double y=(tgPow*x6*ln2+(tgPow*x6_24*cos2*tg+tgPow*(2*Math.pow(x,6)
                +16* Math.pow(x,3)+32)*cos*sin)*
                ln+9*Math.pow(x,4)*tgPow*cos4*Math.pow(tg,2)+
                tgPow*(24*x-3*Math.pow(x,4))*cos4*tg+tgPow*x6_24*cos2)/(x6*cos4);
        return y;
    }
    public static double y12(double x){
        double e=2.72;
        double y=(5*x)-Math.log10(1+Math.sqrt(1-Math.pow(e,10*x)))
                -Math.pow(e,-5*x)*Math.asin(Math.pow(e,5*x));
        return y;
    }
//    public static double y12math(double x){
//        double e=2.72, ePowMinus=Math.pow(e,-5*x), ePow=Math.pow(e,5*x);
//        double y=ePowMinus*(5*Math.asin(ePow)-5*ePow)+5;
//        return y;
//    }
//    public static double y12PPmath(double x){
//        double e=2.72,ePowMinus=Math.pow(e,-5*x), ePow=Math.pow(e,5*x), sqrt=Math.sqrt(1-Math.pow(e,10*x));
//        double y=-((ePowMinus*(25*sqrt*Math.asin(ePow)-25*ePow))/sqrt);
//        return y;
//    }
public static double y12math(double x){
    double e=2.72,pow10x=Math.pow(e,10*x),
            second=(5*(-(pow10x/Math.sqrt(1-pow10x))))/(1+Math.sqrt(1-pow10x)),
            third=5*(-Math.pow(e,-5*x)*Math.asin(Math.pow(e,5*x))+1/Math.sqrt(1-Math.pow(e,10*x)));
    double y=5-second-third;
    return y;
}
    public static double y12PPmath(double x){
        double e=2.72, pow10x=Math.pow(e,10*x), secondA=5*(-(pow10x/Math.sqrt(1-pow10x))),
                secondAp=-5*(10*(pow10x/Math.sqrt(1-pow10x))+Math.pow(e,20*x)/Math.pow(1-pow10x,3/2)),
                secondB=(1+Math.sqrt(1-pow10x)), secondBp=5*(-(pow10x/Math.sqrt(1-pow10x))),
                thirdAp=5*Math.pow(e,-5*x)*Math.asin(Math.pow(e,5*x))-1/(Math.sqrt(1-pow10x)),
                thirdBp=Math.pow(e,10)/(2*Math.pow(1-Math.pow(e,10),3/2));
        double a=(secondAp*secondB-secondA*secondBp)/Math.pow(secondB,2),
                b=5*thirdAp+thirdBp, y=a-b;
        return y;
    }

}
