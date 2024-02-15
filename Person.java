package exceptionsSeminar3HW;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private long phoneNum;
    private char sex;

    public Person(String surname, String name, String patronymic, String birthDate, long phoneNum, char sex) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("<%s> <%s> <%s> <%s> <%d> <%c>",
                surname, name, patronymic, birthDate, phoneNum, sex);
    }
}
