package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WEB.call_Users(); //печать json данных с сайта users, предварительно запарсив их в массив и в класс Users
        System.out.println("\n");
        WEB.call_Companies(); //печать json данных с сайта companies, предварительно запарсив их в массив и в класс Companies
    }
}