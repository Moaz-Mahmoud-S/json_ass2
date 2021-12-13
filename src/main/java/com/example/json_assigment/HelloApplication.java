package com.example.json_assigment;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.Scanner;

@ApplicationPath("/api")
public class HelloApplication extends Application {

    public static void main(String[] args) throws IOException {
        String tittle, artist, company, year, price, country;
        int cdnum, choice;

        Scanner input = new Scanner(System.in);

        JSONObject j0 = new JSONObject();

        JSONObject cd = new JSONObject();

        JSONArray a1 = new JSONArray();

        JsonOperations j1 = new JsonOperations();

        while (true) {
            System.out.println("choose one of th following options");
            System.out.println("1-insert new cd's");
            System.out.println("2-search for cd with tittle");
            System.out.println("3-search for cd with artist");
            System.out.println("4-display all content");
            System.out.println("5-EXIT");

            choice = input.nextInt();
            if (choice > 5 || choice < 1)
                continue;
            if (choice == 1) {
                System.out.println("enter number of cd's");
                cdnum = input.nextInt();
                for (int i = 0; i < cdnum; i++) {
                    System.out.println("enter tittle");
                    tittle = input.next();
                    System.out.println("enter artist");
                    artist = input.next();
                    System.out.println("enter country");
                    country = input.next();
                    System.out.println("enter company");
                    company = input.next();
                    System.out.println("enter price");
                    price = input.next();
                    System.out.println("enter year");
                    year = input.next();

                    j0.put("TITLE", tittle);
                    j0.put("ARTIST", artist);
                    j0.put("COUNTRY", country);
                    j0.put("COMPANY", company);
                    j0.put("PRICE", price);
                    j0.put("YEAR", year);

                    cd.put("CD", j0);

                    a1.add(cd);


                }
                j1.write_to_json_file(a1);
            } else if (choice == 2) {
                System.out.println("Enter tittle:");
                String t1 = input.next();
                j1.search_with_tittle(t1);
            } else if (choice == 3) {
                System.out.println("Enter artist:");
                String t1 = input.next();
                j1.search_with_artist(t1);
            } else if (choice == 4) {
                j1.read_from_json_file();
            }
            else
                break;
        }


    }

}