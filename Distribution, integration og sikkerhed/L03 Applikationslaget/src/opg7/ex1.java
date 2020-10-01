package opg7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class ex1 {

    public static void main(String[] args) {
//        try {
//            URL url = new URL("https://dis.students.dk/example1.php");
//            InputStreamReader r = new InputStreamReader(url.openStream());
//            BufferedReader in = new BufferedReader(r);
//            String str;
//            int timesSeen = -1;
//            while ((str = in.readLine()) != null) {
//                System.out.println(str);
//                if (str.split(" ")[0].equals("This") && str.split(" ")[4].equals("seen"))
//                    timesSeen = Integer.parseInt(str.split(" ")[5]);
//            }
//            System.out.println(timesSeen);
//            in.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            URL url = new URL("https://m.valutakurser.dk/");
            InputStreamReader r = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(r);
            String str;
            double exchangeRate = -1d;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
//                if (str.trim().matches("<div id=\"exchangerateUSD\" class=\"item-row-white clearfix\" data-currency=\"USD\" data-exchangerate=\"\\d+.\\d+\">"))
                if (str.trim().contains("exchangerateUSD"))
                    exchangeRate = Double.parseDouble(str.split("\"")[7]);
            }
            System.out.println(exchangeRate);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
