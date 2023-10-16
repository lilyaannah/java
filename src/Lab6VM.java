import java.util.*;

public class Lab6VM
{
    public static void main(String[] args)
    {
        double a = 49;
        double b = 51;
        double e = 0.02;
        double  l, fa, fb, fa1, fb1, xn, pn1, fxn, dn, d2n, x1n, x2n, pn, fx1n , fx2n , max;

        if (fP(a) >= fP(b)) {
            max = fP(a);
        }
        else {
            max = fP(b);
        }
        l = Math.floor(max * 100) / 100;
        System.out.println("Im heree= "+l);
        fa =f(a);   fb =f(b);
        System.out.println("f(a)\tf(b)\te\t");
        System.out.println(Math.floor(fa * 10000) / 10000 + "\t" +
                Math.floor(fb * 10000) / 10000 +"\t" +e);
        System.out.println();
        System.out.println("f'(a)\tf'(b)\tmax\t\tl");
        System.out.println(Math.floor(fP(a) * 10000) / 10000 + "\t" +
                Math.floor(fP(b) * 10000) / 10000 + "\t" +
                Math.floor(max * 10000) / 10000 + "\t"+l);
        System.out.println();
        boolean cond=false;
        System.out.println("n\txn\t\tp*n\t\tf(xn)\tdn\t" +
                "\t2ldn\tx'n\t\tx''n\tpn\t\tf(x'n)\tf(x''n)\tCond.") ;

        int n=1;
        do {
            xn = (1 / (2 * l)) * (fa - fb + l * (a + b));
            pn1 = 0.5 * ((fa + fb) + (l * (a - b)));
            fxn = f(xn);
            dn = (1 / (2 * l)) * (fxn - pn1);
            d2n = 2 * l * dn;
            x1n = xn - dn;
            x2n = xn + dn;
            pn = 0.5 * (fxn + pn1);
            fx1n = f(x1n);
            fx2n = f(x2n);

            if (Math.abs(fx1n - fx2n) <= l * Math.abs(x1n - x2n)) {
                cond = true;
            } else {
                cond = false;
            }

            System.out.println(n + "\t" + Math.floor(xn * 10000) / 10000 + "\t" +
                    Math.floor(pn1 * 10000) / 10000 + "\t" +
                    Math.floor(fxn * 10000) / 10000 + "\t" +
                    Math.floor(dn * 10000) / 10000 + "\t" +
                    Math.floor(d2n * 10000) / 10000 + "\t" +
                    Math.floor(x1n * 10000) / 10000 + "\t" +
                    Math.floor(x2n * 10000) / 10000 + "\t" +
                    Math.floor(pn * 10000) / 10000 + "\t" +
                    Math.floor(fx1n * 10000) / 10000 + "\t" +
                    Math.floor(fx2n * 10000) / 10000 + "\t" + cond);

            if (x1n < x2n) {
                xn = x1n;
            } else {
                xn = x2n;
            }
            b = xn;
            fb = f(xn);
            n++;

        } while(Math.abs(fx1n - fx2n) > l*Math.abs(x1n-x2n)) ;
       }

        public static double f ( double x){
            return Math.pow((0.1 * x - 5), 8) + Math.cos(0.02 * x);
        }
    public static double fP ( double x){
        return 0.8*Math.pow((0.1 * x - 5), 7) - Math.sin(0.02 * x)*0.02;
    }
}