package me.adegokeobasa.codejam.y2016.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author Adegoke Obasa <adegokeobasa@gmail.com>
 */
public class CountingSheep {

    public static void main(String[] args) throws IOException{

        String filename = "/me/adegokeobasa/codejam/y2016/qualification/inputs/counting_sheep/A-large.in";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(CountingSheep.class.getResourceAsStream(filename)));

        String line = bufferedReader.readLine();

        int inputLength = Integer.parseInt(line);

        for (int i = 0; i < inputLength; i++) {
            String N = bufferedReader.readLine();
            int intN = Integer.parseInt(N);

            HashSet<Character> foundDigits = new HashSet<>();
            int multiplier = 1;

            int changingIntN = intN;
            while (foundDigits.size() < 10) {
                for (int j = 0; j < N.length(); j++) {
                    foundDigits.add(N.charAt(j));
                }

                if(foundDigits.size() == 10) {
                    break;
                }
                changingIntN = ++multiplier * intN;
                N = String.valueOf(changingIntN);

                if(changingIntN == intN) {
                    break;
                }
            }
            if(changingIntN == intN) {
                System.out.println("Case #" + (i + 1) + ": INSOMNIA");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + N);
            }
        }
        System.exit(0);
    }
}
