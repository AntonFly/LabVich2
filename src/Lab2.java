import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Lab2 {
    public static ArrayList<Point> Pl= new ArrayList<Point>();
    public static void main(String[] args) {
        Lab2 lab2=new Lab2();
        read(Pl);
        Gui gui=new Gui();
        MathUnit mathUnit= new MathUnit();
        String out="";
        String space= "-------------------------------------------------------------------------------------\n";
        out+="linear: f = "+mathUnit.Line(Pl)+"\n"+"polinomialnaya f= "+mathUnit.quadratic(Pl)+"\n"+"EXP f = "+mathUnit.Exp(Pl)+"\n"+"LOG:"+mathUnit.Log(Pl)+"\n"+"POWERLAN: "+mathUnit.Power(Pl)+"\n";
//        System.out.println("linear: f = "+mathUnit.Line(Pl));
//        System.out.println("polinomialnaya f= "+mathUnit.quadratic(Pl));
//        System.out.println("EXP f = "+mathUnit.Exp(Pl));
//        System.out.println("LOG:"+mathUnit.Log(Pl));
//        System.out.println("POWERLAN: "+mathUnit.Power(Pl));
        out+="Вид F(x) | Линейная | Полиномиальная | Экспотенциальная | Логарифмическая | Степенная\n";
        out += space;
        for (int i=0;i<Pl.size();i++){
            Point p=Pl.get(i);
//            System.out.printf("%7.5f",MathUnit.getY(p.getX(),mathUnit.Line(Pl)));
//            System.out.printf("%16.5f",MathUnit.getY(p.getX(),mathUnit.quadratic(Pl)));
//            System.out.printf("%18.5f",MathUnit.getY(p.getX(),mathUnit.Exp(Pl)));
//            System.out.printf("%17.5f", MathUnit.getY(p.getX(),mathUnit.Log(Pl)));
//            System.out.printf("%15.5f",MathUnit.getY(p.getX(),mathUnit.Power(Pl)));
            out+=p.getX()+" "+p.getY()+"   "
                    +String.format("%7.5f",MathUnit.getY(p.getX(),mathUnit.Line(Pl)))
                    +String.format("%16.5f",MathUnit.getY(p.getX(),mathUnit.quadratic(Pl)))
                    +String.format("%18.5f",MathUnit.getY(p.getX(),mathUnit.Exp(Pl)))
                    +String.format("%17.5f", MathUnit.getY(p.getX(),mathUnit.Log(Pl)))
                    +String.format("%15.5f",MathUnit.getY(p.getX(),mathUnit.Power(Pl)))+"\n";
//            System.out.println();
        }
//        System.out.println();
//        System.out.print("   S       ");
//        System.out.printf("%7.5f",MathUnit.S(mathUnit.Line(Pl),Pl));
//        System.out.printf("%16.5f",MathUnit.S(mathUnit.quadratic(Pl),Pl));
//        System.out.printf("%18.5f",MathUnit.S(mathUnit.Exp(Pl),Pl));
//        System.out.printf("%17.5f", MathUnit.S(mathUnit.Log(Pl),Pl));
//        System.out.printf("%15.5f",MathUnit.S(mathUnit.Power(Pl),Pl));
        out += space;
        out+="   S       "+
                String.format("%7.5f",MathUnit.S(mathUnit.Line(Pl),Pl))+
                String.format("%16.5f",MathUnit.S(mathUnit.quadratic(Pl),Pl))+
                String.format("%18.5f",MathUnit.S(mathUnit.Exp(Pl),Pl))+
                String.format("%17.5f", MathUnit.S(mathUnit.Log(Pl),Pl))+
                String.format("%15.5f",MathUnit.S(mathUnit.Power(Pl),Pl))+
                "\n";


//        System.out.println();
//        System.out.print("   "+Character.toString((char)948)+"       ");
//        System.out.printf("%7.5f",MathUnit.middleQuadDeviation(mathUnit.Line(Pl),Pl));
//        System.out.printf("%16.5f",MathUnit.middleQuadDeviation(mathUnit.quadratic(Pl),Pl));
//        System.out.printf("%18.5f",MathUnit.middleQuadDeviation(mathUnit.Exp(Pl),Pl));
//        System.out.printf("%17.5f", MathUnit.middleQuadDeviation(mathUnit.Log(Pl),Pl));
//        System.out.printf("%15.5f",MathUnit.middleQuadDeviation(mathUnit.Power(Pl),Pl));
        out+=space;
        out+="   "+Character.toString((char)948)+"       "+
                String.format("%7.5f",MathUnit.middleQuadDeviation(mathUnit.Line(Pl),Pl))+
                String.format("%16.5f",MathUnit.middleQuadDeviation(mathUnit.quadratic(Pl),Pl))+
                String.format("%18.5f",MathUnit.middleQuadDeviation(mathUnit.Exp(Pl),Pl))+
                String.format("%17.5f", MathUnit.middleQuadDeviation(mathUnit.Log(Pl),Pl))+
                String.format("%15.5f",MathUnit.middleQuadDeviation(mathUnit.Power(Pl),Pl))+
                "\n";
        out+=space;
        out+="   a       "+
                String.format("%7.5f",MathUnit.koif[0][0])+
                String.format("%16.5f",MathUnit.koif[1][0])+
                String.format("%18.5f",MathUnit.koif[2][0])+
                String.format("%17.5f",MathUnit.koif[3][0])+
                String.format("%15.5f",MathUnit.koif[4][0])+
                "\n";
        out+=space;
        out+="   b       "+
                String.format("%7.5f",MathUnit.koif[0][1])+
                String.format("%16.5f",MathUnit.koif[1][1])+
                String.format("%18.5f",MathUnit.koif[2][1])+
                String.format("%17.5f",MathUnit.koif[3][1])+
                String.format("%15.5f",MathUnit.koif[4][1])+
                "\n";
        out+=space;
        out+="   c       "+
                String.format("%7.5f",MathUnit.koif[0][2])+
                String.format("%16.5f",MathUnit.koif[1][2])+
                String.format("%18.5f",MathUnit.koif[2][2])+
                String.format("%17.5f",MathUnit.koif[3][2])+
                String.format("%15.5f",MathUnit.koif[4][2])+
                "\n";
        out+=space;
        Double min =200000.;
        int imin=0;
        for (int i=0;i<MathUnit.sigm.size();i++) {
                if(MathUnit.sigm.get(i)<min){
                    min=MathUnit.sigm.get(i);
                    imin=i;
                }
        }
//        System.out.println();
//        System.out.println("\nНаилучшая аппроксимирующая функция:");
//        System.out.print("F(x)= ");
        out+="Наилучшая аппроксимирующая функция:\n"+
                "F(x)= ";

        switch (imin){
            case 0:
                out+=mathUnit.Line(Pl);
                break;
            case 1:
                out+=mathUnit.quadratic(Pl);
                break;
            case 2:
                out+=mathUnit.Exp(Pl);
                break;
            case 3:
                out+=mathUnit.Log(Pl);
                break;
            case 4:
                out+=mathUnit.Power(Pl);
                break;
        }
//        System.out.println(out);
        write(out);
    }

    public static void read(List<Point> list) {
        // System.out.println("1");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("inputPoints.txt"));

        String s1;
            while ((s1 = br.readLine()) != null) {
                Parse.deserializePoint(s1,list);

    }} catch (FileNotFoundException e) {
        e.printStackTrace();
    }



            /*catch (IOException e){
                System.out.println("Не удается найти указанный файл");
                System.exit(0);
            }*/
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println ("Smth wrong with XML format\n" +
                    "PlS, delete \"carriage return\" at the end and at the begining of the file!!!");
        }

    }
    public static  void write(String out){
        try
        {
            FileOutputStream fos=new FileOutputStream("Results.txt");
            byte[] buffer = out.getBytes();

            fos.write(buffer, 0, buffer.length);
            System.out.println("success");
        }
        catch (Exception ex){}
    }
}
