package contest.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class PaytmCodeJam {

    /**
     * Compiler version
     * @param args
     * @throws Exception
     */
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ;

        while ((line = br.readLine()) != null) {

            String tail = "";
            if (line.contains("//")) {
                int pos = line.indexOf("//");
                tail = line.substring(pos);
                line = line.substring(0, pos);
            }
            line = line.replaceAll("->", ".");
            System.out.println(line + tail);
        }
    }
}