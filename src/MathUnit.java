import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

import java.util.ArrayList;
import java.util.List;

public class MathUnit {
    public static ArrayList<Double> sigm= new ArrayList<>();
    public static Double[][] koif= new Double[5][3];
    public String Line(List<Point> list){
        int n=list.size();
        Double SX=.0;
        Double SXX=.0;
        Double SY=.0;
        Double SXY=.0;
        for (Point p:
             list) {
            double x=p.getX();
            double y=p.getY();
            SX=SX+x;
            SXX=SXX+x*x;
            SY=SY+y;
            SXY=SXY+x*y;

        }
        double a=(SXY*n-SX*SY)/(SXX*n-SX*SX);
        double b=(SXX*SY-SX*SXY)/(SXX*n-SX*SX);
        koif[0][0]=a;
        koif[0][1]=b;
        koif[0][2]=.0;
        return a+" * x + "+b;
    }
    public String Exp(List<Point> list){
        int n=list.size();
        Double SX=.0;
        Double SXX=.0;
        Double SY=.0;
        Double SXY=.0;
        for (Point p:
                list) {
            double x=p.getX();
            double y=Math.log(p.getY());
            SX=SX+x;
            SXX=SXX+x*x;
            SY=SY+y;
            SXY=SXY+x*y;

        }
        double b=(SXY*n-SX*SY)/(SXX*n-SX*SX);
        double a=(SXX*SY-SX*SXY)/(SXX*n-SX*SX);
        koif[2][0]=a;
        koif[2][1]=b;
        koif[2][2]=.0;
        return Math.pow(Math.exp(1),a)+" *e^(x*"+b+")";
    }
    public String Log(List<Point> list){
        int n=list.size();
        Double SX=.0;
        Double SXX=.0;
        Double SY=.0;
        Double SXY=.0;
        for (Point p:
                list) {
            double x=Math.log(p.getX());
            double y=p.getY();
            SX=SX+x;
            SXX=SXX+x*x;
            SY=SY+y;
            SXY=SXY+x*y;

        }
        double b=(SXY*n-SX*SY)/(SXX*n-SX*SX);
        double a=(SXX*SY-SX*SXY)/(SXX*n-SX*SX);
        koif[3][0]=a;
        koif[3][1]=b;
        koif[3][2]=.0;
        return b+" *ln(x) +"+a;
    }
    public String Power(List<Point> list){
        int n=list.size();
        Double SX=.0;
        Double SXX=.0;
        Double SY=.0;
        Double SXY=.0;
        for (Point p:
                list) {
            double x=Math.log(p.getX());
            double y=Math.log(p.getY());

            SX=SX+x;
            SXX=SXX+x*x;
            SY=SY+y;
            SXY=SXY+x*y;

        }
        double b=(SXY*n-SX*SY)/(SXX*n-SX*SX);
        double a=(SXX*SY-SX*SXY)/(SXX*n-SX*SX);
        koif[4][0]=a;
        koif[4][1]=b;
        koif[4][2]=.0;
        return Math.pow(Math.exp(1),a)+" * x^ "+b;
    }
    public String  quadratic(List<Point> dots)
    {
        int n = dots.size();
        double sx, sxq, sxt, sxf, sy, xy, xxy;
        sx = 0; sxq = 0; sxt = 0; sxf = 0; sy = 0; xy = 0; xxy = 0;

        for (Point p: dots) {
            double x = p.getX();
            double y = p.getY();
            sx += x;
            sxq += Math.pow(x,2);
            sxt += Math.pow(x,3);
            sxf += Math.pow(x,4);
            sy += y;
            xy += x*y;
            xxy += Math.pow(x,2)*y;
        }

        double[][] matrix = {
                {n,sx,sxq,sy},
                {sx,sxq,sxt,xy},
                {sxq,sxt,sxf,xxy}

        };
        GaussMatrix mat = new GaussMatrix(matrix);
        mat.triangleMatrix();
        double[] roots = mat.roots();
        koif[1][0]=roots[2];
        koif[1][1]=roots[1];
        koif[1][2]=roots[0];
        return roots[2]+" * x^2 + "+roots[1]+" * x + "+roots[0];
    }
    public static double middleQuadDeviation(String func ,List<Point> dots) //среднекфадратичное отклонение
    {
        double res = 0;
        for(Point d: dots)
        {
            res += Math.pow(getY(d.getX(),func) - d.getY(),2);
        }
        double ret = Math.sqrt(res/dots.size());
        sigm.add(ret);
        return ret;
    }
    public static double getY(double i,String str){

        Function f = new Function("F(x) = " + str);
        Argument x = new Argument("x = "+i);
        Expression e = new Expression("F(x)",f,x);
        return e.calculate();
    }

    public static double S(String func ,List<Point> dots) //среднекфадратичное отклонение
    {
        double res = 0;
        for(Point d: dots)
        {
            res += Math.pow(getY(d.getX(),func) - d.getY(),2);
        }
        return res;
    }


}
