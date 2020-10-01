package opg7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ex2 {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dis.students.dk/example3.php");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write("year=2009&month=august");
            wr.flush();

            // Get an InputStream with conn.getInputStream()
            // and read the response like in exercise 1 ...

            InputStreamReader r = new InputStreamReader(conn.getInputStream());
            BufferedReader in = new BufferedReader(r);
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
            wr.close();

            System.out.println();

            Map map = conn.getHeaderFields();
            Set set = map.entrySet();

            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
