package exceptionsSeminar3HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonView {
    public static String userInput() {
        String s = null;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            s = bf.readLine();
        } catch (IOException e) {
            System.out.println("Something happened while data had been inputted");
            e.printStackTrace();
        }
        return s;
    }
}
