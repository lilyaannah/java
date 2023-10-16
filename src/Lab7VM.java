public class Lab7VM {
    public static void main(String[] args)
    {
        int a=-1, b=0; double e=0.1;
        double en, an=a, bn=b, x1n, x2n;
        int n=1; String word="", prim="";
        boolean cond=false;

        en=Math.pow(((Math.sqrt(5)-1)/2),n)*(b-a);

        x1n=a+((3-Math.sqrt(5))/2)*(b-a);
        x2n=a+((Math.sqrt(5)-1)/2)*(b-a);

        if(f(x1n)<=f(x2n)){ prim="a2=a1"; } else {  prim="b2=b1"; }

        if(en<e){ cond=true; word="en<e"; } else {cond=false; word="next";}
        System.out.println("n\ten\t\tan\t\tbn\t\tx1n\t\tx2n\t\tf(x1n)\tf(x2n)\tPrim.\tCond.");

        System.out.println(n+"\t"+Math.floor(en * 10000) / 10000 + "\t" +
                Math.floor(an * 10000) / 10000 + "\t" +
                Math.floor(bn * 10000) / 10000 + "\t\t" +
                Math.floor(x1n * 10000) / 10000 + "\t" +
                Math.floor(x2n * 10000) / 10000 + "\t" +
                Math.floor(f(x1n) * 10000) / 10000 + "\t" +
                Math.floor(f(x2n) * 10000) / 10000 + "\t" + prim+ "\t" + word);

        while(cond==false){
            n++;
            if(f(x1n)<=f(x2n)){  an=an;  bn=x2n; } else { an=x1n; bn=bn; }

            en=Math.pow(((Math.sqrt(5)-1)/2),n)*(bn-an);

            x1n=an+((3-Math.sqrt(5))/2)*(bn-an);
            x2n=an+((Math.sqrt(5)-1)/2)*(bn-an);

            if(f(x1n)<=f(x2n)){ prim="a2=a1"; } else { prim="b2=b1"; }

            if(en<e){ cond=true; word="en<e"; } else {cond=false; word="next";}
            System.out.println(n+"\t"+Math.floor(en * 10000) / 10000 + "\t" +
                    Math.floor(an * 10000) / 10000 + "\t" +
                    Math.floor(bn * 10000) / 10000 + "\t" +
                    Math.floor(x1n * 10000) / 10000 + "\t" +
                    Math.floor(x2n * 10000) / 10000 + "\t" +
                    Math.floor(f(x1n) * 10000) / 10000 + "\t" +
                    Math.floor(f(x2n) * 10000) / 10000 + "\t" + prim+ "\t" + word);
        }
    }
    public static double f(double x){
        return Math.pow(x,4)+2*Math.pow(x,2)+4*x+1;
    }
}
