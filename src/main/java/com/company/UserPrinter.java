package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class UserPrinter {
    private String fileName;
    private List<User> userList;

    public UserPrinter(String fileName) {
        this.fileName = fileName;
        this.userList = loadUsersToList(fileName);
    }

    private List loadUsersToList(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        Scanner sc = new Scanner(classLoader.getResourceAsStream(fileName)).useDelimiter("\n");

        ArrayList<User> userList = new ArrayList();

        while (sc.hasNext()) {
            User user = this.format(sc.next());

            userList.add(user);
        }
        sc.close();
        return userList;
    }

    public String printUsers() {
        StringBuilder stringBuilder = new StringBuilder();
        User oldestUser = getOldestUser();

        stringBuilder.append("Number of users: " + userList.size() + "\n");
        stringBuilder.append("Oldest user: " + oldestUser.getName() + " " + oldestUser.getPhoneNumber() + "\n");
        userList.forEach(user -> stringBuilder.append(user + "\n"));

        return stringBuilder.toString();
    }

    public User getOldestUser() {
        return userList.stream()
                .max(Comparator.comparing(User::getAge)).get();
    }

    public User format(String line) throws IllegalArgumentException {
        String[] split = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (split.length == 3) {
            return new User(split[0], split[1], LocalDate.parse(split[2].trim(), formatter));
        } else if (split.length == 4) {
            return new User(split[0], split[1], LocalDate.parse(split[2], formatter), split[3]);
        }
        throw new IllegalArgumentException("Wrong number of arguments");
    }
}
