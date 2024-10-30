import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = "";

        try {
            System.out.println("Введите имя файла:");
            file_name = reader.readLine();

            //начало работы с классом
            Dictionary work_with_my_file = new Dictionary();
            work_with_my_file.countAndWriteCharacterUsage(file_name);

        } catch (IOException ExObj1) {
            System.out.println("I/O error:" + ExObj1.getMessage());
        }
    }
}