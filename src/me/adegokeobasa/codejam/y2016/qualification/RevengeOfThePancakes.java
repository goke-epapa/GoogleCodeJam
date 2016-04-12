package me.adegokeobasa.codejam.y2016.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Adegoke Obasa <adegokeobasa@gmail.com>
 */
public class RevengeOfThePancakes {

    public static void main(String[] args) throws IOException {

        String filename = "/me/adegokeobasa/codejam/y2016/qualification/inputs/revenge_of_the_pancakes/B-small-attempt0.in";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RevengeOfThePancakes.class.getResourceAsStream(filename)));

        String line = bufferedReader.readLine();

        int inputLength = Integer.parseInt(line);
        for (int i = 0; i < inputLength; i++) {
            String pancakes = bufferedReader.readLine();

            int counter = 0;
            // All Happy
            if(isAllPancakesHappy(pancakes)) {
                System.out.println("Case #" + (i + 1) + ": " + counter);
                continue;
            }

            if(pancakes.length() == 1) {
                System.out.println("Case #" + (i + 1) + ": " + 1);
                continue;
            }

            while(!isAllPancakesHappy(pancakes)) {
                char firstChar = pancakes.charAt(0);
                pancakes = flip(pancakes, 0, lastIndexOfContinuousChar(pancakes, firstChar));
                counter++;
            }
            System.out.println("Case #" + (i + 1) + ": " + counter);
        }
        System.exit(0);
    }

    private static int lastIndexOfContinuousChar(String pancakes, char c) {
        for (int i = 0; i < pancakes.length(); i++) {
            if(c != pancakes.charAt(i))
                return i - 1;
        }
        return pancakes.length() - 1;
    }

    private static boolean isAllPancakesHappy(String pancakes) {
        for (int i = 0; i < pancakes.length(); i++) {
            if(pancakes.charAt(i) == '-')
                return false;
        }
        return pancakes.length() != 0;
    }

    private static String flip(String pancakes, int firstIndex, int lastIndex) {
        StringBuilder topPancakes = new StringBuilder();
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            char c = pancakes.charAt(i) == '-' ? '+' : '-';
            topPancakes.append(c);
        }
        topPancakes.reverse();

        if(lastIndex < pancakes.length() - 1) {
            return topPancakes + pancakes.substring(lastIndex + 1);
        }
        return topPancakes.toString();
    }
}
