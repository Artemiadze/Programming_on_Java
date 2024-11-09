import java.time.LocalDate;

public class Age {
    private final String birth_date;

    public Age(String birth_date){
        this.birth_date = birth_date;
    }

    //Определение возраста
    public String CalculatorAge(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        String[] birthday = birth_date.split("[_.\\s]");
        int age_year = year - Integer.parseInt(birthday[2]);
        int age_month = month - Integer.parseInt(birthday[1]);
        int age_day = day - Integer.parseInt(birthday[0]);

        //Если человеку несколько дней месяцев до ДР,
        // то вычитаем год, так как ему столько лет не сиполнилось в этом году
        if ((age_day < 0 && age_month <= 0)|| age_month < 0){
            age_year = age_year - 1;
        }

        String string_age = String.valueOf(age_year);
        if (age_year %10 == 1){
            string_age += " год";
        }
        else if (age_year % 10 > 1 && age_year % 10 < 5 && (age_year > 20 || age_year < 10)){
            string_age += " года";
        }
        else {
            string_age += " лет";
        }
        return string_age;
    }
}
