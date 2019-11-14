package data;

import java.util.Objects;

public class User {

    private String name;
    private int age;
    private Status status;

    public User(String name, int age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", age: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, status);
    }

    public String getPassword() {
        String password = "input";
        return password;
    }
}
