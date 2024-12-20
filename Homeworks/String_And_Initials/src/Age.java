import java.time.LocalDate;

public class Age {
    private final String birth_date;

    public Age(String birth_date){
        this.birth_date = birth_date;
    }

    //Определение возраста
    public String CalculatorAge(){
        //отсчитываем сегодняшную дату
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        //запоминаем дату рождения
        String[] birthday = birth_date.split("[_.\\s]"); //регулярные выражения наше всё
        int age_year = year - Integer.parseInt(birthday[2]);
        int age_month = month - Integer.parseInt(birthday[1]);
        int age_day = day - Integer.parseInt(birthday[0]);


        //проверка на корректность введённых данных для даты
        if (Integer.parseInt(birthday[0]) > 31 || Integer.parseInt(birthday[0]) <= 0){
            return "Неправильное значение для номера дня! Введите нормально!";
        }
        if (Integer.parseInt(birthday[1]) > 12 || Integer.parseInt(birthday[1]) < 1){
            return "Неправильное значение для номера месяца!  Введите нормально!";
        }
        if (Integer.parseInt(birthday[2]) > year || Integer.parseInt(birthday[2]) < 1){
            return "Неправильное значение для номера года!  Введите нормально!";
        }

        //Если человеку несколько дней месяцев до ДР,
        // то вычитаем год, так как ему столько лет не сиполнилось в этом году
        if ((age_day < 0 && age_month <= 0)|| age_month < 0){
            age_year = age_year - 1;
        }


        //добавляем годовое исчисление
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
