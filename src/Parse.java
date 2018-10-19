import java.util.List;

public class Parse {
    public static void deserializePoint(String inputStr, List<Point> list){
        int lenght=inputStr.length();
        inputStr=inputStr.trim();
        if (inputStr.charAt(0) == '{' && inputStr.charAt(lenght - 1) == '}') {
            inputStr = inputStr.substring(1, lenght - 1);
            inputStr=inputStr.trim();
            String[] points = inputStr.split(" ");
            for (String s:
                 points) {
                if(s.charAt(s.length()-1)==';')
                s=s.substring(0,s.length()-1);
                String[] cord=s.split(",");
                list.add(new Point(Double.valueOf(cord[0]),Double.valueOf(cord[1])));


            }
        }else
            System.out.println("Файл заполнен неверно");


    };
}
