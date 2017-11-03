package com.company;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        UserPrinter userPrinter = new UserPrinter("users.txt");
        System.out.println(userPrinter.printUsers());
    }


}
