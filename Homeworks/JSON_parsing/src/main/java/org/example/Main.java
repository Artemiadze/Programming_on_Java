package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WEB users_sites = new WEB();
        WEB.call_Users();
        System.out.println("\n");
        WEB.call_Companies();
    }
}