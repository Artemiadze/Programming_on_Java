import java.io.*;

//класс для работы с файлами
public class Dictionary {
    public void countAndWriteCharacterUsage(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            // чтение посимвольно
            int[] charCount = new int[26]; // массив для подсчета использования english символов
            int symbol;

            //проверка на то, что данная буква из английского алфавита
            while (( symbol= fileReader.read()) != -1) {
                if (Character.isLetter(symbol) && Character.toLowerCase(symbol) >= 'a' &&
                        Character.toLowerCase(symbol) <= 'z') {
                    charCount[Character.toLowerCase(symbol) - 'a']++;
                }
            }
            //отступ в файле для удобства
            writer.write( "\n");

            //запись результата в файл
            for (int i = 0; i < 26; i++) {
                writer.write(((char)('a' + i)) + ": " + charCount[i] + "\n");
            }

            fileReader.close();
            writer.close();

            System.out.println("The result is successfully written to the specified file.");

        } catch (FileNotFoundException ExObj1) {
            System.out.println("File '"+fileName+"' not found or not exist!");
        } catch (IOException ExObj2) {
            System.out.println("I/O error!");
        }
    }
}
