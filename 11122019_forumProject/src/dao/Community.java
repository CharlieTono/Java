package dao;

import data.Admin;
import data.User;

public class Community {

    User[] members;
    int size;

    public Community (int capacity) {
        members = new User[capacity];
        size = 0;
    }

    public boolean addMember (User user) {
        if (size < members.length) {
            members [size] = user;
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteMember (String userName) {
        for (int i = 0; i < size; i++) {
            if (members[i].getName().equalsIgnoreCase(userName)) {
                members[i] = members [size-1];
                size--;
                return true;
            }
        }
        return false;
    }

    public void displayAllMembers () {
        for (int i = 0; i < size; i++) {
            System.out.println(members[i]);
        }
    }

    public boolean isAdmin (String userName) {
        for (int i = 0; i < size; i++) {
            if (members[i].getName().equalsIgnoreCase(userName)) {
                if (members[i].getClass().getSimpleName().equalsIgnoreCase("Admin")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPasswordCorrect (String password) {
        for (int i = 0; i < size; i++) {
            if (members[i].getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }
}
