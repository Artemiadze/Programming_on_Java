import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        try {
            System.out.println("Введите имя файла:");
            fileName = reader.readLine();

            FileReader fileReader = new FileReader(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            int[] charCount = new int[26]; // массив для подсчета использования символов
            int c;

            while ((c = fileReader.read()) != -1) {
                if (Character.isLetter(c)) {
                    charCount[Character.toLowerCase(c) - 'a']++;
                }
            }
            writer.write( "\n"); //перевод строки
            for (int i = 0; i < 26; i++) {
                writer.write(((char)('a' + i)) + ": " + charCount[i] + "\n");
            }

            fileReader.close();
            writer.close();

            System.out.println("Результаты успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода названия файла: " + e.getMessage());
        }
    }
}