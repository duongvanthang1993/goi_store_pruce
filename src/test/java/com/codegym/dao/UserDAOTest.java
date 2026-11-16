package com.codegym.dao;

import com.codegym.model.User;
import java.util.List;

public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        try {
            System.out.println("--- TEST 1: selectAllUsersSP ---");
            List<User> list = dao.selectAllUsersSP();
            for (User u : list) {
                System.out.println(u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - " + u.getCountry());
            }

            System.out.println("\n--- TEST 2: updateUserSP ---");
            if (!list.isEmpty()) {
                User firstUser = list.get(0);
                firstUser.setName("Minh SP Updated");
                firstUser.setCountry("Vietnam");
                boolean updated = dao.updateUserSP(firstUser);
                System.out.println("Update result: " + updated);
            }

            System.out.println("\n--- TEST 3: insert temporary user and deleteUserSP ---");
            User tempUser = new User("Delete Me", "del@example.com", "Nowhere");
            dao.insertUser(tempUser);
            List<User> updatedList = dao.selectAllUsersSP();
            int delId = -1;
            for (User u : updatedList) {
                if ("del@example.com".equals(u.getEmail())) {
                    delId = u.getId();
                    break;
                }
            }
            if (delId != -1) {
                boolean deleted = dao.deleteUserSP(delId);
                System.out.println("Delete ID " + delId + " result: " + deleted);
            }

            System.out.println("\n--- FINAL LIST AFTER TESTS ---");
            for (User u : dao.selectAllUsersSP()) {
                System.out.println(u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - " + u.getCountry());
            }

            System.out.println("\nALL TESTS PASSED SUCCESSFULLY!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

