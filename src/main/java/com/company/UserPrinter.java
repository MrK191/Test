package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        Scanner sc = new Scanner(classLoader.getResourceAsStream(fileName)).useDelimiter(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<User> userList = new ArrayList();

        while (sc.hasNext()) {
            User user = new User();

            user.setName(sc.next().trim());
            user.setSurename(sc.next());
            user.setBirthday(LocalDate.parse(sc.next(), formatter));
            user.setPhoneNumber(Integer.parseInt(sc.next()));

            userList.add(user);
        }

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

        User oldest = userList.get(0);
        for (int i = 0; i < userList.size(); i++) {
            if (oldest.getBirthday().isAfter(userList.get(i).getBirthday())) {
                oldest = userList.get(i);
            }
        }
        return oldest;
    }
}
