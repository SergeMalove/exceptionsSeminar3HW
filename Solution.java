package exceptionsSeminar3HW;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите данные пользователя: ");
        String data = PersonView.userInput();
        PersonModel.writeData(PersonModel.createPeson(data));
    }
}
