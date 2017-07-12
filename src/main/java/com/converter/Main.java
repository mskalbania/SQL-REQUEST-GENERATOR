package com.converter;

import java.util.Scanner;

/*
CSV SHOULD LOOK LIKE THIS
col_name,col_name2,col_name3...
value,value2,value3...

request.txt is generated at default path of jar
*/
public class Main {

    public static void main(String[] args) {

        String input;
        String tableName;
        if (args.length == 2){
            input = args[0];
            tableName = args[1];
        }
        else{
            Scanner sc = new Scanner(System.in);
            System.out.println("SPECIFY INPUT PATH: ");
            input = sc.next();
            System.out.println("TABLE NAME: ");
            tableName = sc.next();
        }
        Converter converter = new Converter(input, tableName);
        converter.writeRequest();
        System.out.println("REQUEST GENERATED");
    }
}
