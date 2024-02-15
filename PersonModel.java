package exceptionsSeminar3HW;

import java.io.FileWriter;
import java.io.IOException;

public class PersonModel {
    private Person person;

    public PersonModel(Person person) {
        this.person = person;
    }

    public static long dataQuantityCheck(String[] data) {
        if (data.length < 6) {
            System.out.println("Неправильный ввод данных. Количество введенных данных меньше 6ти");
            return -1;
        } else if (data.length > 6){
            System.out.println("Неправильный ввод данных. Количество введенных данных больше 6ти");
            return -2;
        }
        return 0;
    }

    public static String getName(String name) {
        if (!name.matches("[A-ZА-Я][a-zа-я]*")) {
            throw new IllegalArgumentException("Неправильный ввод данных ФИО");
        }
        return name;
    }

    public static String getBirthDate(String date) {
        if (!date.matches("(0?0[1-9]|[12][0-9]|3[01]).(0?0[1-9]|1[012]).(19|20)\\d\\d")) {
            throw new IllegalArgumentException("Неправильный ввод даты роджения");
        }
        return date;
    }

    public static long getPhoneNum(String phoneNum) {
        if (phoneNum.length() < 19 && !phoneNum.matches("\\d*")) {
            throw new IllegalArgumentException("Неправильный ввод телефонного номера");
        }
        return Long.parseLong(phoneNum);
    }

    public static char getSex(String sex) {
        if (sex.length() != 1 || (sex.charAt(0) != 'f' && sex.charAt(0) != 'm')) {
            throw new IllegalArgumentException("Неправильный ввод значения пола");
        }

        return sex.charAt(0);
    }

    public static Person createPeson(String data) {
        String[] strings = data.split(" ");
        if (dataQuantityCheck(strings) < 0) {
            throw new IllegalArgumentException();
        } else {
            String surname = getName(strings[0]);
            String name = getName(strings[1]);
            String patronymic = getName(strings[2]);
            String birthDate = getBirthDate(strings[3]);
            long phoneNum = getPhoneNum(strings[4]);
            char sex = getSex(strings[5]);
            return new Person(surname, name, patronymic, birthDate, phoneNum, sex);
        }
    }

    public static void writeData(Person person) {
        try (FileWriter fw = new FileWriter(person.getSurname() + ".txt", true)) {
            fw.write(person.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
