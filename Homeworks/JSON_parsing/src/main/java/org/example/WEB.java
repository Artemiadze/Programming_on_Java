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

public class WEB {
    private static class Result {
        //вспомогательный класс для удобного хранения результатов работы с HTTP-соединением
        public final HttpURLConnection conn;  //объект соединения для управления запросом и его закрытия
        public final StringBuilder builder;   //данные, полученные от сервера.

        public Result(HttpURLConnection conn, StringBuilder builder) {
            this.conn = conn;
            this.builder = builder;
        }
    }

    private static HttpURLConnection getHttpURLConnection_Users(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // устанавливаем метод запроса как GET
        conn.setRequestProperty("Accept", "application/json"); //ждём ответа от сервера в формате json

        //проверка ответа от сервера
        if (conn.getResponseCode() != 200) {
            //выводит ошибку с её номером (200 - всё норм)
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        return conn;
    }

    private static List<Users> getUsers(JSONArray parsedData) {
        // преобразуем JSON в список, удобный для итерации

        // Список для объектов Users
        List<Users> usersList = new ArrayList<>();

        for (Object obj : parsedData) {
            JSONObject jsonObject = (JSONObject) obj;

            // Извлекаем данные из JSON-объекта
            int id = ((Long) jsonObject.get("id")).intValue();
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

    private static List<Companies> getCompanies(JSONArray parsedData) {
        // преобразуем JSON в список, удобный для итерации

        // Список для объектов Users
        List<Companies> usersCompanies = new ArrayList<>();

        for (Object obj : parsedData) {
            JSONObject jsonObject = (JSONObject) obj;

            // Извлекаем данные из JSON-объекта
            int id = ((Long) jsonObject.get("id")).intValue();
            String name = (String) jsonObject.get("name");
            String address = (String) jsonObject.get("address");
            String zip = (String) jsonObject.get("zip");
            String country = (String) jsonObject.get("country");
            int employeeCount = ((Long) jsonObject.get("employeeCount")).intValue();
            String industry = (String) jsonObject.get("industry");
            int marketCap = ((Long) jsonObject.get("marketCap")).intValue();
            String domain = (String) jsonObject.get("domain");
            String logo = (String) jsonObject.get("logo");
            String ceoName = (String) jsonObject.get("ceoName");

            // Создаем объект Users и добавляем в список
            Companies element_company = new Companies(id, name, address, zip, country, employeeCount, industry,
                    marketCap, domain, logo, ceoName);
            usersCompanies.add(element_company);
        }
        return usersCompanies;
    }

    static void call_Users(){
        try {
            //Создаём обьект URL
            URL url_users = new URL("https://fake-json-api.mock.beeceptor.com/users");
            HttpURLConnection conn = getHttpURLConnection_Users(url_users);

            BufferedReader br_1 = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            //Читаются данные из ответа сервера и записываются в объект StringBuilder
            String output_1;
            StringBuilder builder_1 = new StringBuilder();
            while ((output_1 = br_1.readLine()) != null) {
                builder_1.append(output_1);
            }
            Result result_1 = new Result(conn, builder_1);

            result_1.conn.disconnect();

            //Парсим JSON-ответ как массив
            Object parsedData_users = JSONValue.parse(result_1.builder.toString());
            //Проверяется, является ли JSON массивом (JSONArray)
            if (parsedData_users instanceof JSONArray) {
                List<Users> usersList = getUsers((JSONArray) parsedData_users);

                // Печатаем список Users в красивом формате
                for (Users user : usersList) {
                    System.out.println(user);
                }
            } else {
                System.out.println("The received data is not a JSON array.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void call_Companies() throws IOException {
        try {
            URL url_companies = new URL("https://fake-json-api.mock.beeceptor.com/companies");
            HttpURLConnection conn_2 = getHttpURLConnection_Users(url_companies);

            BufferedReader br_2 = new BufferedReader(new InputStreamReader((conn_2.getInputStream())));

            //Читаются данные из ответа сервера и записываются в объект StringBuilder
            String output_2;
            StringBuilder builder_2 = new StringBuilder();
            while ((output_2 = br_2.readLine()) != null) {
                builder_2.append(output_2);
            }
            Result result_1 = new Result(conn_2, builder_2);

            result_1.conn.disconnect();

            //Парсим JSON-ответ как массив
            Object parsedData_Companies = JSONValue.parse(result_1.builder.toString());
            //Проверяется, является ли JSON массивом (JSONArray)
            if (parsedData_Companies instanceof JSONArray) {
                List<Companies> usersCompanies = getCompanies((JSONArray) parsedData_Companies);

                // Печатаем список Users в красивом формате
                for (Companies one_company : usersCompanies) {
                    System.out.println(one_company);
                }
            } else {
                System.out.println("The received data is not a JSON array.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
