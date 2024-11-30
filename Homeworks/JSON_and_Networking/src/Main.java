import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // URL для запроса
        URL url = new URL("https://fake-json-api.mock.beeceptor.com/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // Проверка успешности подключения
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
        }

        // Чтение JSON-ответа
        InputStream inputStream = connection.getInputStream();
        JsonReader jsonReader = Json.createReader(inputStream);
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();

        // Преобразование JSON в список объектов Users
        List<users> usersList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.getJsonObject(i);

            // Чтение полей из JSON
            int id = jsonObject.getInt("id");
            String name = jsonObject.getString("name", "");
            String company = jsonObject.getString("company", "");
            String username = jsonObject.getString("username", "");
            String email = jsonObject.getString("email", "");
            String address = jsonObject.getString("address", "");
            String zip = jsonObject.getString("zip", "");
            String state = jsonObject.getString("state", "");
            String country = jsonObject.getString("country", "");
            String phone = jsonObject.getString("phone", "");
            String photo = jsonObject.getString("photo", "");

            // Создание объекта Users
            users user = new users(id, name, company, username, email, address, zip, state, country, phone, photo);
            usersList.add(user);
        }
        System.out.println("Я здесь!");
        // Вывод списка пользователей
        for (users user : usersList) {
            System.out.println(user);
        }
    }
}