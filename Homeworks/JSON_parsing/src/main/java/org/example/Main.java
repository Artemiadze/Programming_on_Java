package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //Создаём обьект URL
            HttpURLConnection conn = getHttpURLConnection_Users();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            StringBuilder builder = new StringBuilder();
            while ((output = br.readLine()) != null) {
                builder.append(output);
            }
            Result result = new Result(conn, builder);

            result.conn.disconnect();


            // Парсим JSON-ответ как массив
            Object parsedData = JSONValue.parse(result.builder.toString());
            if (parsedData instanceof JSONArray) {
                List<Users> usersList = getUsers((JSONArray) parsedData);

                // Печатаем список Users (можно заменить на нужную обработку)
                for (Users user : usersList) {
                    System.out.println(user);
                }
            } else {
                System.out.println("Полученные данные не являются JSON-массивом.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Result {
        public final HttpURLConnection conn;
        public final StringBuilder builder;

        public Result(HttpURLConnection conn, StringBuilder builder) {
            this.conn = conn;
            this.builder = builder;
        }
    }

    private static HttpURLConnection getHttpURLConnection_Users() throws IOException {
        URL url = new URL("https://fake-json-api.mock.beeceptor.com/users");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // устанавливаем метод запроса как GET
        conn.setRequestProperty("Accept", "application/json"); //ждём ответа от сервера в формате json

        //проверка ответа от сервера
        if (conn.getResponseCode() != 200) {
            //выводит ошибку с её номером
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        return conn;
    }

    private static List<Users> getUsers(JSONArray parsedData) {

        // Список для объектов Users
        List<Users> usersList = new ArrayList<>();

        for (Object obj : parsedData) {
            JSONObject jsonObject = (JSONObject) obj;

            // Извлекаем данные из JSON-объекта
            int id = ((Long) jsonObject.get("id")).intValue(); // Преобразование Long в int
            String name = (String) jsonObject.get("name");
            String company = (String) jsonObject.get("company");
            String username = (String) jsonObject.get("username");
            String email = (String) jsonObject.get("email");
            String address = (String) jsonObject.get("address");
            String zip = (String) jsonObject.get("zip");
            String state = (String) jsonObject.get("state");
            String country = (String) jsonObject.get("country");
            String phone = (String) jsonObject.get("phone");
            String photo = (String) jsonObject.get("photo");

            // Создаем объект Users и добавляем в список
            Users user = new Users(id, name, company, username, email, address, zip, state, country, phone, photo);
            usersList.add(user);
        }
        return usersList;
    }
}