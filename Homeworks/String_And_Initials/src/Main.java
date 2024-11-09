import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        String full_name = console.nextLine();
        System.out.println("Введите дату рождения в формате дд_мм_гггг: ");
        String birth_date = console.nextLine();


        Person person = new Person(full_name, full_name.length());
        System.out.println("Инициалы: "+ person.getInitials()); //Печать инициалов персонвы
        System.out.println("Пол: "+ person.getGender());        //Печать пола персоны


        Age person_age = new Age(birth_date);
        System.out.println("Возраст: "+person_age.CalculatorAge());
    }
}