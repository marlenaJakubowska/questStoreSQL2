package com.codecool.queststore.model.users;

import com.codecool.queststore.dao.UserDao;

public class UserFactory {

//    private final UserDao userDao;
//
//    public UserFactory(UserDao userDao) {
//
//        this.userDao = new UserDao(connectDao);
//    }

    public static User create(int id, String firstName, String lastName,
                       Role role, boolean isActive, String login, String password) {

        switch (role.toString()) {
            case "ADMIN":
                User admin = new Admin(id, firstName, lastName, role, isActive, login, password);
                return admin;

            case "MENTOR":
                User mentor = new Mentor(id, firstName, lastName, role, isActive, login, password);
                return mentor;

            case "STUDENT":
                User student = new Student(id, firstName, lastName, role, isActive, login, password);
                return student;

            default:
                return null;

        }
    }
}
