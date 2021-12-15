package com.example.json_assigment;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JsonOperations {

    void write_to_json_file (JSONArray catalog)
    {
        try {
            FileWriter file=new FileWriter("CD.json");
            file.write(catalog.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read_from_json_file () throws IOException {
        JSONParser parser=new JSONParser();
        try (FileReader file=new FileReader("CD.json")){

            Object obj=parser.parse(file);
            JSONArray CDlist=(JSONArray) obj;

            print_all(CDlist);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    JSONArray read_from_json_file_with_return () throws IOException {
        JSONParser parser=new JSONParser();
        JSONArray CDlist=new JSONArray();
        try (FileReader file=new FileReader("CD.json")){
            Object obj=parser.parse(file);
            CDlist=(JSONArray) obj;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (CDlist.size()==0)
            return null;
        else
            return  CDlist;
    }

    void search_with_tittle (String tittle) throws IOException {
        JSONArray JA1=new JSONArray();
        JSONObject j1=new JSONObject();
        JSONObject j2=new JSONObject();
        JA1=read_from_json_file_with_return();
        String t1;
        boolean isexist=false;
        if (JA1!=null)
        {
            for(int y=0;y<JA1.size();y++)
            {
                j1= (JSONObject) JA1.get(y);
                j2= (JSONObject) j1.get("CD");
                t1= (String) j2.get("TITLE");
                if (t1.equals(tittle))
                {

                    System.out.println("this album exist");
                    JSONObject json = new JSONObject((Map) j1.get("CD"));
                    System.out.println("Artist is:  "+json.get("ARTIST"));
                    System.out.println("Company is:  "+json.get("COMPANY"));
                    System.out.println("Country is:  "+json.get("COUNTRY"));
                    System.out.println("Price is:  "+json.get("PRICE"));
                    System.out.println("Tittle is:  "+json.get("TITLE"));
                    System.out.println("Year is:  "+json.get("YEAR"));

                    isexist=true;
                    break;
                }
            }
        }
        else if (JA1==null || isexist==false)
            System.out.println("this album isn't exist");
    }

    void search_with_artist (String artist) throws IOException {
        JSONArray JA1=new JSONArray();
        JSONObject j1=new JSONObject();
        JSONObject j2=new JSONObject();
        JA1=read_from_json_file_with_return();
        String t1;
        boolean isexist=false;
        if (JA1!=null)
        {
            for(int y=0;y<JA1.size();y++)
            {
                j1= (JSONObject) JA1.get(y);
                j2= (JSONObject) j1.get("CD");
                t1= (String) j2.get("ARTIST");
                if (t1.equals(artist))
                {
                    System.out.println("this album exist");
                    JSONObject json = new JSONObject((Map) j1.get("CD"));
                    System.out.println("Artist is:  "+json.get("ARTIST"));
                    System.out.println("Company is:  "+json.get("COMPANY"));
                    System.out.println("Country is:  "+json.get("COUNTRY"));
                    System.out.println("Price is:  "+json.get("PRICE"));
                    System.out.println("Tittle is:  "+json.get("TITLE"));
                    System.out.println("Year is:  "+json.get("YEAR"));
                    isexist=true;
                    break;
                }
            }
        }
        else if (JA1==null || isexist==false)
            System.out.println("this album isn't exist");
    }
    void print_all (JSONArray J1)
    {
        for (Object o : J1) {
            JSONObject json = new JSONObject((Map) o);
            json= (JSONObject) json.get("CD");
            System.out.println("Artist is:  "+json.get("ARTIST"));
            System.out.println("Company is:  "+json.get("COMPANY"));
            System.out.println("Country is:  "+json.get("COUNTRY"));
            System.out.println("Price is:  "+json.get("PRICE"));
            System.out.println("Tittle is:  "+json.get("TITLE"));
            System.out.println("Year is:  "+json.get("YEAR"));
            System.out.println("     ---------------------------------------------------------------------------------     ");

    }

    }
}

