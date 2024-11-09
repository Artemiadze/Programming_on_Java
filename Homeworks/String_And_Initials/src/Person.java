public class Person {
    private final String full_name;
    private final int Len;


    public Person(String full_name, int Len){
        this.full_name = full_name;
        this.Len = Len;
    }

    // Преобразовать строку в массив символов
    public char[] makeCharArray(){
        return full_name.toCharArray();
    }


    //Определение инициалов
    public String getInitials(){
        String[] strings_for_init = full_name.split(" ");
        String initials = strings_for_init[0] + " ";    //Добавление фамилии
        char[] only_name = strings_for_init[1].toCharArray();
        initials = initials + only_name[0]+".";        //Добавление Первой буквы имени
        char[] patronymic = strings_for_init[2].toCharArray();
        initials = initials + patronymic[0] +".";      //Добавление Первой буквы отчества
        return initials;
    }


    public String getGender(){
        String gender = "М";
        char[] charArray = makeCharArray();
        if (charArray[Len-1] == 'а'){
            gender = "Ж";
        }
        return gender;
    }
}
